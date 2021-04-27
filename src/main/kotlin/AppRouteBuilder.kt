import org.apache.camel.builder.RouteBuilder
import org.apache.camel.model.dataformat.JsonLibrary

class AppRouteBuilder(private val telegramData: TelegramData) : RouteBuilder() {

    override fun configure() {
        val tlg = "telegram:bots?authorizationToken=${this.telegramData.authorizationToken}"
        from(tlg)
            .routeId("chuck")
            .log("\${body.from.id}")
//            .filter(simple("\${body.from.id} != ${this.telegramData.allowedId}"))
//                .setBody(constant("I was forbidden to talk to you "))
//                .to(tlg)
//                .stop()
//            .end()
            .convertBodyTo(String::class.java)
            .choice()
                .`when`(simple("\${body.toLowerCase()} contains 'norris'"))
                    .to("http://api.icndb.com/jokes/random")
                    .unmarshal().json(JsonLibrary.Jackson)
                    .transform(simple("\${body[value][joke]}"))
                    .to(tlg)
                    .log("\${body}")
                .otherwise()
                    .log("Discarded: \${body}")
                    .log("\${body}")
                    .setBody(constant("I has nothing to say"))
                    .to(tlg)
    }
}
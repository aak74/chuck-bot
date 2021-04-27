import org.apache.camel.main.Main

fun main(args: Array<String>) {
    val main = Main()
    main.configure().addRoutesBuilder(AppRouteBuilder(Property().getTelegramData()))
    main.run(args)
}

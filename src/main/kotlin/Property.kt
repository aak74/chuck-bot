import java.io.FileInputStream
import java.io.IOException
import java.util.*

class Property {
    fun getTelegramData(): TelegramData {
        val props = "application.properties"
        try {
            val fis = FileInputStream("src/main/resources/$props")
            val properties = Properties()
            properties.load(fis)
            return TelegramData(
                properties.getProperty("authorizationToken").toString(),
                properties.getProperty("allowedId").toString(),
            )
        } catch (e: IOException) {
            System.err.println("File $props does not exists")
        }
        return TelegramData("","")
    }
}
package uiautotests.model

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By
import kotlin.test.assertEquals

class SampleAppPage {
    private val userNameField = By.id("f9822f86-5b90-c937-7a50-663aab9a74b6")
    private val passwordField = By.id("c3d95317-6ebc-eead-03a8-5c82e0405793")
    private val loginButton = By.id("login")
    private val textInfo = By.id("loginstatus")

    private val logger: Logger = LogManager.getLogger(SampleAppPage::class.java)

    fun fillTheUserNameField(userName: String) {
        element(userNameField).apply {
            click()
            clear()
            //sendKeys(Keys.chord(Keys.CONTROL, "a"))
            //sendKeys(Keys.BACK_SPACE)
            sendKeys(userName)
            logger.info("Ввели имя пользователя: $userName")
        }
    }

    fun fillThePasswordField(password: String) {
        element(passwordField).apply {
            click()
            clear()
            sendKeys(password)
            logger.info("Ввели пароль: $password")
        }
    }

    fun clickLoginButton() {
        element(loginButton).should(Condition.visible).click()
        logger.info("Логинимся")
    }

    fun checkLoginStatus(loginStatusMessage: String) {
        val actualLoginStatus = element(textInfo).should(Condition.visible).text
        assertEquals(loginStatusMessage, actualLoginStatus)
        logger.info("Статус логина: $actualLoginStatus")
    }
}
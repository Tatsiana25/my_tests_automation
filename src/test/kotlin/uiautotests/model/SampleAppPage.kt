package uiautotests.model

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By
import kotlin.test.assertEquals

class SampleAppPage {
    private val userNameField = By.name("UserName")
    private val passwordField = By.name("Password")
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
            logger.info("Ввод имени пользователя: $userName")
        }
    }

    fun fillThePasswordField(password: String) {
        element(passwordField).apply {
            click()
            clear()
            sendKeys(password)
            logger.info("Ввод пароля: $password")
        }
    }

    fun clickLoginButton(loginOrLogOut: String) {
        element(loginButton).should(Condition.visible).click()
        logger.info(loginOrLogOut)
    }

    fun checkLoginStatus(loginStatusMessage: String) {
        val actualLoginStatus = element(textInfo).should(Condition.visible).text
        assertEquals(loginStatusMessage, actualLoginStatus)
        logger.info("Статус входа: $actualLoginStatus")
    }
}
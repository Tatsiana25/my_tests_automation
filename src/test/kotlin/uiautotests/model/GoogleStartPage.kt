package uiautotests.model

import com.codeborne.selenide.Condition.visible
import org.openqa.selenium.By
import com.codeborne.selenide.Selenide.element

class GoogleStartPage {
    private val googleSearchString = By.className("RNNXgb")
    private val cookieAcceptanceForm = By.id("CXQnmb")
    private val declineAllButton = By.id("W0wltc")

    fun declineAll() {
        element(cookieAcceptanceForm).should(visible)
        element(declineAllButton).click()
        element(cookieAcceptanceForm).shouldNotBe(visible)
    }

    fun checkGoogleSearchString() {
        element(googleSearchString).should(visible)
    }
}
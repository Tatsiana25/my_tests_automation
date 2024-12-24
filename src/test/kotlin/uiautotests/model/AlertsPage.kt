package uiautotests.model

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.switchTo
import org.openqa.selenium.By

class AlertsPage {
    private val alertButton = By.id("alertButton")
    private val confirmButton = By.id("confirmButton")
    private val promptButton = By.id("promptButton")

    fun clickAlertButton() {
        element(alertButton).should(Condition.visible).click()
    }

    fun clickConfirmButton() {
        element(confirmButton).should(Condition.visible).click()
    }

    fun clickPromptButton() {
        element(promptButton).should(Condition.visible).click()
    }

    fun accept() {
        val popup = switchTo().alert()
        popup.accept()
    }

    fun dismiss() {
        val popup = switchTo().alert()
        popup.dismiss()
    }

    fun getTextFromPopup(): String {
        val popup = switchTo().alert()
        //val popupText = popup.text
        return popup.text
    }
}
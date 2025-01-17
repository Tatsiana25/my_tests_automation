package uiautotests.model

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.switchTo
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By
import uiautotests.utils.DateHelper

class AlertsPage {
    private val alertButton = By.id("alertButton")
    private val confirmButton = By.id("confirmButton")
    private val promptButton = By.id("promptButton")

    private val logger: Logger = LogManager.getLogger(AlertsPage::class.java)

    fun clickAlertButton() {
        element(alertButton).should(Condition.visible).click()
        logger.info("Переход к Alert")
    }

    fun clickConfirmButton() {
        element(confirmButton).should(Condition.visible).click()
        logger.info("Переход к Confirm")
    }

    fun clickPromptButton() {
        element(promptButton).should(Condition.visible).click()
        logger.info("Переход к Prompt")
    }

    fun accept() {
        val popup = switchTo().alert()
        popup.accept()
        logger.info("Подтверждение на всплывающем окне")
    }

    fun dismiss() {
        val popup = switchTo().alert()
        popup.dismiss()
        logger.info("Отмена на всплывающем окне")
    }

    fun getTextFromPopup(): String {
        val popup = switchTo().alert()
        //val popupText = popup.text
        return popup.text
    }

    fun checkDayOfWeek() {

    }
}
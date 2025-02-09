package uiautotests.model

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.files.DownloadActions.click
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.apache.logging.log4j.MarkerManager.clear
import org.openqa.selenium.By
import uiautotests.utils.DateHelper.Companion.getCurrentDayOfWeekFormatted
import kotlin.test.assertEquals

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
        logger.info("Подтверждение")
    }

    fun dismiss() {
        val popup = switchTo().alert()
        popup.dismiss()
        logger.info("Отмена")
    }

    private fun getTextFromPopup(): String {
        val popup = switchTo().alert()
        return popup.text
    }

    fun getDayOfWeek(): Boolean {
        val popupText = getTextFromPopup()
        logger.info("Текст на всплывающем окне: $popupText")

        val currentDay = getCurrentDayOfWeekFormatted()
        logger.info("Сегодня: $currentDay")

        return popupText.contains(currentDay, ignoreCase = true)
    }

    fun checkDayOfWeekAndClickButton(isFriday: Boolean) {
        if (isFriday) {
            accept()
            assertEquals("Yes", getTextFromPopup())
            logger.info("Нажата кнопка подтверждения, т.к. сегодня Пятница")
        }
        else {
            dismiss()
            assertEquals("No", getTextFromPopup())
            logger.info("Нажата кнопка отмены, т.к. сегодня НЕ Пятница")
        }
    }

    fun getValuesFromPrompt(): List<String> {
        val popupText = getTextFromPopup()
        // Выбираем значения в "" и ''
        val regex = Regex("""(["'])(.*?)(\1)""")
        val promptValues = regex
            .findAll(popupText)
            .map { it.groupValues[2] }
            .toList()
        logger.info("Список значений во всплывающем окне: $promptValues")
        return promptValues
    }

    fun getDefaultPromptValue(): String? {
        val popupText = getTextFromPopup()
        // Выбираем значение после "User value:"
        val regex = Regex("""User value:\s*(\w+)""")
        val defaultPromptValue = regex.find(popupText)?.groups?.get(1)?.value
        logger.info("Дефолтное значение: $defaultPromptValue")
        return defaultPromptValue
    }

    fun getNonDefaultValue(promptValues: List<String>, defaultPromptValue: String?): String? {

        if (defaultPromptValue != null && promptValues.contains(defaultPromptValue)) {
            logger.info("Дефолтное значение найдено в списке во всплывающем окне")

            // Перебираем значения в списке и возвращаем оставшееся несовпадающее
            for (nonDefaultValue in promptValues) {
                if (nonDefaultValue != defaultPromptValue) {
                    logger.info("Недефолтное значение: $nonDefaultValue")
                    return nonDefaultValue
                }
            }
            logger.info("Все значения в списке во всплывающем окне совпадают с дефолтным значением")
        } else {
            logger.info("Дефолтное значение не найдено в списке во всплывающем окне")
        }

        return null
    }

    fun setNonDefaultValueInPrompt(nonDefaultValue: String?) {
        val prompt = switchTo().alert()
        prompt.apply {
            click()
            clear()
            sendKeys(nonDefaultValue)
        }
        logger.info("Вставка значения в поле на всплывающем окне")
    }

    fun checkValue(nonDefaultValue: String?) {
        val popupText = getTextFromPopup()
        val regex = Regex("""User value:\s*(\w+)""")
        val actualPromptValue = regex.find(popupText)?.groups?.get(1)?.value

        assertEquals(nonDefaultValue, actualPromptValue, "Введено неверное значение: $actualPromptValue")
        logger.info("Введено недефолтное значение: $nonDefaultValue")
    }

}
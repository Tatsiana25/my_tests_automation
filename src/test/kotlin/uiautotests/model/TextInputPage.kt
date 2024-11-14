package uiautotests.model

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.openqa.selenium.By
import kotlin.test.assertEquals

class TextInputPage {
    private val buttonNameField = By.id("newButtonName")
    private val confirmButton = By.id("updatingButton")
    private val logger: Logger = LogManager.getLogger(ClickPage::class.java)


    fun setButtonName(newButtonName: String) {
        element(buttonNameField).apply {
            click()
            clear()
            //sendKeys(Keys.chord(Keys.CONTROL, "a"))
            //sendKeys(Keys.BACK_SPACE)
            sendKeys(newButtonName)
            logger.info("Ввели в поле значение: $newButtonName")
        }
    }

    fun getButtonName(): String? {
        val currentButtonName = element(confirmButton).text
        logger.info("Текущее название кнопки: $currentButtonName")
        return currentButtonName
    }

    fun clickConfirmButton() {
        element(confirmButton).should(visible).click()
        logger.info("Клик по кнопке")
    }

    fun checkButtonName(currentButtonName: String?, newButtonName: String, expectedResult: Boolean) {
        logger.info("Сравнение названия кнопки с текстом в поле")
        if (expectedResult) {
            element(confirmButton).shouldBe(visible)
            assertEquals(newButtonName, currentButtonName, "Текст не соответствует названию кнопки")
        } else
            assertNotEquals(newButtonName, currentButtonName, "Текст соответствует названию кнопки")
    }
}
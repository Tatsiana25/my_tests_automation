package uiautotests.model

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import kotlin.test.assertEquals

class TextInputPage {
    private val buttonNameField = By.id("newButtonName")
    private val confirmButton = By.id("updatingButton")

    // Переменная для хранения названия кнопки
    private var newButtonName: String? = null


    fun setButtonName(newButtonName: String) {
        element(buttonNameField).apply {
            sendKeys(Keys.chord(Keys.CONTROL, "a"))
            sendKeys(Keys.BACK_SPACE)
            sendKeys(newButtonName)
        }
        this.newButtonName = newButtonName
    }

    fun clickConfirmButton() {
        element(confirmButton).should(visible).click()
    }

    fun checkButtonName() {
        element(confirmButton).shouldBe(visible)
        assertEquals(newButtonName, element(confirmButton).text, "Текст не соответствует названию кнопки")

    }
}
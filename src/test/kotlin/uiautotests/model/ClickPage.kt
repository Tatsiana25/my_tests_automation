package uiautotests.model

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import org.junit.jupiter.api.Assertions.assertEquals
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class ClickPage {
    private val driver: WebDriver = WebDriverRunner.getWebDriver()
    private val button: WebElement

    init {
        // Инициализация WebDriver и поиск элемента
        button = Selenide.`$`("#badButton")
    }


    fun physicalClick() {
        val actions = Actions(driver)
        actions.moveToElement(button).click().perform()
    }


    fun simpleClick() {
        try {
            if (button.isDisplayed && button.isEnabled) {
                val jsExecutor = driver as JavascriptExecutor
                jsExecutor.executeScript("arguments[0].click();", button)
            }
        } catch (e: Exception) {
            println("Ошибка при выполнении клика: ${e.message}")
        }
    }

    //Имя класса должно измениться (true), если кнопка нажата (физически)
    fun isClassNameChanged(expected: Boolean) {
        val className = button.getAttribute("class")
        println("className после клика: $className\nПервичный className: btn btn-primary")
        val classNameChanged = className.contains("btn-success")
        assertEquals(expected, classNameChanged)
    }
}
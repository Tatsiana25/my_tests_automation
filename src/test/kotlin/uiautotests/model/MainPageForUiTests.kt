package uiautotests.model

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element
import org.openqa.selenium.By

class MainPageForUiTests {
    private val dynamicIdButton = By.xpath("//a[text()='Dynamic ID']")
    private val classAttributeButton = By.xpath("//a[text()='Class Attribute']")
    private val loadDelayButton = By.xpath("//a[text()='Class Attribute']")
    private val ajaxDataButton = By.xpath("//a[text()='AJAX Data']")
    private val clickButton = By.xpath("//a[text()='Click']")
    private val textInputButton = By.xpath("//a[text()='Text Input']")
    private val scrollbarsButton = By.xpath("//a[text()='Scrollbars']")

    fun goToDynamicIdPage() {
        element(dynamicIdButton).should(visible).click()
    }

    fun goToClassAttributePage() {
        element(classAttributeButton).should(visible).click()
    }

    fun goToLoadDelayPage() {
        element(loadDelayButton).should(visible).click()
    }

    fun goToAjaxDataPage() {
        element(ajaxDataButton).should(visible).click()
    }

    fun goToClickPage() {
        element(clickButton).should(visible).click()
    }

    fun goToTextInputPage() {
        element(textInputButton).should(visible).click()
    }

    fun goToScrollbarsPage() {
        element(scrollbarsButton).should(visible).click()
    }
}
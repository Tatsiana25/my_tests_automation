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
    private val dynamicTableButton = By.xpath("//a[text()='Dynamic Table']")
    private val progressBarButton = By.xpath("//a[text()='Progress Bar']")
    private val sampleAppButton = By.xpath("//a[text()='Sample App']")
    private val alertsButton = By.xpath("//a[text()='Alerts']")

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

    fun goToDynamicTablePage() {
        element(dynamicTableButton).should(visible).click()
    }

    fun goToProgressBarPage() {
        element(progressBarButton).should(visible).click()
    }

    fun goToSampleAppPage() {
        element(sampleAppButton).should(visible).click()
    }

    fun goToAlertsPage() {
        element(alertsButton).should(visible).click()
    }
}
package uiautotests.model

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element
import org.openqa.selenium.By

class MainPageForUiTests : BasePage() {
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
        goToPage(dynamicIdButton)
    }

    fun goToClassAttributePage() {
        goToPage(classAttributeButton)
    }

    fun goToLoadDelayPage() {
        goToPage(loadDelayButton)
    }

    fun goToAjaxDataPage() {
        goToPage(ajaxDataButton)
    }

    fun goToClickPage() {
        goToPage(clickButton)
    }

    fun goToTextInputPage() {
        goToPage(textInputButton)
    }

    fun goToScrollbarsPage() {
        goToPage(scrollbarsButton)
    }

    fun goToDynamicTablePage() {
        goToPage(dynamicTableButton)
    }

    fun goToProgressBarPage() {
        goToPage(progressBarButton)
    }

    fun goToSampleAppPage() {
        goToPage(sampleAppButton)
    }

    fun goToAlertsPage() {
        goToPage(alertsButton)
    }
}
package uiautotests.model

import com.codeborne.selenide.*
import com.codeborne.selenide.Selenide.element
import org.openqa.selenium.*

class AjaxDataPage {
    private val triggeringAjaxRequestButton = By.id("ajaxButton")
    private val fieldOfLoadedData = By.className("bg-success")

    fun clickTriggeringAjaxRequestButton() {
        Selenide.element(triggeringAjaxRequestButton).should(Condition.visible).click()
    }

    fun checkLoadedDataInTheField(value: String): SelenideElement {
       return element(fieldOfLoadedData).shouldHave(Condition.text(value))
    }
}
package uiautotests.model

import com.codeborne.selenide.*
import com.codeborne.selenide.Selenide.element
import org.openqa.selenium.*
import java.time.Duration
import kotlin.test.assertEquals

class AjaxDataPage {
    private val triggeringAjaxRequestButton = By.id("ajaxButton")
    private val fieldOfLoadedData = By.className("bg-success")

    fun clickTriggeringAjaxRequestButton() {
        element(triggeringAjaxRequestButton).should(Condition.visible).click()
    }

    fun checkLoadedDataInTheField(value: String) {
        element(fieldOfLoadedData).shouldBe(Condition.visible, Duration.ofSeconds(16))
        assertEquals((element(fieldOfLoadedData).text), value)
    }
}
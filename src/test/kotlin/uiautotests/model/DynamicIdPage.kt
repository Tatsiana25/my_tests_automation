package uiautotests.model

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import org.openqa.selenium.By

class DynamicIdPage {
    private val dynamicIdButton = By.xpath(".//button[text()='Button with Dynamic ID']")
    //private val dynamicIdInDynamicIdButton = By.xpath()

    fun clickDynamicIdButton() {
        Selenide.element(dynamicIdButton).should(visible).click()
    }

    fun getDynamicId(): String? {
        return element(dynamicIdButton).attr("id")
    }
}
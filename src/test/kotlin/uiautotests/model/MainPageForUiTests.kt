package uiautotests.model

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element
import org.openqa.selenium.By

class MainPageForUiTests {
    private val dynamicIdButton = By.xpath("//a[text()='Dynamic ID']")

    fun goToDynamicIdPage() {
        element(dynamicIdButton).should(visible).click()
    }
}
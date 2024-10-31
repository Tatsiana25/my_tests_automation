package uiautotests.model

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element
import org.openqa.selenium.By

class MainPageForUiTests {
    private val dynamicIdButton = By.xpath("//a[text()='Dynamic ID']")
    private val classAttribute = By.xpath("//a[text()='Class Attribute']")

    fun goToDynamicIdPage() {
        element(dynamicIdButton).should(visible).click()
    }

    fun goToClassAttributePage() {
        element(classAttribute).should(visible).click()
    }
}
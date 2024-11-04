package uiautotests.model

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element
import org.openqa.selenium.By

class MainPageForUiTests {
    private val dynamicIdButton = By.xpath("//a[text()='Dynamic ID']")
    private val classAttributeButton = By.xpath("//a[text()='Class Attribute']")
    private val loadDelayButton = By.xpath("//a[text()='Class Attribute']")

    fun goToDynamicIdPage() {
        element(dynamicIdButton).should(visible).click()
    }

    fun goToClassAttributePage() {
        element(classAttributeButton).should(visible).click()
    }

    fun goToLoadDelayPage() {
        element(loadDelayButton).should(visible).click()
    }
}
package uiautotests.model.uitestingplayground

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import org.openqa.selenium.By

open class BasePage {

    fun goToPage(element: By) {
        Selenide.element(element).should(Condition.visible).click()
    }
}
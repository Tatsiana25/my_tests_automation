package uiautotests.model

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import org.openqa.selenium.By

class LoadDelayPage {
    private val appearingAfterDelayButton = By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]")

    fun clickAppearingAfterDelayButton() {
        Selenide.element(appearingAfterDelayButton).should(Condition.visible).click()
    }
}
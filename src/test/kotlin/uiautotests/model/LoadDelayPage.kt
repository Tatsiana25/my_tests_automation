package uiautotests.model

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.element
import org.openqa.selenium.By
import java.time.Duration

class LoadDelayPage {
    private val appearingAfterDelayButton =
        By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]")

    fun clickAppearingAfterDelayButton() {
        element(appearingAfterDelayButton).shouldBe(Condition.visible, Duration.ofSeconds(15)).click()
    }
}
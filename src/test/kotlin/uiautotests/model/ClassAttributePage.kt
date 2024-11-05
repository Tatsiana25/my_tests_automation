package uiautotests.model

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.switchTo
import org.openqa.selenium.By

class ClassAttributePage {
    private val bluePrimaryButton =
        By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]")

    fun clickBluePrimaryButton() {
        element(bluePrimaryButton).should(Condition.visible).click()
    }

    fun acceptPrimaryAlert() {
        // Переключаемся на алерт
        val alert = switchTo().alert()
        // Нажимаем кнопку OK на алерте
        alert.accept()
    }
}
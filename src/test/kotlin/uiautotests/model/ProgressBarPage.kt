package uiautotests.model

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.element
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By
import kotlin.properties.Delegates
import kotlin.test.assertTrue

class ProgressBarPage {
    private val startButton = By.id("startButton")
    private val stopButton = By.id("stopButton")
    private val progressBar = By.id("progressBar")

    private var progressValue by Delegates.notNull<Int>()

    private val logger: Logger = LogManager.getLogger(ProgressBarPage::class.java)

    private fun getProgress(): Int? {
        return element(progressBar).getAttribute("aria-valuenow")?.toIntOrNull()
    }

    fun displayProgress() {
        progressValue = getProgress()!!
        logger.info("Прогресс загрузки: $progressValue")
    }

    fun clickStartButton() {
        logger.info("Старт загрузки")
        element(startButton).should(Condition.visible).click()
    }

    private fun clickStopButton() {
        logger.info("Остановка загрузки")
        element(stopButton).should(Condition.visible).click()
    }

    fun monitorProgressAndStop(percent: Int) {
        while (true) {
            progressValue = getProgress()!!
            if (progressValue == percent) {
                clickStopButton()
                break
            }
        }
    }

    fun checkProgress(from: Int, to: Int) {
        progressValue = getProgress()!!
        assertTrue(progressValue >= from, "Значение должно быть больше или равно $from")
        assertTrue(progressValue < to, "Значение должно быть меньше $to")
        logger.info("Ожидаемый прогресс загрузки: $from%-$to% Фактический прогресс загрузки: $progressValue%")
    }
}
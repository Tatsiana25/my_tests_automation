package uiautotests.uitestingplayground.progressbar

import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.*
import uiautotests.config.BaseTest
import uiautotests.model.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тест со шкалой загрузки")
class ProgressBarTest: BaseTest() {

    private val mainPageForUiTests = MainPageForUiTests()
    private val progressBarPage = ProgressBarPage()

    @BeforeAll
    override fun beforeAll() {
        super.beforeAll()
    }

    @BeforeEach
    override fun beforeEach() {
        super.beforeEach()
        Selenide.open("http://uitestingplayground.com/")
    }

    @Test
    @DisplayName("Загрузку можно остановить на 75%")
    fun downloadCanBeStoppedAt75() {
        mainPageForUiTests.goToProgressBarPage()
        progressBarPage.displayProgress()
        progressBarPage.clickStartButton()
        progressBarPage.monitorProgressAndStop(75)
        progressBarPage.displayProgress()
        progressBarPage.checkProgress(74, 83)
    }
}
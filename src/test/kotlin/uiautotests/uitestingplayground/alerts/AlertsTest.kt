package uiautotests.uitestingplayground.alerts

import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.*
import uiautotests.config.BaseTest
import uiautotests.model.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тест с всплывающими окнами")
class AlertsTest: BaseTest() {

    private val mainPageForUiTests = MainPageForUiTests()
    private val alertsPage = AlertsPage()

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
    @DisplayName("Кнопка подтверждения нажимается после появления алерта")
    fun pressingTheOkButtonAfterTheAlertAppears() {
        mainPageForUiTests.goToAlertsPage()
        alertsPage.clickAlertButton()
        alertsPage.dismiss()
    }

    @Test
    @DisplayName("Кнопка подтверждения нажимается после появления конфирма, если сегодня пятница")
    fun pressingTheOkButtonAfterTheConfirmAppearsIfTodayIsFriday() {
        mainPageForUiTests.goToAlertsPage()
        alertsPage.clickConfirmButton()
        val isFriday = alertsPage.getDayOfWeek()
        alertsPage.checkDayOfWeekAndClickButton(isFriday)
    }
}
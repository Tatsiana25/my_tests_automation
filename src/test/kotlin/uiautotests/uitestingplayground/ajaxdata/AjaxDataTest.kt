package uiautotests.uitestingplayground.ajaxdata

import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.*
import uiautotests.config.BaseTest
import uiautotests.model.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тест с ожиданием текста после нажатия кнопки")
class AjaxDataTest: BaseTest() {

    private val mainPageForUiTests = MainPageForUiTests()
    private val ajaxDataPage = AjaxDataPage()

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
    @DisplayName("Текст появляется после ожидания")
    fun textAppearingAfterTriggeringAjaxRequestButtonClicking() {
        mainPageForUiTests.goToAjaxDataPage()
        ajaxDataPage.clickTriggeringAjaxRequestButton()
        ajaxDataPage.checkLoadedDataInTheField("Data loaded with AJAX get request.")
    }
}
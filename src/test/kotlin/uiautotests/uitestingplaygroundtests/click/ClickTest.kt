package uiautotests.uitestingplaygroundtests.click

import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.*
import uiautotests.config.BaseTest
import uiautotests.model.*
import uiautotests.model.uitestingplayground.ClickPage
import uiautotests.model.uitestingplayground.MainPageForUiTests

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тест с доступностью только физического клика")
class ClickTest: BaseTest() {

    private val mainPageForUiTests = MainPageForUiTests()
    private lateinit var clickPage: ClickPage

    @BeforeAll
    override fun beforeAll() {
        super.beforeAll()
    }

    @BeforeEach
    override fun beforeEach() {
        super.beforeEach()
        Selenide.open("http://uitestingplayground.com/")
        clickPage = ClickPage()
    }

    @AfterEach
    override fun afterEach() {
        super.afterEach()
    }

    @Test
    @DisplayName("Физический клик по кнопке осуществляется (изменяется имя класса кнопки)")
    fun physicalClick() {
        mainPageForUiTests.goToClickPage()
        clickPage.physicalClick()
        clickPage.isClassNameChanged(true)
    }

    @Test
    @DisplayName("Обычный клик по кнопке не осуществляется (НЕ изменяется имя класса кнопки)")
    fun simpleClick() {
        mainPageForUiTests.goToClickPage()
        clickPage.simpleClick()
        clickPage.isClassNameChanged(false)
    }
}
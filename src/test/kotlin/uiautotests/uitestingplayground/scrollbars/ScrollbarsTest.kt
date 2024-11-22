package uiautotests.uitestingplayground.scrollbars

import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.*
import uiautotests.config.BaseTest
import uiautotests.model.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тест со спрятанной кнопкой")
class ScrollbarsTest: BaseTest() {

    private val mainPageForUiTests = MainPageForUiTests()
    private lateinit var scrollbarsPage: ScrollbarsPage

    @BeforeAll
    override fun beforeAll() {
        super.beforeAll()
    }

    @BeforeEach
    override fun beforeEach() {
        super.beforeEach()
        Selenide.open("http://uitestingplayground.com/")
        scrollbarsPage = ScrollbarsPage()
    }

    @Test
    @DisplayName("Кнопка видна после скролла")
    fun checkHiddenButton() {
        mainPageForUiTests.goToScrollbarsPage()
        scrollbarsPage.checkButtonDisplayed(true)
        scrollbarsPage.scrollToHidingButton()
        scrollbarsPage.checkButtonDisplayed(false)
    }
}
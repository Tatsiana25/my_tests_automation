package uiautotests.uitestingplayground.textinput

import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.*
import uiautotests.config.BaseTest
import uiautotests.model.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тест с вводом текста")
class TextInputTest: BaseTest() {

    private val mainPageForUiTests = MainPageForUiTests()
    private val textInputPage = TextInputPage()

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
    @DisplayName("Название кнопки меняется после ввода текста")
    fun buttonNameIsChangedAfterTextInput() {
        mainPageForUiTests.goToTextInputPage()
        textInputPage.setButtonName("Новое название кнопки")
        textInputPage.clickConfirmButton()
        textInputPage.checkButtonName()
    }
}
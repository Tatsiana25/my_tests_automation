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

    private var newButtonName = "Новое название кнопки"


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
        textInputPage.checkButtonName(textInputPage.getButtonName(), newButtonName, false)
        textInputPage.setButtonName(newButtonName)
        textInputPage.clickConfirmButton()
        textInputPage.checkButtonName(textInputPage.getButtonName(), newButtonName, true)
    }
}
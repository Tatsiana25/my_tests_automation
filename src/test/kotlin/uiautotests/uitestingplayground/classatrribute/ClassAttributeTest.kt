package uiautotests.uitestingplayground.classatrribute

import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.*
import uiautotests.config.BaseTest
import uiautotests.model.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тест с атрибутами класса (у класса в названии пробелы)")
class ClassAttributeTest: BaseTest()  {

    private val mainPageForUiTests = MainPageForUiTests()
    private val classAttributePage = ClassAttributePage()

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
    @DisplayName("Клик по синей кнопке осуществляется + подтверждение алерта")
    fun clickBluePrimaryButtonAndAcceptAlertIsPossible() {
        mainPageForUiTests.goToClassAttributePage()
        classAttributePage.clickBluePrimaryButton()
        classAttributePage.acceptPrimaryAlert()
    }
}
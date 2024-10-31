package uiautotests.uitestingplayground.classatrribute

import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.*
import uiautotests.config.BaseTest
import uiautotests.model.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тест с атрибутами класса")
class ClassAttributeTest: BaseTest()  {

    private val mainPageForUiTests = MainPageForUiTests()
    private val classAttributePage = ClassAttributePage()

    @BeforeAll
    override fun beforeAll() {
        super.beforeAll()
    }

    @BeforeEach
    override fun beforeEach() {
        Selenide.open("http://uitestingplayground.com/")
    }

    @Test
    @DisplayName("Клик по синей кнопке осуществляется + подтверждение асерта")
    fun clickBluePrimaryButtonAndAcceptAlertIsPossible() {
        mainPageForUiTests.goToClassAttributePage()
        classAttributePage.clickBluePrimaryButton()
        classAttributePage.acceptPrimaryAlert()
    }
}
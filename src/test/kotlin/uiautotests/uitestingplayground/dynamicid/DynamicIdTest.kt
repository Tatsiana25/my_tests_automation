package uiautotests.uitestingplayground.dynamicid

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.refresh
import org.junit.jupiter.api.*
import uiautotests.config.BaseTest
import uiautotests.model.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тест с динамическим ID")
class DynamicIdTest: BaseTest() {

    private val mainPageForUiTests = MainPageForUiTests()
    private val dynamicIdPage = DynamicIdPage()

    @BeforeAll
    override fun beforeAll() {
        super.beforeAll()
    }

    @BeforeEach
    override fun beforeEach() {
        Selenide.open("http://uitestingplayground.com/")
    }

    @Test
    @DisplayName("Клик по кнопке с динамичным ID совершается")
    fun clickOnDynamicIdButtonIsPossible() {
        mainPageForUiTests.goToDynamicIdPage()

        // Получаем начальный ID кнопки
        val initialId = dynamicIdPage.getDynamicId()

        dynamicIdPage.clickDynamicIdButton()
        refresh()

        // Получаем новый ID кнопки
        val newId = dynamicIdPage.getDynamicId()

        dynamicIdPage.clickDynamicIdButton()

        // Проверяем, что ID изменился (неэквивалентность)
        assert(initialId != newId) {
            "ID кнопки не изменился. Начальный ID: $initialId, Новый ID: $newId"
        }
    }

}
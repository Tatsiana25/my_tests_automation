package uiautotests.uitestingplayground.dynamictable

import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.*
import uiautotests.config.BaseTest
import uiautotests.model.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тест с динамической таблицей")
class DynamicTableTest: BaseTest() {

    private val mainPageForUiTests = MainPageForUiTests()
    private val dynamicTablePage = DynamicTablePage()

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
    @DisplayName("Значение Chrome CPU из таблицы совпадает со значением в строке")
    fun cellAndLineCpuChromeValuesAreEqual() {
        mainPageForUiTests.goToDynamicTablePage()
        dynamicTablePage.checkChromeCpu()
    }
}
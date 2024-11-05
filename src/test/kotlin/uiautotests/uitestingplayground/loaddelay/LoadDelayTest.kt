package uiautotests.uitestingplayground.loaddelay

import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.*
import uiautotests.config.BaseTest
import uiautotests.model.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тест с задержкой загрузки страницы")
class LoadDelayTest: BaseTest() {

    private val mainPageForUiTests = MainPageForUiTests()
    private val loadDelayPage = LoadDelayPage()

    @BeforeAll
    override fun beforeAll() {
        super.beforeAll()
    }

    @BeforeEach
    override fun beforeEach() {
        Selenide.open("http://uitestingplayground.com/")
    }

    @Test
    @DisplayName("Ожидание загрузки кнопки для клика осуществляется")
    fun clickAppearingAfterDelayButton() {
        mainPageForUiTests.goToLoadDelayPage()
        /* Элемент ожидается из-за установки глобального таймаута
           Configuration.timeout = 20000
           в классе BaseTest */
        loadDelayPage.clickAppearingAfterDelayButton()
    }
}
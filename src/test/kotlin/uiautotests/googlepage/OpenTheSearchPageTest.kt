package uiautotests.googlepage

import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.*
import uiautotests.config.BaseTest
import uiautotests.model.GoogleStartPage

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Стартовая страница гугла")
class OpenTheSearchPageTest: BaseTest() {

    private val googleStartPage = GoogleStartPage()

    @BeforeAll
    override fun beforeAll() {
        super.beforeAll()
    }

    @BeforeEach
    override fun beforeEach() {
        Selenide.open("/")
    }

    @Test
    @DisplayName("Открывается стартовая страница гугла")
    fun startGooglePageIsOpened() {
        googleStartPage.checkGoogleSearchString()
    }
}
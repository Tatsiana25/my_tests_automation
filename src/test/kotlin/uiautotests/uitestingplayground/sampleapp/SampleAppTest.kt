package uiautotests.uitestingplayground.sampleapp

import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.*
import uiautotests.config.BaseTest
import uiautotests.model.*
import uiautotests.uitestingplayground.sampleapp.LoginStatusesConstants.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тесты для страницы Логин")
class SampleAppTest: BaseTest() {

    private val mainPageForUiTests = MainPageForUiTests()
    private val sampleAppPage = SampleAppPage()

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
    @DisplayName("Логин с валидным именем пользователя и паролем происходит успешно")
    fun successfulLoginWithValidUserNameAndPassword() {

    }
}
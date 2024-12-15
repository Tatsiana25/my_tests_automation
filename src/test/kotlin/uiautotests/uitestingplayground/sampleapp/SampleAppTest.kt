package uiautotests.uitestingplayground.sampleapp

import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.Arguments
import uiautotests.config.BaseTest
import uiautotests.model.*
import uiautotests.uitestingplayground.sampleapp.LoginStatusesConstants.Companion.SUCCESSFUL_LOGIN_STATUS_TEMPLATE
import uiautotests.uitestingplayground.sampleapp.LoginStatusesConstants.Companion.UNLOGGING_STATUS
import uiautotests.uitestingplayground.sampleapp.LoginStatusesConstants.Companion.UNSUCCESSFUL_LOGIN_STATUS
import java.util.stream.Stream
import kotlin.properties.Delegates

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Тесты для страницы Логин")
class SampleAppTest: BaseTest() {

    private val mainPageForUiTests = MainPageForUiTests()
    private val sampleAppPage = SampleAppPage()

    private var userName by Delegates.notNull<String>()
    private var password by Delegates.notNull<String>()
    private val login = "Вход"
    private val logOut = "Выход"

    @BeforeAll
    override fun beforeAll() {
        super.beforeAll()
    }

    @BeforeEach
    override fun beforeEach() {
        super.beforeEach()
        Selenide.open("http://uitestingplayground.com/")
    }

    @AfterEach
    override fun afterEach() {
        sampleAppPage.clickLoginButton(logOut)
        super.afterEach()
    }

    @Test
    @DisplayName("Вход с валидным именем пользователя и паролем происходит успешно")
    fun successfulLoginWithValidUserNameAndPassword() {
        userName = "Alex123"
        password = "pwd"
        val successfulLoginStatus = String.format(SUCCESSFUL_LOGIN_STATUS_TEMPLATE, userName)

        mainPageForUiTests.goToSampleAppPage()
        sampleAppPage.checkLoginStatus(UNLOGGING_STATUS)
        sampleAppPage.fillTheUserNameField(userName)
        sampleAppPage.fillThePasswordField(password)
        sampleAppPage.clickLoginButton(login)
        sampleAppPage.checkLoginStatus(successfulLoginStatus)
    }

    @Test
    @DisplayName("Вход с пустым именем пользователя не происходит")
    fun unsuccessfulLoginWithEmptyUserName() {
        userName = ""
        password = "pwd"

        mainPageForUiTests.goToSampleAppPage()
        sampleAppPage.checkLoginStatus(UNLOGGING_STATUS)
        sampleAppPage.fillTheUserNameField(userName)
        sampleAppPage.fillThePasswordField(password)
        sampleAppPage.clickLoginButton(login)
        sampleAppPage.checkLoginStatus(UNSUCCESSFUL_LOGIN_STATUS)
    }

    @ParameterizedTest(name = "Вход с {0} не происходит")
    @MethodSource("invalidPasswords")
    @DisplayName("Вход с невалидным паролем не происходит")

    fun unsuccessfulLoginWithInvalidPassword(passwordName: String, password: String) {
        userName = "Alex123"

        mainPageForUiTests.goToSampleAppPage()
        sampleAppPage.checkLoginStatus(UNLOGGING_STATUS)
        sampleAppPage.fillTheUserNameField(userName)
        sampleAppPage.fillThePasswordField(password)
        sampleAppPage.clickLoginButton(login)
        sampleAppPage.checkLoginStatus(UNSUCCESSFUL_LOGIN_STATUS)
    }

    private fun invalidPasswords(): Stream<Arguments> {
        return Stream.of(
            Arguments.of("неправильным паролем (не pwd)", "123"),
            Arguments.of("пустым паролем", "")
        )
    }
}
package uiautotests.config

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.closeWebDriver
import com.codeborne.selenide.WebDriverRunner
import org.junit.jupiter.api.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.sql.DriverManager

open class BaseTest {
    @BeforeAll
    open fun beforeAll() {
        // Задаем путь к ChromeDriver
        //System.setProperty("webdriver.chrome.driver", "E:/my_autotests_kotlin/WebDriver/bin/chromedriver-win64/chromedriver.exe")

        Configuration.fastSetValue = true

        if (System.getenv("BASE_URL") == null) {
            Configuration.baseUrl = "https://www.google.com/"
            DriverManager.println("Using default baseUrl=${Configuration.baseUrl}")
        } else {
            Configuration.baseUrl = System.getenv("BASE_URL")
            DriverManager.println("Using environment baseUrl=${Configuration.baseUrl}")
        }
        Configuration.webdriverLogsEnabled = true
        Configuration.timeout = 20000

        Configuration.driverManagerEnabled = true

        // Настройка WebDriverManager для Chrome
        /*
        WebDriverManager.chromedriver().browserVersion("130.0.6723.70").setup()
        WebDriverManager.chromedriver().setup()
         */
        /*
        Configuration.remote = "https://www.google.com/"
        Configuration.browserCapabilities.setCapability("prefs", mapOf("intl.accept_languages" to "ru"))
        */

        // Настройка опций для Chrome
        val options = ChromeOptions()

        val prefs = HashMap<String, Any>()
        // Отключение cookies
        prefs["profile.default_content_setting_values.cookies"] = 2
        // Отключение изображений
        //prefs["profile.default_content_setting_values.images"] = 2
        options.setExperimentalOption("prefs", prefs)

        options.addArguments("--incognito")
        options.addArguments("--ignore-certificate-errors")

        // Установка опций для WebDriver
        WebDriverRunner.setWebDriver(ChromeDriver(options))

    }

    @BeforeEach
    open fun beforeEach() {
    }

    @AfterEach
    fun afterEach() {
        closeWebDriver()
    }

    }
package uiautotests.model

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.WebDriverRunner
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ScrollbarsPage {
    private val driver: WebDriver = WebDriverRunner.getWebDriver()

    private val hidingButton: WebElement
    private val scrollableArea: WebElement
    private var currentButtonCoordinates: Map<String, Double>? = null

    private val logger: Logger = LogManager.getLogger(ClickPage::class.java)

    init {
        // Инициализация WebDriver и поиск элемента
        hidingButton = Selenide.`$`("#hidingButton")
        scrollableArea = Selenide.`$x`("/html/body/section/div/div")
    }


    private fun getElementCoordinates(element: WebElement): Map<String, Double> {
        val jsExecutor = driver as JavascriptExecutor

        val script =
            """ 
                var rect = arguments[0].getBoundingClientRect();
                console.log('Bounding rect:', rect);
                return {x: rect.left + window.scrollX, y: rect.top + window.scrollY, right: rect.right + window.scrollX, bottom: rect.bottom + window.scrollY};
            """
        val result = jsExecutor.executeScript(script, element)

        if (result is Map<*, *>) {
            @Suppress("UNCHECKED_CAST")
            val coordinates = result as Map<String, Double>
            //logger.info("Полученные координаты для элемента: $coordinates")

            // Проверка координат на null
            if (coordinates["x"] == null || coordinates["y"] == null || coordinates["right"] == null || coordinates["bottom"] == null) {
                throw IllegalStateException("Одно из значений координат null: $coordinates")
            }
            return coordinates
        } else {
            throw IllegalStateException("Unexpected result type: ${result?.javaClass?.name}")
        }
    }

    private fun outputElementCoordinates() {
        val scrollableAreaCoordinates = getElementCoordinates(scrollableArea)
        val hidingButtonCoordinates = getElementCoordinates(hidingButton)
        logger.info("Координаты Scrollable Area: $scrollableAreaCoordinates\nКоординаты Hiding Button: $hidingButtonCoordinates")
    }

    private fun isElementWithinArea(
        elementCoordinates: Map<String, Double>?,
        areaCoordinates: Map<String, Double>?
    ): Boolean {
        // Проверка карт на null
        if (elementCoordinates == null || areaCoordinates == null) {
            logger.error("One of the coordinates maps is null. Element coordinates: $elementCoordinates, Area coordinates: $areaCoordinates")
            return false
        }

        // Проверка всех ключей на null
        if (elementCoordinates["x"] == null || elementCoordinates["y"] == null || elementCoordinates["right"] == null || elementCoordinates["bottom"] == null ||
            areaCoordinates["x"] == null || areaCoordinates["y"] == null || areaCoordinates["right"] == null || areaCoordinates["bottom"] == null
        ) {
            logger.error("One of the coordinate values is null. Element coordinates: $elementCoordinates, Area coordinates: $areaCoordinates")
            return false
        }

        return elementCoordinates["x"]!! >= areaCoordinates["x"]!! &&
                elementCoordinates["y"]!! >= areaCoordinates["y"]!! &&
                elementCoordinates["right"]!! <= areaCoordinates["right"]!! &&
                elementCoordinates["bottom"]!! <= areaCoordinates["bottom"]!!
    }

    fun checkButtonDisplayed(beforeScroll: Boolean) {
        logger.info("Проверка отображения кнопки HidingButton в области ScrollableArea")
        outputElementCoordinates()

        // Получение координат элементов
        currentButtonCoordinates = getElementCoordinates(hidingButton)
        val scrollableAreaCoordinates = getElementCoordinates(scrollableArea)

        val isInViewport = isElementWithinArea(currentButtonCoordinates, scrollableAreaCoordinates)
        if (beforeScroll) {
            assertFalse(isInViewport, "Кнопка отображается в области до скролла")
            logger.info("Кнопка не отображается в области до скролла")
        } else {
            assertTrue(isInViewport, "Кнопка не отображается в области после скролла")
            logger.info("Кнопка отображается в области после скролла")
        }
    }

    fun scrollToHidingButton() {
       element(hidingButton).apply {
            scrollIntoView(true)
            logger.info("Скролл к кнопке")
        }
    }
}
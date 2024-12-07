package uiautotests.model

import com.codeborne.selenide.Selenide.element
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By
import kotlin.test.assertEquals

class DynamicTablePage {
    private val chromeCpuCell = By.xpath("//div[@role='table']//div[@role='rowgroup']//div[@role='row'][span[text()='Chrome']]//span[@role='cell'][contains(text(), '%')]")
    private val chromeCpuLine = By.className("bg-warning")
    private val logger: Logger = LogManager.getLogger(DynamicTablePage::class.java)

    private fun getChromeCpuFromTable(): String {
        val chromeCpu = element(chromeCpuCell).text
        logger.info("Chrome CPU в таблице:\nChrome CPU: $chromeCpu")
        return "Chrome CPU: $chromeCpu"
    }

    private fun getChromeCpuFromLine(): String {
        val chromeCpu = element(chromeCpuLine).text
        logger.info("Chrome CPU в поле:\n$chromeCpu")
        return chromeCpu
    }

    fun checkChromeCpu() {
        val chromeCpuFromTable = getChromeCpuFromTable()
        val chromeCpuFromLine = getChromeCpuFromLine()

        logger.info("Проверка совпадения CPU Chrome в таблице и в поле")
        assertEquals(chromeCpuFromLine, chromeCpuFromTable, "CPU Chrome в таблице и поле не совпадают")
        logger.info("CPU Chrome в таблице и поле совпадают")
    }
}
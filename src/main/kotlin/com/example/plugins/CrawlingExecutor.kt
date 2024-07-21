package com.example.plugins

import com.example.plugins.Url.GOOGLE
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

class CrawlingExecutor {
    suspend fun execute(
        keyword: String,
    ) {
        val url = GOOGLE + keyword

        driver.get(url)
        withContext(IO) {
            for (i in 1 until 4) {
                val xpath = By.xpath("//*[@id=\"rso\"]/div[$i]")
                val doc = driver.findElement(xpath)
                println("${i}번째 게시물 : ${doc.text}")
            }
        }
    }

    suspend fun executeAndClose(
        keyword: String,
    ) {
        driver.quit()
        System.setProperty(WebDriver.ID, WebDriver.PATH)

        val newOptions = ChromeOptions().apply {
            setBinary(Options.BINARY)
            addArguments(Options.MAXIMIZE)
            addArguments(Options.DISABLE_POPUP)
            addArguments(Options.DISABLE_DEFAULT_APPS)
        }

        val newDriver = ChromeDriver(newOptions)

        val url = GOOGLE + keyword

        try {
            newDriver.get(url)
            for (i in 1 until 4) {
                val xpath = By.xpath("//*[@id=\"rso\"]/div[$i]")
                val doc = newDriver.findElement(xpath)
                println(doc.text)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            newDriver.close()
        }
    }
}
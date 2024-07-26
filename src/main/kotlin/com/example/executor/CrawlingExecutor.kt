package com.example.executor

import com.example.plugins.access
import com.example.plugins.newDriver
import com.example.util.Url.GOOGLE
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import org.openqa.selenium.By

class CrawlingExecutor {
    suspend fun execute(
        keyword: String,
    ) {
        val url = GOOGLE + keyword
        val driver = newDriver()
        driver.access(url)

        withContext(IO) {
            for (i in 1 until 4) {
                val xpath = By.xpath("//*[@id=\"rso\"]/div[$i]")
                val doc = driver.findElement(xpath)
                println("${i}번째 게시물 : ${doc.text}")
            }
        }
    }
}
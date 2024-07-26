package com.example.plugins

import com.example.util.Url.GOOGLE
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import org.openqa.selenium.By

class CrawlingExecutor {
    suspend fun execute(
        keyword: String,
    ) {
        val url = GOOGLE + keyword

        val driver = newChrome()
        driver.get(url)
        withContext(IO) {
            for (i in 1 until 4) {
                val xpath = By.xpath("//*[@id=\"rso\"]/div[$i]")
                val doc = newChrome().findElement(xpath)
                println("${i}번째 게시물 : ${doc.text}")
            }
        }
    }
}
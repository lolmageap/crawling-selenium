package com.example.plugins

import com.example.util.Options
import com.example.util.WebDriver
import io.ktor.server.application.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

fun Application.configureCrawling() {
    System.setProperty(WebDriver.ID, WebDriver.PATH)
}

val options = ChromeOptions().apply {
    setBinary(Options.BINARY)
    addArguments(Options.MAXIMIZE)
    addArguments(Options.DISABLE_POPUP)
    addArguments(Options.DISABLE_DEFAULT_APPS)
}

val drivers = mutableListOf<ChromeDriver>()
fun newChrome() =
    ChromeDriver(options).also {
        drivers.add(it)
    }
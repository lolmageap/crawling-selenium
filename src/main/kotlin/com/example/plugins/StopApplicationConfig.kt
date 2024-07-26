package com.example.plugins

import io.ktor.server.application.*

fun Application.configureStopApplication() {
    drivers.forEach { it.quit() }
}
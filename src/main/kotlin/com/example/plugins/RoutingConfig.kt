package com.example.plugins

import com.example.api.home
import com.example.api.test
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        home()
        test()
    }
}
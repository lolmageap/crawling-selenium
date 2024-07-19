package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

// TODO: dependency injection 설정 해야함.
fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        post("/google") {
            val request = call.receive<SearchRequest>()
            CrawlingExecutor().execute(request.keyword)
        }

        post("/google2") {
            val request = call.receive<SearchRequest>()
            CrawlingExecutor().executeAndClose(request.keyword)
        }
    }
}
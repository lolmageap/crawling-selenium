package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val crawlingExecutor: CrawlingExecutor by inject()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        post("/google") {
            val request = call.receive<SearchRequest>()
            crawlingExecutor.execute(request.keyword)
            call.response.status(HttpStatusCode.OK)
        }

        post("/google2") {
            val request = call.receive<SearchRequest>()
            crawlingExecutor.executeAndClose(request.keyword)
            call.response.status(HttpStatusCode.OK)
        }
    }
}
package com.example.api

import com.example.model.SearchRequest
import com.example.executor.CrawlingExecutor
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.test() {
    val crawlingExecutor by inject<CrawlingExecutor>()

    post("/google") {
        val request = call.receive<SearchRequest>()
        crawlingExecutor.execute(request.keyword)
        call.response.status(HttpStatusCode.OK)
    }
}
package com.example.plugins

import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

fun Application.configureDependencyInjection() {
    install(Koin) {
        modules(dependencyInjectionModule)
    }
}

val dependencyInjectionModule = module {
    single<CrawlingExecutor> { CrawlingExecutor() }
}
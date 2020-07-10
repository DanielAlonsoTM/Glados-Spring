package com.samuraitech.spring_glados

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SpringGladosApplication

fun main(args: Array<String>) {
    runApplication<SpringGladosApplication>(*args)
}

@RestController
class MainController{
    @GetMapping
    fun index()="Glados Spring\n"
}

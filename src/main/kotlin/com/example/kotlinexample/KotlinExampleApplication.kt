package com.example.kotlinexample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinExampleApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinExampleApplication::class.java, *args)
}

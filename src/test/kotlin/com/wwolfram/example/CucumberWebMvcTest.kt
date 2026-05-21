package com.wwolfram.example

import org.junit.jupiter.api.extension.*
import org.springframework.boot.test.autoconfigure.web.servlet.*
import org.springframework.core.annotation.*
import org.springframework.test.context.junit.jupiter.*
import kotlin.reflect.*

@DefaultCucumberTest
@WebMvcTest
@ExtendWith(SpringExtension::class)
annotation class CucumberWebMvcTest(
    @get:AliasFor(annotation = WebMvcTest::class, attribute = "controllers")
    val classes: Array<KClass<*>> = [],
)

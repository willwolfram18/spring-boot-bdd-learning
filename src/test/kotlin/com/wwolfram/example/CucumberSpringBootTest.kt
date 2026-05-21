package com.wwolfram.example

import io.cucumber.junit.platform.engine.Constants
import io.cucumber.spring.CucumberContextConfiguration
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.IncludeEngines
import org.junit.platform.suite.api.Suite
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.annotation.AliasFor
import org.springframework.test.context.junit.jupiter.SpringExtension
import kotlin.reflect.KClass

@DefaultCucumberTest
@SpringBootTest
@ExtendWith(SpringExtension::class)
annotation class CucumberSpringBootTest(
    @get:AliasFor(annotation = SpringBootTest::class, attribute = "classes")
    val classes: Array<KClass<*>> = []
)

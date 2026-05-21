package com.wwolfram.example.bdd_learning

import com.ninjasquad.springmockk.MockkBean
import com.wwolfram.example.*
import com.wwolfram.example.bdd_learning.controllers.*
import com.wwolfram.example.bdd_learning.services.ProductService
import io.cucumber.junit.platform.engine.*
import org.junit.platform.suite.api.*

@SuiteDisplayName("Initial Cucumber Tests")
@SelectPackages("com.wwolfram.example.bdd_learning")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.wwolfram.example.bdd_learning")
@CucumberWebMvcTest([ProductController::class])
class RunCucumberTest {
    @MockkBean
    lateinit var productService: ProductService
}
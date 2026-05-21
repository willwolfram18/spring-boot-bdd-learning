package com.wwolfram.example.bdd_learning

import com.wwolfram.example.CucumberWebMvcTest
import com.wwolfram.example.bdd_learning.controllers.ProductController
import io.cucumber.junit.platform.engine.*
import io.cucumber.spring.CucumberContextConfiguration
import org.junit.platform.suite.api.*
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest

@SuiteDisplayName("Initial Cucumber Tests")
@SelectPackages("com.wwolfram.example.bdd_learning")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.wwolfram.example.bdd_learning")
@CucumberWebMvcTest([ProductController::class])
//@WebMvcTest(ProductController::class)
class RunCucumberTest
package com.wwolfram.example.bdd_learning

import com.wwolfram.example.bdd_learning.controllers.ProductController
import io.cucumber.junit.platform.engine.*
import io.cucumber.spring.CucumberContextConfiguration
import org.junit.platform.suite.api.*
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest

@Suite
@SuiteDisplayName("Initial Cucumber Tests")
@SelectPackages("com.wwolfram.example.bdd_learning")
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty")
@CucumberContextConfiguration
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.wwolfram.example.bdd_learning")
@WebMvcTest(ProductController::class)
class RunCucumberTest
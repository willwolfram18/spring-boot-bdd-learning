package com.wwolfram.example.bdd_again

import com.ninjasquad.springmockk.isMockOrSpy
import com.wwolfram.example.CucumberSpringBootTest
import com.wwolfram.example.bdd_learning.BddLearningApplication
import com.wwolfram.example.bdd_learning.services.ProductService
import io.cucumber.java.en.Then
import io.cucumber.junit.platform.engine.Constants
import io.cucumber.spring.CucumberContextConfiguration
import io.kotest.matchers.booleans.shouldBeFalse
import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.IncludeEngines
import org.junit.platform.suite.api.SelectClasspathResource
import org.junit.platform.suite.api.SelectPackages
import org.junit.platform.suite.api.Suite
import org.junit.platform.suite.api.SuiteDisplayName
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.shaded.org.yaml.snakeyaml.scanner.Constant

@SuiteDisplayName("Second Cucumber Tests")
@SelectPackages("com.wwolfram.example.bdd_again")
@SelectClasspathResource("new-features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.wwolfram.example.bdd_again")
@CucumberSpringBootTest(classes = [BddLearningApplication::class])
class CucumberRunner

class Steps(
    private val productService: ProductService,
) {
    @Then("the test runs")
    fun testRuns() {
        productService.isMockOrSpy.shouldBeFalse()
        println("Test is here")
    }
}
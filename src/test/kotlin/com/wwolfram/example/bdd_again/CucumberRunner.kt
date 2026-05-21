package com.wwolfram.example.bdd_again

import com.wwolfram.example.bdd_learning.BddLearningApplication
import io.cucumber.java.en.Then
import io.cucumber.junit.platform.engine.Constants
import io.cucumber.spring.CucumberContextConfiguration
import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.IncludeEngines
import org.junit.platform.suite.api.SelectClasspathResource
import org.junit.platform.suite.api.SelectPackages
import org.junit.platform.suite.api.Suite
import org.junit.platform.suite.api.SuiteDisplayName
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.shaded.org.yaml.snakeyaml.scanner.Constant

@Suite
@SuiteDisplayName("Second Cucumber Tests")
@SelectPackages("com.wwolfram.example.bdd_again")
@IncludeEngines("cucumber")
@SelectClasspathResource("new-features")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty")
@CucumberContextConfiguration
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.wwolfram.example.bdd_again")
@SpringBootTest(classes = [BddLearningApplication::class])
class CucumberRunner {
    @Then("the test runs")
    fun testRuns() {
        println("Test is here")
    }
}
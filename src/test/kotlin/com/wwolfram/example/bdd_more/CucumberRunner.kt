package com.wwolfram.example.bdd_more

import com.wwolfram.example.*
import com.wwolfram.example.bdd_learning.services.*
import io.cucumber.java.en.*
import io.cucumber.junit.platform.engine.*
import io.kotest.matchers.*
import kotlinx.coroutines.*
import org.junit.platform.suite.api.*

@SuiteDisplayName("Tertiary suite")
@SelectPackages("com.wwolfram.example.bdd_more")
@SelectClasspathResource("more-features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.wwolfram.example.bdd_more")
@CucumberSpringBootTest(
    classes = [
        ProductService::class,
    ]
)
class CucumberRunner

class Steps(
    private val productService: ProductService,
) {
    @Then("test runs again")
    fun test() {
        val result = runBlocking {
            productService.getProduct("1")
        }

        result.name shouldNotBe "UNKNOWN"
    }
}
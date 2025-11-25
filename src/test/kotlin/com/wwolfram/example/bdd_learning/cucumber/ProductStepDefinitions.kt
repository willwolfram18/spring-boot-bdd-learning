package com.wwolfram.example.bdd_learning.cucumber

import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.module.kotlin.*
import com.wwolfram.example.bdd_learning.controllers.*
import com.wwolfram.example.bdd_learning.models.*
import io.cucumber.java.*
import io.cucumber.java.en.*
import io.cucumber.spring.*
import io.kotest.matchers.*
import io.kotest.matchers.nulls.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.autoconfigure.web.servlet.*
import org.springframework.http.*
import org.springframework.test.web.servlet.*
import java.net.*

@CucumberContextConfiguration
@WebMvcTest(ProductController::class)
class ProductStepDefinitions @Autowired constructor(
    private val mvc: MockMvc,
    private val objectMapper: ObjectMapper
) {
    private var action: ResultActionsDsl? = null

    @ParameterType(".*")
    fun uri(uri: String) = URI(uri)

    @When("the client calls {uri}")
    fun `WHEN the client calls GET products`(uri: URI) {
        action = mvc.get(uri) {
            contentType = MediaType.APPLICATION_JSON
        }
    }

    @And("the client receives status code of {int}")
    fun `THEN the client receives status`(expectedStatus: Int) {
        action.shouldNotBeNull().andExpect {
            status { isEqualTo(expectedStatus) }
        }
    }

    @Then("the client receives product with name")
    fun `THEN the client receives product with the name`() {
        val responseContent = action.shouldNotBeNull().andReturn().response.contentAsString
        val responseEntity = objectMapper.readValue<Product>(responseContent)

        responseEntity.name shouldBe "Test product"
    }
}
package com.wwolfram.example.bdd_learning.cucumber

import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.module.kotlin.*
import com.wwolfram.example.bdd_learning.controllers.*
import com.wwolfram.example.bdd_learning.models.*
import com.wwolfram.example.bdd_learning.services.ProductService
import io.cucumber.java.*
import io.cucumber.java.en.*
import io.cucumber.spring.*
import io.kotest.matchers.*
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.nulls.*
import io.mockk.coEvery
import io.mockk.every
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.autoconfigure.web.servlet.*
import org.springframework.http.*
import org.springframework.test.web.servlet.*
import java.net.*

class ProductStepDefinitions @Autowired constructor(
    private val mvc: MockMvc,
    private val objectMapper: ObjectMapper,
    private val productService: ProductService,
) {
    private var action: ResultActionsDsl? = null

    @ParameterType(".*")
    fun uri(uri: String): URI = URI(uri)

    @When("the client calls {uri}")
    fun `WHEN the client calls GET products`(uri: URI) {
        coEvery { productService.getAllProducts() } returns listOf(
            Product(name = "100")
        )
        coEvery { productService.getProduct(any()) } returns Product(name = "Single product")
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

        responseEntity.name.isBlank().shouldBeFalse()
    }

    @Then("the client receives product named {string}")
    fun `THEN the client receives product with name`(name: String) {
        val responseContent = action.shouldNotBeNull().andReturn().response.contentAsString
        val responseEntity = objectMapper.readValue<Product>(responseContent)

        responseEntity.name shouldBe name
    }
}
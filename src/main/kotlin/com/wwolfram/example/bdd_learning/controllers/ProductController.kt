package com.wwolfram.example.bdd_learning.controllers

import com.wwolfram.example.bdd_learning.models.*
import org.springframework.web.bind.annotation.*

@RestController
class ProductController {
    companion object {
        val products = mapOf(
            "1" to Product("First product"),
            "2" to Product("Second product")
        )
    }

    @GetMapping("/products")
    fun getProduct(): Product {
        return Product("Test product")
    }

    @GetMapping("/products/{id}")
    fun getProductById(@PathVariable id: String): Product {
        return products.getOrDefault(id, Product("UNKNOWN"))
    }
}
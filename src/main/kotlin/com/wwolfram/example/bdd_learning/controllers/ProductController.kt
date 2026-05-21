package com.wwolfram.example.bdd_learning.controllers

import com.wwolfram.example.bdd_learning.models.*
import com.wwolfram.example.bdd_learning.services.*
import kotlinx.coroutines.*
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(
    private val productService: ProductService
) {
    @GetMapping("/products")
    fun getProduct(): Product {
        return runBlocking {
            productService.getAllProducts().first()
        }
    }

    @GetMapping("/products/{id}")
    fun getProductById(@PathVariable id: String): Product {
        return runBlocking {
            productService.getProduct(id)
        }
    }
}
package com.wwolfram.example.bdd_learning.controllers

import com.wwolfram.example.bdd_learning.models.*
import org.springframework.web.bind.annotation.*

@RestController
class ProductController {
    @GetMapping("/products")
    fun getProduct(): Product {
        return Product("Test product")
    }
}
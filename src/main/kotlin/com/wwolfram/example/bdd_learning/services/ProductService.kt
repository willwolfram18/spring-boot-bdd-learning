package com.wwolfram.example.bdd_learning.services

import com.wwolfram.example.bdd_learning.models.*
import kotlinx.coroutines.*
import org.springframework.stereotype.*
import kotlin.time.Duration.Companion.milliseconds

@Service
class ProductService {
    companion object {
        val products = mapOf(
            "1" to Product("First product"),
            "2" to Product("Second product")
        )
    }

    suspend fun getAllProducts(): List<Product> {
        delay(100.milliseconds)

        return products.values.toList()
    }

    suspend fun getProduct(id: String): Product {
        delay(100.milliseconds)

        return products.getOrDefault(id, Product("UNKNOWN"))
    }
}
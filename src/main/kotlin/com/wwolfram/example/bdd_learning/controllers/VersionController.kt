package com.wwolfram.example.bdd_learning.controllers

import org.springframework.web.bind.annotation.*

@RestController
class VersionController {
    @GetMapping("/versions")
    fun getVersion(): String = "1.0.0"
}
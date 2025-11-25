package com.wwolfram.example.bdd_learning

import org.springframework.boot.*


fun main(args: Array<String>) {
	fromApplication<BddLearningApplication>().with(TestcontainersConfiguration::class).run(*args)
}

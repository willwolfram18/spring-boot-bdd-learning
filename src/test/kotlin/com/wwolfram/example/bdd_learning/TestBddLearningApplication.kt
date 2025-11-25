package com.wwolfram.example.bdd_learning

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<BddLearningApplication>().with(TestcontainersConfiguration::class).run(*args)
}

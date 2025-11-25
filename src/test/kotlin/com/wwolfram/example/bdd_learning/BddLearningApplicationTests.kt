package com.wwolfram.example.bdd_learning

import org.junit.jupiter.api.*
import org.springframework.boot.test.context.*
import org.springframework.context.annotation.*

@Import(TestcontainersConfiguration::class)
@SpringBootTest
class BddLearningApplicationTests {

	@Test
	fun contextLoads() {
	}

}

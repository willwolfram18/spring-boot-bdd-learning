package com.wwolfram.example.bdd_learning

import org.springframework.boot.test.context.*
import org.springframework.boot.testcontainers.service.connection.*
import org.springframework.context.annotation.*
import org.testcontainers.kafka.*
import org.testcontainers.utility.*

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

	@Bean
	@ServiceConnection
	fun kafkaContainer(): KafkaContainer {
		return KafkaContainer(DockerImageName.parse("apache/kafka-native:latest"))
	}

}

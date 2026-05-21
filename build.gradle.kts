
plugins {
	kotlin("jvm") version "2.2.20"
	kotlin("plugin.spring") version "2.2.20"
	id("org.springframework.boot") version "3.5.8"
	id("io.spring.dependency-management") version "1.1.7"
//	id("io.kotest") version ""
}

group = "com.wwolfram.example"
version = "0.0.1-SNAPSHOT"
description = "Demo project to learn about BDD in Spring"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.kafka:spring-kafka")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.springframework.kafka:spring-kafka-test")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:kafka")
	testImplementation(platform("io.cucumber:cucumber-bom:7.14.1"))
	testImplementation(platform("org.junit:junit-bom:5.12.2"))
	testImplementation("io.cucumber:cucumber-java")
	testImplementation("io.cucumber:cucumber-junit-platform-engine")
	testImplementation("org.junit.platform:junit-platform-suite")
	testImplementation("org.junit.jupiter:junit-jupiter")
	testImplementation("io.cucumber:cucumber-spring")
//	testImplementation("org.junit.platform:junit-platform-engine:1.12.2")
//	testImplementation("org.junit.platform:junit-platform-suite:1.12.1")
//	testImplementation("org.junit.platform:junit-platform-suite-api:1.12.2")
//	testImplementation("io.cucumber:cucumber-junit:7.31.0")
//	testImplementation("io.cucumber:cucumber-junit-platform-engine:7.31.0")
//	testImplementation("io.cucumber:cucumber-spring:7.31.0")
//	testImplementation("io.cucumber:cucumber-java:7.31.0")
	testImplementation("io.kotest:kotest-assertions-core:6.0.5")
	testImplementation("com.ninja-squad:springmockk:5.0.1")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

//tasks.getByName("check").dependsOn("test", "")
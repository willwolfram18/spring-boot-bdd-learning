package com.wwolfram.example.bdd_learning

import io.cucumber.junit.*
import org.junit.runner.*

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/resources/features"],
)
open class CucumberTest
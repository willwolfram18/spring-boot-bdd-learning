package com.wwolfram.example.bdd_learning

import io.cucumber.junit.platform.engine.*
import org.junit.platform.suite.api.*

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty")
class RunCucumberTest
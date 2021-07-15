package com.domenico.aumenta.multimodulemvvm.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin : Plugin<Project> {
    override fun apply(target: Project) {
    }

    companion object {
        val koinVersion = "3.0.2"
        val kotlinVersion = "1.5.21"
        val coreKtlVersion = "1.6.0"
        val appCompactVersion = "1.3.0"
        val materialVersion = "1.4.0"
        val constraintLayoutVersion = "2.0.4"
        val navigationKtlVersion = "2.3.5"
        val testExtJunitVersion = "1.1.3"
        val espressoCoreVersion = "3.4.0"
        val JUnitVersion = "4.13.2"
        val retrofitVersion = "2.4.0"
        val okHttpCLientInterceptor = "4.2.1"
        val picassoVersion = "2.71828"
    }
}
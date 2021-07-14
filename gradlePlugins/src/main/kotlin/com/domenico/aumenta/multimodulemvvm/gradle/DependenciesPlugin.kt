package com.domenico.aumenta.multimodulemvvm.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin : Plugin<Project> {
    override fun apply(target: Project) {
    }

    companion object {
        val koinVersion = "3.0.2"
        val kotlin_version = "1.5.21"
    }
}
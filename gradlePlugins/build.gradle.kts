plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("dependencies") {
            id = "com.domenico.aumenta.multimodulemvvm.dependencies"
            implementationClass = "com.domenico.aumenta.multimodulemvvm.gradle.DependenciesPlugin"
        }
    }
}
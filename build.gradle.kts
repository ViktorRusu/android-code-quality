// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.gitHooks)
    id(Plugins.detekt) version PluginsVersions.detekt
    id(Plugins.ktlint) version PluginsVersions.ktlint
}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("com.android.tools.build:gradle:7.1.3")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }

    apply {
        plugin(Plugins.detekt)
        plugin(Plugins.ktlint)
    }

    detekt {
        toolVersion = PluginsVersions.detekt

        config = rootProject.files("$rootDir/config/detekt/config.yml")
    }

    tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
        jvmTarget = "1.8"
        reports.html.required.set(true)
        reports.txt.required.set(false)
        reports.sarif.required.set(false)
    }

    tasks.withType<io.gitlab.arturbosch.detekt.DetektCreateBaselineTask>().configureEach {
        jvmTarget = "1.8"
    }

    ktlint {
        debug.set(false)
        version.set("0.43.2")
        verbose.set(true)
        android.set(false)
        outputToConsole.set(true)
        ignoreFailures.set(false)
        enableExperimentalRules.set(true)
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

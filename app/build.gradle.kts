buildscript {
    repositories {
        mavenCentral()
        google()
    }
}

plugins {
    id("com.android.application")
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    testImplementation("junit:junit:4.13")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")

    // litho
    implementation("com.facebook.litho:litho-core:0.37.0")
    implementation("com.facebook.litho:litho-widget:0.37.0")

    annotationProcessor("com.facebook.litho:litho-processor:0.37.0'")

    // SoLoader
    implementation("com.facebook.soloader:soloader:0.9.0")

    // For integration with Fresco
    implementation("com.facebook.litho:litho-fresco:0.37.0")

    // For testing
    testImplementation("com.facebook.litho:litho-testing:0.37.0")

}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.3")
    defaultConfig {
        applicationId = "com.amirthasureshbabu.litho_poc"
        minSdkVersion(29)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}


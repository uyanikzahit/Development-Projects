plugins {
//    alias(libs.plugins.android.application)
    id("com.android.application")
    id("androidx.navigation.safeargs")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.rehberuygulamasi"
    compileSdk = 35

    buildFeatures{
        viewBinding = true
        dataBinding = true

    }

    defaultConfig {
        applicationId = "com.example.rehberuygulamasi"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)


    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(libs.lifecycle.viewmodel)
    implementation("com.google.dagger:hilt-android:2.42")
    annotationProcessor("com.google.dagger:hilt-android-compiler:2.42")

    //Room
    implementation("androidx.room:room-rxjava2:2.7.1")
    annotationProcessor("androidx.room:room-compiler:2.7.1")
    //RxJava
    implementation("androidx.room:room-rxjava2:2.7.1")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")

    implementation(platform("com.google.firebase:firebase-bom:33.13.0"))
    implementation("com.google.firebase:firebase-database:21.0.0")



}
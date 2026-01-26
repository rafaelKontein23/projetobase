plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // configuração do hilt
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.example.docdefaut"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.docdefaut"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    // Para configurar o viewBinding
    buildFeatures {
        viewBinding = true
        buildConfig = true // Para gerar arquivos de BuildConfig
    }


    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    // Aqui estamos configurando as dimensões de flavors
    flavorDimensions += "version"
    productFlavors {
        // São essas propriedade que configuram a versão que vai ser geradas
        create("versionTestOne") {
            dimension = "version"
            applicationIdSuffix = ".versionTestOne"
            versionNameSuffix = "-versionTestOne"
        }
        create("versionTestTwo") {
            dimension = "version"
            applicationIdSuffix = ".versionTestTwo"
            versionNameSuffix = "-versionTestTwo"
        }
        // Após terminar de fazar essas configs, clique em "Sync Now" , após isso isso em "buid variante" verifique se realmente tem novas versões
        // Para criar aquivos especificos para aquele modo, você troca o build variante para qual vc quer criar o arquivc
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    // Dagger hilt
    implementation(libs.dagger.hilt)
    ksp(libs.hilt.compiler)

    // retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    //okhttp
    implementation(libs.okhttp)
    // lifecicle
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
    implementation(libs.gson)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
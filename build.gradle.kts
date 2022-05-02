import com.caldremch.android.version.Deps
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.caldremch.android.version")
}

ext{
    set("myGitUrl", "https://github.com/android-module/widget.git")
    set("myLibraryVersion", "1.0.0")
    set("myArtifactId", "widget")
    set("myLibraryName", "widget")
    set("myLibraryDescription", "widget for android base develop")
    set("mySiteUrl", "https://github.com/android-module/widget")
}


android {
    compileSdk = Deps.compileSdk
    defaultConfig {
        minSdk = Deps.minSdk
        targetSdk = Deps.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles.add(File("consumer-rules.pro"))
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile ("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions{
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
     implementation(libs.kotlin.stdlib.jdk8)
    implementation(libs.androidx.appcompat)
    implementation(libs.kotlin.ktx)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
    api(libs.banner)
    implementation(libs.baseRecyclerViewAdapterHelper)
    api(libs.refresh)
    api(libs.refresh.headerClassics)
    api(libs.refresh.headerFalsify)
    api(libs.refresh.footerClassics)
    implementation(libs.magicIndicator)
    implementation(libs.viewbinding)
}

apply(from="../gradle-maven-kotlin-dsl/mavencentral-with-maven-publish.gradle")

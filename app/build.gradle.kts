plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.meowproj"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.meowproj"
        minSdk = 26
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
    sourceSets {
        getByName("main") {
            res {
                srcDirs(
                    "src\\main\\res",
                    "src\\main\\res\\layouts\\home",
                    "src\\main\\res\\layouts\\category",
                    "src\\main\\res\\layouts\\profile",
                    "src\\main\\res\\layouts\\cart",
                    "src\\main\\res\\layouts\\home\\layouts",
                    "src\\main\\res\\layouts\\home\\layouts\\vendor",
                    "src\\main\\res\\layouts\\home\\layouts\\author",
                    "src\\main\\res\\layouts\\home\\layouts\\topweek", "src\\main\\res", "src\\main\\res\\layouts\\common"
                )
            }
        }
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.gms:play-services-base:18.2.0")
    implementation("androidx.navigation:navigation-fragment:2.7.6")
    implementation("androidx.navigation:navigation-ui:2.7.6")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    implementation("com.android.databinding:viewbinding:4.0.1")

    //circle dots
    implementation("me.relex:circleindicator:2.1.6")
}

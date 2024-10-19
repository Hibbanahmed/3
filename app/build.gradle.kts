// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:4.2.2'
        classpath 'com.google.gms:google-services:4.3.10'
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

apply plugin: 'com.android.application'
apply plugin: 'com.google.gms.google-services'

android {
    compileSdkVersion 31
    defaultConfig {
        applicationId "com.example.trustpassplus"
        minSdkVersion 21
        targetSdkVersion 31
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation 'androidx.appcompat:appcompat:1.4.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.3'
    implementation 'androidx.recyclerview:recyclerview:1.2.1'
    implementation 'com.google.android.material:material:1.5.0'
    implementation 'com.google.firebase:firebase-auth:21.0.1'
    implementation 'com.google.firebase:firebase-core:19.0.2'
    implementation 'com.google.firebase:firebase-messaging:22.0.1'
    implementation 'com.google.android.gms:play-services-location:19.0.1'
    implementation 'com.google.android.gms:play-services-places:17.0.0'
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
    implementation 'de.hdodenhof:circleimageview:3.1.0'
    implementation 'com.scaledrone:scaledrone-java:0.6.0'
    implementation 'com.android.support:appcompat-v7:28.0.0' // For AppCompatActivity
    implementation 'com.android.volley:volley:1.2.1' // For Volley
    implementation 'com.google.android.gms:play-services-location:18.0.0' // For FusedLocationProviderClient
    implementation 'com.google.firebase:firebase-auth:21.0.1' // For Firebase Authentication
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
}
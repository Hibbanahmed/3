// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    // Apply the Android application plugin
    id("com.android.application") version "7.0.2" apply false
    id("com.google.gms.google-services") version "4.3.10" apply false
}
dependencies {
    implementation(libs.play.services.location)
    implementation(libs.appcompat)
}



tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

fun implementation(appcompat: Provider<MinimalExternalModuleDependency>) {

}

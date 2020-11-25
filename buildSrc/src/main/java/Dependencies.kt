
val kotlin_version = "1.3.72"
val kotlin_core = "1.3.2"

// Kotlin Lib dependencies
object KotlinLibs{

    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    val kotlinCore = "androidx.core:core-ktx:$kotlin_core"
}

val appCompat_version = "1.2.0"
val materialDesign_version = "1.2.1"
val constraintLayout_version = "2.0.4"

object UILibs{

    val appCompat =  "androidx.appcompat:appcompat:$appCompat_version"
    val materialCompat = "com.google.android.material:material:${materialDesign_version}"
    val constraintLayout =  "androidx.constraintlayout:constraintlayout:$constraintLayout_version"

}

// Test frameworks
val junit_version = "4.12"
val androidx_test_version = "1.1.2"
val androidx_espresso_vesion = "3.3.0"

object TestLibs{

    val junit = "junit:junit:${junit_version}"
    val androidxTest = "androidx.test.ext:junit:$androidx_test_version"
    val espresso = "androidx.test.espresso:espresso-core:$androidx_espresso_vesion"
}

// Network libs
private const val retrofitAdapterVersion = "2.4.0"
private const val retrofitVersion = "2.7.1"

object Network{

    val converterGson = "com.squareup.retrofit2:converter-gson:"+retrofitAdapterVersion
    val retrofit = "com.squareup.retrofit2:retrofit:"+retrofitVersion
}

// Dagger Injection
val dagger_version = "2.25.4"
val dagger_compiler = "2.25.4"
val dagger_android_support = "2.25.4"
val dagger_android_processor = "2.25.4"

object DI{

    val dagger = "com.google.dagger:dagger:${dagger_version}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${dagger_compiler}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${dagger_android_support}"
    val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${dagger_android_processor}"
}


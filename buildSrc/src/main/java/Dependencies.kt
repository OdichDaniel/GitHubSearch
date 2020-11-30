
val kotlin_version = "1.3.72"
val kotlin_core = "1.3.2"
val kotlin_coroutine = "1.4.1"

// Kotlin Lib dependencies
object KotlinLibs{

    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    val kotlinCore = "androidx.core:core-ktx:$kotlin_core"
    val kotlinCoroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${kotlin_coroutine}"
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
private val junit_version = "4.12"
private val androidx_test_core = "1.1.2"
private val androidx_test_version = "1.1.2"
private val androidx_espresso_vesion = "3.3.0"
private val espresso_intent = "3.1.0"
private const val mockWebServerVersion = "4.0.1"
private const val robolectricVersion = "4.3"

// AndroidJnit Runner
private val androidx_test_runner = "1.1.0"
private val androidx_test_rules = "1.1.0"



object TestLibs{

    val junit = "junit:junit:${junit_version}"
    val androidxTestCore = "androidx.test:core:${androidx_test_core}"
    val androidxTest = "androidx.test.ext:junit:$androidx_test_version"
    val espresso = "androidx.test.espresso:espresso-core:$androidx_espresso_vesion"
    val espressoIntent = "androidx.test.espresso:espresso-intents:${espresso_intent}"
    val testRunner = "androidx.test:runner:${androidx_test_runner}"
    val testRules = "androidx.test:rules:${androidx_test_rules}"
    val robolectric = "org.robolectric:robolectric:$robolectricVersion"
    val mockWebServer = "com.squareup.okhttp3:mockwebserver:$mockWebServerVersion"

}

// Network libs
private val retrofitAdapterVersion = "2.4.0"
private val retrofitVersion = "2.7.1"
private val logging_interceptor = "4.0.1"

object Network{

    val converterGson = "com.squareup.retrofit2:converter-gson:"+retrofitAdapterVersion
    val retrofit = "com.squareup.retrofit2:retrofit:"+retrofitVersion
    val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${logging_interceptor}"
}

// Dagger Injection
val dagger_version = "2.25.4"

object DI{

    val dagger = "com.google.dagger:dagger:${dagger_version}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${dagger_version}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${dagger_version}"
    val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${dagger_version}"
    val daggerAndroid = "com.google.dagger:dagger-android:${dagger_version}"
}

// Kotlin extensions for the architecture components
val life_cycle_view_model = "2.2.0"
val life_cycle_scope = "2.2.0"
val live_data = "2.2.0"

object LifeCycleKtxExtensions{

    val viewModelScope = "androidx.lifecycle:lifecycle-viewmodel-ktx:${life_cycle_view_model}"
    val lifeCycleScope = "androidx.lifecycle:lifecycle-runtime-ktx:${life_cycle_scope}"
    val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${live_data}"

}

private val paging3_version= "3.0.0-alpha07"

object ArchitectureComponent{

    val paging3 = "androidx.paging:paging-runtime:${paging3_version}"
}

// Glide for image loading
private val glide_version = "4.11.0"

object Glide{

    val glide = "com.github.bumptech.glide:glide:${glide_version}"
    val annotationProcessor = "com.github.bumptech.glide:compiler:${glide_version}"
}

// Parceler
private val parceler_version = "1.1.12"
object Parceler{

    val parceler = "org.parceler:parceler-api:${parceler_version}"
    val parcelerAnnotationProcessor = "org.parceler:parceler:${parceler_version}"
}




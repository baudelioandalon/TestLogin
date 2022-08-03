object Dependency {

    const val pluginKotlinApp = "kotlin-android"
    const val pluginKotlinKapt = "kotlin-kapt"
    const val pluginKotlinParcelize = "kotlin-parcelize"
    const val pluginSafeArgs = "androidx.navigation.safeargs.kotlin"

    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompatVersion}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintlayoutVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtxVersion}"
    const val fragment = "androidx.fragment:fragment-ktx:${Version.fragmentVersion}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Version.navigationFragmentVersion}"
    const val navigationUiKtx =
        "androidx.navigation:navigation-ui-ktx:${Version.navigationUiVersion}"
    const val navigationRuntimeKtx =
        "androidx.navigation:navigation-runtime-ktx:${Version.navigationRuntime}"
    const val kotlinxCoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutineCoreVersion}"
    const val material = "com.google.android.material:material:${Version.materialVersion}"
    const val materialAlpha = "com.google.android.material:material:${Version.materialAlphaVersion}"
    const val playServicesAuth =
        "com.google.android.gms:play-services-auth:${Version.googleServicesVersion}"
    const val pluginBuildTools = "com.android.tools.build:gradle:${Version.buildToolsVersion}"
    const val pluginKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinVersion}"
    const val pluginSageArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.safeArgsVersion}"

    const val testAndroidJEspressoCore =
        "androidx.test.espresso:espresso-core:${Version.espressoCoreVersion}"
    const val testAndroidJunit = "androidx.test.ext:junit:${Version.androidJunitVersion}"
    const val testAndroidRunner = "androidx.test:runner:${Version.testAndroidRunnerVersion}"
    const val testAndroidRules = "androidx.test:rules:${Version.testAndroidRulesVersion}"
    const val testJunit = "junit:junit:${Version.jUnitVersion}"
    const val testTruth = "com.google.truth:truth:${Version.testTruthVersion}"
    const val viewmodelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.viewmodelVersion}"

    const val pluginGmsGoogleServices =
        "com.google.gms:google-services:${Version.gmsGoogleServicesVersion}"

    const val lottie = "com.airbnb.android:lottie:${Version.lottieVersion}"
    const val roundableImageView =
        "com.makeramen:roundedimageview:${Version.roundableImageViewVersion}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Version.recyclerViewVersion}"
    const val securityCrypto = "androidx.security:security-crypto:${Version.securityCryptoVersion}"

    //KOTLIN & COROUTINES
    const val workRuntime = "androidx.work:work-runtime-ktx:${Version.workRuntimeVersion}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycleRuntimeVersion}"
    const val lifecycleExtensions =
        "android.arch.lifecycle:extensions:${Version.lifecycleExtensionsVersion}"
    const val activityKtx = "androidx.activity:activity-ktx:${Version.activityKtxVersion}"
    const val lifecycleKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycleKtxVersion}"

    //DESIGN
    const val circularProgress =
        "com.jackandphantom.android:circularprogressbar:${Version.circularProgressVersion}"
    const val kProgressHud = "com.kaopiz:kprogresshud:${Version.kProgressHudVersion}"
    const val picassoLibrary = "com.squareup.picasso:picasso:${Version.picassoLibraryVersion}"
    const val glideLibrary = "com.github.bumptech.glide:glide:${Version.glideLibraryVersion}"
    const val glideCompilerLibrary =
        "com.github.bumptech.glide:compiler:${Version.glideLibraryVersion}"
    const val circleImage = "de.hdodenhof:circleimageview:${Version.circleImageVersion}"
    const val stfalconImageViewer =
        "com.github.stfalcon-studio:StfalconImageViewer:${Version.stfalconImageViewerVersion}"

    //UTILS
    const val imageConverterLibrary = "com.blankj:utilcodex:${Version.imageConverterLibraryVersion}"

    //Retrofit
    const val gson = "com.google.code.gson:gson:${Version.gsonVersion}"
    const val squareupRetrofit =
        "com.squareup.retrofit2:retrofit:${Version.squareupRetrofitVersion}"
    const val squareupGson =
        "com.squareup.retrofit2:converter-gson:${Version.squareupGsonConverterVersion}"
    const val squareupLogging =
        "com.squareup.okhttp3:logging-interceptor:${Version.squareupLoggingVersion}"
    const val realtimeBlurView =
        "com.github.mmin18:realtimeblurview:${Version.realtimeBlurViewVersion}"

    //Injection Dependencies
    const val koinAndroid = "io.insert-koin:koin-android:${Version.koinVersion}"
    const val koinCore = "io.insert-koin:koin-core:${Version.koinVersion}"

    //QR
    const val saveQrUtils = "com.journeyapps:zxing-android-embedded:${Version.saveUtilsVersion}"
    const val zxingCore = "com.google.zxing:core:${Version.zxingCoreVersion}"
    const val jwtEncode ="com.auth0.android:jwtdecode:${Version.jwtVersion}"
}
buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven (url ="https://www.jitpack.io")
    }
    dependencies {
        classpath(Dependency.pluginKotlin)
        classpath(Dependency.pluginBuildTools)
        classpath(Dependency.pluginSageArgs)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
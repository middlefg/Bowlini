object Versions {
    const val KOTLIN = "1.3.50"
    const val COMPILE_SDK = 29
    const val BUILD_TOOLS = "29.0.2"
    const val MIN_SDK = 23
    const val TARGET_SDK = 29
    const val GRADLE = "3.5.1"
    const val NAV_ARG = "2.1.0-alpha01"
}

object Releases {
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"
}

object Tests {
    private const val JUNIT_VER = "1.1.1"
    private const val ESPRESSO_VER = "3.2.0"

    const val RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    const val JUNIT = "androidx.test.ext:junit:$JUNIT_VER"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:$ESPRESSO_VER"
    const val KOTLIN_TEST_JUNIT = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.KOTLIN}"
}

object Libraries {
    private const val MATERIAL_VER = "1.0.0"
    private const val CL_VER = "1.1.3"
    private const val TESSERACT_VER = "9.0.0"
    private const val NAV_VER = "2.0.0"
    private const val TED_PERMISSION_VER = "2.2.2"

    const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
    const val MATERIAL = "com.google.android.material:material:$MATERIAL_VER"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:$CL_VER"
    const val TESSERACT = "com.rmtheis:tess-two:$TESSERACT_VER"
    const val NAVIGATION = "androidx.navigation:navigation-ui-ktx:${NAV_VER}"
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${NAV_VER}"
    const val TED_PERMISSION = "gun0912.ted:tedpermission:$TED_PERMISSION_VER"
}
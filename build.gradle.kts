plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
//    #para configurar o hilt no seu projeto
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.dagger.hilt) apply false
}
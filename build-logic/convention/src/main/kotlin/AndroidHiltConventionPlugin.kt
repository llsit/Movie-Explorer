import com.example.gradleplugins.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.dagger.hilt.android")
                apply("com.google.devtools.ksp")
            }

            dependencies {
                add("implementation", libs.findLibrary("hilt.navigation.compose").get())
                add("ksp", libs.findLibrary("hilt.compiler").get())
                add("implementation", libs.findLibrary("hilt.android").get())
            }
        }
    }

}
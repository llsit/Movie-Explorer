import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            pluginManager.apply {
                apply("gradlePlugins.android.library")
                apply("gradlePlugins.android.library.compose")
                apply("gradlePlugins.android.hilt")
            }

            dependencies {
                add("implementation", project(":core:design"))
                add("implementation", project(":core:data"))

            }
        }
    }
}
import com.android.build.api.dsl.LibraryExtension
import com.example.gradleplugins.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            project.pluginManager.apply("com.android.library")
            project.pluginManager.apply("org.jetbrains.kotlin.android")

            extensions.configure<LibraryExtension> {
                configureAndroidCompose(this)
            }
        }
    }
}
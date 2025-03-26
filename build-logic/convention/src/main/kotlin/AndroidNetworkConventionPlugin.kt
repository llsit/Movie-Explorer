import com.example.gradleplugins.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidNetworkConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            dependencies {
                add("implementation", libs.findLibrary("retrofit").get())
                add("implementation", libs.findLibrary("retrofit.moshi").get())
                add("api", libs.findLibrary("moshi").get())
                add("ksp", libs.findLibrary("moshi.codegen").get())
            }
        }
    }
}
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

fun commitHash(): String = try {
    val runtime = Runtime.getRuntime()
    val process = runtime.exec("git rev-parse --short HEAD")
    val out = process.inputStream
    out.bufferedReader().readText().trim()
} catch (ignored: Exception) {
    "unknown"
}

val commit: String? = commitHash()

dependencies {
    implementation(project(":whack-utils-api", "default"))
}

tasks.named<ShadowJar>("shadowJar") {
    this.archiveClassifier.set(null as String?)
    this.archiveFileName.set("${project.name}-${project.version}.${this.archiveExtension.getOrElse("jar")}")
    this.destinationDirectory.set(file("$projectDir/../out"))
}

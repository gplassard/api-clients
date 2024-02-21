import net.researchgate.release.ReleaseExtension

plugins {
    id("net.researchgate.release")
}

configure<ReleaseExtension> {
    val module = project.path.split(":")[1]

    tagTemplate.set("$module-\${version}")
    preTagCommitMessage.set("release($module) - pre tag commit: ")
    tagCommitMessage.set("release($module) - creating tag: ")
    newVersionCommitMessage.set("release($module) - new version commit: ")
}

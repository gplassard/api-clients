plugins {
    // https://docs.gradle.org/8.0.2/userguide/toolchains.html#sub:download_repositories
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.4.0")
}


rootProject.name = "api-clients"

include("football-data:smithy")
include("football-data:java-client")

include("api-sports-rugby:smithy")
include("api-sports-rugby:java-client")

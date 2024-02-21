plugins {
    // https://docs.gradle.org/8.0.2/userguide/toolchains.html#sub:download_repositories
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.4.0")
}


rootProject.name = "api-clients"

include("api-sports-rugby")
include("api-sports-rugby:smithy")
include("api-sports-rugby:java-client")
include("api-sports-rugby:java-api")

include("football-data")
include("football-data:smithy")
include("football-data:java-client")
include("football-data:java-api")

include("odds-api")
include("odds-api:smithy")
include("odds-api:java-client")
include("odds-api:java-api")
include("odds-api:pkl")

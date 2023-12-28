$version: "2"

namespace apiSport

use aws.protocols#restJson1

@restJson1
@httpApiKeyAuth(name: "x-apisports-key", in: "header")
service Rugby {
    version: "1.0"
    resources: [GameResource, LeagueResource]
    operations: []
}

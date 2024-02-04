$version: "2"

namespace footballdata


use aws.protocols#restJson1
use footballdata#AreaResource
use footballdata#CompetitionResource
use footballdata#MatchResource
use openapiplugin#openApiType

@restJson1
@httpApiKeyAuth(name: "X-Auth-Token", in: "header")
service FootballData {
    version: "1.0"
    resources: [AreaResource, CompetitionResource, MatchResource]
    operations: []
}

@timestampFormat("date-time")
timestamp Instant

@openApiType(type: "date")
string FullDate


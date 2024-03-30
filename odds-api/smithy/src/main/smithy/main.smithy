$version: "2"

namespace oddsapi

use aws.protocols#restJson1
use footballdata#MatchResource
use openapiextensions#openApiType

@restJson1
@httpApiKeyAuth(name: "X-Auth-Token", in: "header")
service OddsApi {
    version: "1.0"
    resources: [MatchResource]
    operations: []
}

@timestampFormat("date-time")
timestamp Instant

@openApiType(type: "string", format: "date")
string FullDate


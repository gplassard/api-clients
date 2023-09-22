$version: "2"

namespace apiSport

use aws.protocols#restJson1

@restJson1
@httpApiKeyAuth(name: "x-apisports-key", in: "header")
service Rugby {
    version: "1.0"
    resources: [LeagueResource]
    operations: []
}

@timestampFormat("date-time")
timestamp Instant

// https://smithy.io/2.0/spec/protocol-traits.html?highlight=date
// https://datatracker.ietf.org/doc/html/rfc3339.html#section-5.6
// @timestampFormat("date-time")
@pattern("^\\d{4}-\\d{2}-\\d{2}$")
string FullDate


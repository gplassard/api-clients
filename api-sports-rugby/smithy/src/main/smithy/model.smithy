$version: "2"

namespace apiSport


@timestampFormat("date-time")
timestamp Instant

// https://smithy.io/2.0/spec/protocol-traits.html?highlight=date
// https://datatracker.ietf.org/doc/html/rfc3339.html#section-5.6
// @timestampFormat("date-time")
@pattern("^\\d{4}-\\d{2}-\\d{2}$")
string FullDate

structure Country {
    id: String
    name: String
    code: String
    flag: String
}


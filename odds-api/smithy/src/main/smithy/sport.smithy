$version: "2"

namespace footballdata

resource MatchResource {
    operations: [ListSports]
}

@readonly
@tags(["sport"])
@http(method: "GET", uri: "/v4/sports")
operation ListSports {
    input := {
    }
    output: SportList
}


list SportList {
    member: Sport
}

structure Sport {
    key: String
    group: String
    title: String
    description: String
    active: Boolean
    has_outrights: Boolean
}

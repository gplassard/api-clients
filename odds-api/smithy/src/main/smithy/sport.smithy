$version: "2"

namespace footballdata

resource SportResource {
    operations: [ListSports, ListSportOdds]
}

@readonly
@tags(["sport"])
@http(method: "GET", uri: "/v4/sports")
operation ListSports {
    input := {
        @required
        @httpQuery("apiKey")
        apiKey: String
    }
    output: WrappedSportList
}

@readonly
@tags(["sport"])
@http(method: "GET", uri: "/v4/sports/{sport}/odds")
operation ListSportOdds {
    input := {
        @required
        @httpLabel
        sport: String
        @required
        @httpQuery("apiKey")
        apiKey: String
        @required
        @httpQuery("regions")
        regions: String
        @httpQuery("markets")
        markets: String
        @httpQuery("eventIds")
        eventIds: String
        @httpQuery("commenceTimeFrom")
        commenceTimeFrom: String
        @httpQuery("commenceTimeTo")
        commenceTimeTo: String
    }
    output: WrappedOddsList
}

// The actual API returns an array which is not supported in Smithy.
// This wrapper will be removed once transforming into the openapi spec.
structure WrappedSportList {
    wrapped: SportList
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

// The actual API returns an array which is not supported in Smithy.
// This wrapper will be removed once transforming into the openapi spec.
structure WrappedOddsList {
    wrapped: OddList
}

list OddList {
    member: Odd
}

structure Odd {
    id: String
    sport_key: String
    comment_time: String
    home_team: String
    away_team: String
    bookmakers: BookmakerList
}

list BookmakerList {
    member: Bookmaker
}

structure Bookmaker {
    key: String
    title: String
    last_update: String
    markets: ListMarket
}

list ListMarket {
    member: Market
}

structure Market {
    key: String
    outcoumes: ListOutcome
}

list ListOutcome {
    member: Outcome
}

structure Outcome {
    name: String
    price: Integer
}

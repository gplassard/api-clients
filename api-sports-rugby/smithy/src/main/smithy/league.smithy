$version: "2"

namespace apiSport

resource LeagueResource {
    operations: [ListLeagues]
}

@readonly
@tags(["league"])
@http(method: "GET", uri: "/leagues")
operation ListLeagues {
    input := {
        @httpQuery("id")
        id: String
        @httpQuery("name")
        name: String
        @httpQuery("country_id")
        countryId: String
        @httpQuery("type")
        type: LeagueType
        @httpQuery("season")
        season: String
        @httpQuery("search")
        search: String
    }
    output := {
        get: String
        parameters: Document
        errors: Document
        results: Integer
        response: LeaguesList
    }
}

document Error

enum LeagueType {
    league, cup
}

list LeaguesList {
    member: League
}

structure League {
    id: String
    name: String
    type: String
    logo: String
    country: Country
    seasons: LeagueSeasonsList
}
list LeagueSeasonsList {
    member: LeagueSeason
}

structure LeagueSeason {
    season: String
    current: Boolean
    start: FullDate
    end: FullDate
}

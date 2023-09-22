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
        errors: ErrorList
        results: Integer
        response: LeaguesList
    }
}

list ErrorList {
    member: Error
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
    country: LeagueCountry
    seasons: LeagueSeasonsList
}

structure LeagueCountry {
    id: String
    name: String
    code: String
    flag: String
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

$version: "2"

namespace apiSport

resource GameResource {
    operations: [ListGames]
}

@readonly
@tags(["game"])
@http(method: "GET", uri: "/games")
operation ListGames {
    input := {
        @httpQuery("id")
        id: String
        @httpQuery("date")
        date: FullDate
        @httpQuery("league")
        league: String
        @httpQuery("season")
        season: String
        @httpQuery("team")
        team: String
        @httpQuery("timezone")
        timezone: String
    }
    output := {
        get: String
        parameters: Document
        errors: Document
        results: Integer
        response: GamesList
    }
}

list GamesList {
    member: Game
}

structure Game {
    id: String
    date: Instant
    time: String
    timestamp: Long
    timezone: String
    week: String
    status: GameStatus
    country: Country
    league: GameLeague
    teams: GameTeams
    scores: GameScore
    periods: GamePeriods
}

structure GameStatus {
    long: String
    short: String
}

structure GameLeague {
    id: String
    name: String
    type: String
    logo: String
    season: String
}

structure GameTeams {
    home: GameTeam
    away: GameTeam
}

structure GameTeam {
    id: String
    name: String
    logo: String
}

structure GameScore {
    home: Integer
    away: Integer
}

structure GamePeriods {
    first: GameScore
    second: GameScore
    overtime: GameScore
    second_overtime: GameScore
}

$version: "2"

namespace footballdata

resource CompetitionResource {
    operations: [ListCompetitions, GetCompetition, ListCompetitionMatches]
}

@readonly
@tags(["competition"])
@http(method: "GET", uri: "/v4/competitions")
operation ListCompetitions {
    input:= {
    }
    output:= {
        count: Integer
        filters: CompetititionFilters
        competitions: CompetitionList
    }
}

@readonly
@tags(["competition"])
@http(method: "GET", uri: "/v4/competitions/{code}")
operation GetCompetition {
    input:= {
        @required
        @httpLabel
        code: String
        @httpQuery("areas")
        areas: String
    }
    output: Competition
}

@readonly
@tags(["competition"])
@http(method: "GET", uri: "/v4/competitions/{code}/matches")
operation ListCompetitionMatches {
    input := {
        @required
        @httpLabel
        code: String
        @httpQuery("season")
        season: Integer
        @httpQuery("matchDay")
        matchDay: Integer
        @httpQuery("status")
        status: MatchStatus
        @httpQuery("dateFrom")
        dateFrom: FullDate
        @httpQuery("dateTo")
        dateTo: FullDate
        @httpQuery("stage")
        stage: MatchStage
        @httpQuery("group")
        group: MatchGroup
    }
    output := {
        filters: CompetititionMatchesFilters
        matches: MatchList
    }
}


structure CompetititionFilters {

}

list CompetitionList {
    member: CompetitionItem
}

structure CompetitionItem {
    id: Integer
    area: CompetitionArea
    name: String
    code: String
    type: String
    emblem: String
    plan: String
    currentSeason: CompetitionSeason
    numberOfAvailableSeasons: Integer
    lastUpdate: Instant
}

structure CompetitionArea {
    id: Integer
    name: String
    code: String
    flag: String
}

structure CompetitionSeason {
    id: Integer
    startDate: FullDate
    endDate: FullDate
    currentMatchday: Integer
    winner: CompetitionWinner
}

structure CompetitionWinner {
    id: Integer
    name: String
    shortName: String
    tla: String
    crest: String
    address: String
    website: String
    founded: Integer
    clubColors: String
    venue: String
    lastUpdated: Instant
}

structure Competition {
    area: CompetitionArea
    id: Integer
    name: String
    code: String
    type: String
    emblem: String
    currentSeason: CompetitionSeason
    seasons: CompetitionSeasonList
}
list CompetitionSeasonList {
    member: CompetitionSeason
}

structure CompetititionMatchesFilters {
    season: Integer
    matchDay: Integer
    status: MatchStatus
    dateFrom: FullDate
    dateTo: FullDate
    stage: MatchStage
    group: MatchGroup
}

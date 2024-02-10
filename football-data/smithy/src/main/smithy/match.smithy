$version: "2"

namespace footballdata

resource MatchResource {
    operations: [ListMatches, GetMatch]
}

@readonly
@tags(["match"])
@http(method: "GET", uri: "/v4/matches")
operation ListMatches {
    input := {
        @httpQuery("ids")
        ids: String
        @httpQuery("date")
        date: FullDate
        @httpQuery("dateFrom")
        dateFrom: FullDate
        @httpQuery("dateTo")
        dateTo: FullDate
        @httpQuery("status")
        status: String
    }
    output := {
        filters: MatchFilters
        resultSet: MatchResultSet
        matches: MatchList
    }
}


@readonly
@tags(["match"])
@http(method: "GET", uri: "/v4/matches/{matchId}")
operation GetMatch {
    input := {
        @required
        @httpLabel
        matchId: String
    }
    output: Match
}

document MatchFilters

document MatchResultSet

list MatchList {
    member: Match
}

structure Match {
    id: Integer
    area: MatchArea
    competition: MatchCompetition
    season: MatchSeason
    utcDate: Instant
    status: MatchStatus
    matchday: Integer
    stage: MatchStage
    group: MatchGroup
    lastUpdated: Instant
    homeTeam: MatchTeam
    awayTeam: MatchTeam
    score: MatchScore
    referees: MatchRefereeList
}

structure MatchArea {
    id: Integer
    name: String
    code: String
    flag: String
}

structure MatchCompetition {
    id: Integer,
    name: String,
    code: String,
    type: String
    emblem: String
}

structure MatchSeason {
    id: Integer
    startDate: FullDate
    endDate: FullDate
    currentMatchday: Integer
    // winner: null,
    stages: MatchStagesList
}

list MatchStagesList {
    member: String
}

structure MatchTeam {
    id: Integer
    name: String
    shortName: String
    tla: String
    crest: String
}

structure MatchScore {
    winner: String
    duration: String
    fullTime: MatchPeriodScore
    halfTime: MatchPeriodScore
}

structure MatchPeriodScore {
    home: Integer
    away: Integer
}

list MatchRefereeList {
    member: MatchReferee
}

structure MatchReferee {
    id: Integer
    name: String
    type: String
    nationality: String
}

enum MatchStatus {
    SCHEDULED
    TIMED
    IN_PLAY
    PAUSED
    FINISHED
    SUSPENDED
    POSTPONED
    CANCELLED
    AWARDED
}
enum MatchStage {
    FINAL
    THIRD_PLACE
    SEMI_FINALS
    QUARTER_FINALS
    LAST_16
    LAST_32
    LAST_64
    ROUND_4
    ROUND_3
    ROUND_2
    ROUND_1
    GROUP_STAGE
    PRELIMINARY_ROUND
    QUALIFICATION
    QUALIFICATION_ROUND_1
    QUALIFICATION_ROUND_2
    QUALIFICATION_ROUND_3
    PLAYOFF_ROUND_1
    PLAYOFF_ROUND_2
    PLAYOFFS
    REGULAR_SEASON
    CLAUSURA
    APERTURA
    CHAMPIONSHIP_ROUND
    RELEGATION_ROUND
}
enum MatchGroup {
    GROUP_A
    GROUP_B
    GROUP_C
    GROUP_D
    GROUP_E
    GROUP_F
    GROUP_G
    GROUP_H
    GROUP_I
    GROUP_J
    GROUP_K
    GROUP_L
}

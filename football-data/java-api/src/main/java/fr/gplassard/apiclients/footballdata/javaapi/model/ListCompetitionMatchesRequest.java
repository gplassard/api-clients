package fr.gplassard.apiclients.footballdata.javaapi.model;

import fr.gplassard.apiclients.footballdata.javaclient.model.MatchGroup;
import fr.gplassard.apiclients.footballdata.javaclient.model.MatchStage;
import fr.gplassard.apiclients.footballdata.javaclient.model.MatchStatus;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ListCompetitionMatchesRequest(
        String code,
        Integer season,
        Integer matchDay,
        MatchStatus status,
        LocalDate dateFrom,
        LocalDate dateTo,
        MatchStage stage,
        MatchGroup group
) {
}

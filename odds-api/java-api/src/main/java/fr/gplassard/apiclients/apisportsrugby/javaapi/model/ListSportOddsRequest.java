package fr.gplassard.apiclients.apisportsrugby.javaapi.model;

import lombok.Builder;

@Builder
public record ListSportOddsRequest(
        String sport, String regions, String markets, String eventIds, String commenceTimeFrom, String commenceTimeTo
) {
}

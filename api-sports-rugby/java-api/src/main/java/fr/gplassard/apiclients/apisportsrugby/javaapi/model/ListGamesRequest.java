package fr.gplassard.apiclients.apisportsrugby.javaapi.model;

import lombok.Builder;

@Builder
public record ListGamesRequest(
        String id,
        String date,
        String league,
        String season,
        String team,
        String timezone
) {
}

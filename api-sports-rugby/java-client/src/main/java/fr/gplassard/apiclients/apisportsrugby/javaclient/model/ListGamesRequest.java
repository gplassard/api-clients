package fr.gplassard.apiclients.apisportsrugby.javaclient.model;

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

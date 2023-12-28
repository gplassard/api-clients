package fr.gplassard.apiclients.apisportsrugby.javaclient.model;

import lombok.Builder;

@Builder
public record ListLeaguesRequest(
        String id, String name, String countryId, LeagueType type, String season, String search
){}

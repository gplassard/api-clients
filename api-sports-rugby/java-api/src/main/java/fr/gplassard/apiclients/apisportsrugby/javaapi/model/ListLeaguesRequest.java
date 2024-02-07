package fr.gplassard.apiclients.apisportsrugby.javaapi.model;

import fr.gplassard.apiclients.apisportsrugby.javaclient.model.LeagueType;
import lombok.Builder;

@Builder
public record ListLeaguesRequest(
        String id, String name, String countryId, LeagueType type, String season, String search
){}

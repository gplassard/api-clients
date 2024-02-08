package fr.gplassard.apiclients.footballdata.javaapi.model;

import lombok.Builder;

@Builder
public record GetMatchRequest(String matchId) {
}

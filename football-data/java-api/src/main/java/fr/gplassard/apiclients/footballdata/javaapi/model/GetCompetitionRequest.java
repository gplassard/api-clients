package fr.gplassard.apiclients.footballdata.javaapi.model;

import lombok.Builder;

@Builder
public record GetCompetitionRequest(String code, String areas) {
}

package fr.gplassard.apiclients.footballdata.javaapi.model;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ListMatchsRequest(String ids, LocalDate date, LocalDate from, LocalDate to, String status) {
}

package fr.gplassard.apiclients.apisportsrugby.javaapi;

import fr.gplassard.apiclients.apisportsrugby.javaapi.model.ListSportsRequest;

import java.util.List;

public interface OddsSportApi {
    ApiResponse<List<Sport>> listSports(ListSportsRequest request);
}

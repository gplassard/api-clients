package fr.gplassard.apiclients.apisportsrugby.javaapi;

import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiResponse;
import fr.gplassard.apiclients.apisportsrugby.javaapi.model.ListLeaguesRequest;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.League;

import java.util.List;

public interface RugbyLeagueApi {
    ApiResponse<List<League>> listLeagues(ListLeaguesRequest request);
}

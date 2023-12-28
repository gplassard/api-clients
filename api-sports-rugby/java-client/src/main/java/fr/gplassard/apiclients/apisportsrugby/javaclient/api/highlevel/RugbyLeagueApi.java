package fr.gplassard.apiclients.apisportsrugby.javaclient.api.highlevel;

import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiException;
import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiResponse;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.League;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.ListLeaguesRequest;

import java.util.List;

public interface RugbyLeagueApi {
    ApiResponse<List<League>> listLeagues(ListLeaguesRequest request) throws ApiException;
}

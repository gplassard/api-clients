package fr.gplassard.apiclients.apisportsrugby.javaclient.api;

import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiClient;
import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiException;
import fr.gplassard.apiclients.apisportsrugby.javaclient.api.base.LeagueApi;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.League;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.LeagueType;

import java.util.List;

public class RugbyLeagueApi {
    private final LeagueApi leagueApi;

    public RugbyLeagueApi(String apiKey) {
        ApiClient apiClient = new ApiClient();
        apiClient.setRequestInterceptor(r -> r.headers("x-apisports-key", apiKey));
        this.leagueApi = new LeagueApi();
    }

    public List<League> listLeagues(String id, String name, String countryId, LeagueType type, String season, String search) throws ApiException {
         var response = this.leagueApi.listLeaguesWithHttpInfo(id, name, countryId, type, season, search);
         if (response.getData().getErrors() != null && !response.getData().getErrors().isEmpty()) {
             throw new ApiException(
                     response.getStatusCode(),
                     response.getData().getErrors().toString()
             );
         }
         return response.getData().getResponse();
    }

}

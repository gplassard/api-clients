package fr.gplassard.apiclients.apisportsrugby.javaclient.api;

import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiClient;
import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiException;
import fr.gplassard.apiclients.apisportsrugby.javaclient.api.base.LeagueApi;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.League;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.LeagueType;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RugbyLeagueApi {
    private final LeagueApi leagueApi;

    public RugbyLeagueApi(String apiKey) {
        ApiClient apiClient = new ApiClient();
        apiClient.setRequestInterceptor(r -> r.headers("x-apisports-key", apiKey));
        this.leagueApi = new LeagueApi(apiClient);
    }

    public List<League> listLeagues(String id, String name, String countryId, LeagueType type, String season, String search) throws ApiException {
         var response = this.leagueApi.listLeaguesWithHttpInfo(id, name, countryId, type, season, search);
         var errors = this.getErrors(response.getData().getErrors());
         if (!errors.isEmpty()) {
             throw new ApiException(
                     response.getStatusCode(),
                     errors.toString()
             );
         }
         return response.getData().getResponse();
    }

    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> getErrors(Object errors) {
        // errors can either be a JSON array of objects or directly an object if there is only one error
        if (errors == null) {
            return Collections.emptyList();
        }
        if (errors instanceof List) {
            return (List<Map<String, Object>>) errors;
        }
        return Collections.singletonList((Map<String, Object>) errors);
    }

}

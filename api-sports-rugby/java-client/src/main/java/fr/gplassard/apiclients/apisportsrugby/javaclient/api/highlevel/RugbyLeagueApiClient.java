package fr.gplassard.apiclients.apisportsrugby.javaclient.api.highlevel;

import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiClient;
import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiException;
import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiResponse;
import fr.gplassard.apiclients.apisportsrugby.javaclient.api.base.LeagueApi;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.League;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.ListLeaguesRequest;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.ListLeaguesResponseContent;
import fr.gplassard.apiclients.apisportsrugby.javaclient.utils.ResponseUtils;

import java.util.List;

public class RugbyLeagueApiClient implements RugbyLeagueApi {
    private final LeagueApi leagueApi;

    public RugbyLeagueApiClient(String apiKey) {
        ApiClient apiClient = new ApiClient();
        apiClient.setRequestInterceptor(r -> r.headers("x-apisports-key", apiKey));
        this.leagueApi = new LeagueApi(apiClient);
    }

    @Override
    public ApiResponse<List<League>> listLeagues(ListLeaguesRequest request) throws ApiException {
        var response = this.leagueApi.listLeaguesWithHttpInfo(
                request.id(),
                request.name(),
                request.countryId(),
                request.type(),
                request.season(),
                request.search()
        );
        return ResponseUtils.handleResponse(
                response,
                ListLeaguesResponseContent::getErrors,
                ListLeaguesResponseContent::getResponse
        );
    }

}

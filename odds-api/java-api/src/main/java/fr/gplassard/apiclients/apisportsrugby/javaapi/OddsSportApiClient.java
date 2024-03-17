package fr.gplassard.apiclients.apisportsrugby.javaapi;

import fr.gplassard.apiclients.apisportsrugby.javaapi.model.ListSportsRequest;
import fr.gplassard.apiclients.oddsapi.javaclient.ApiClient;
import fr.gplassard.apiclients.oddsapi.javaclient.api.base.SportApi;

import java.util.List;

public class OddsSportApiClient implements OddsSportApi {
    private final SportApi sportApi;

    public OddsSportApiClient(String apiKey) {
        ApiClient apiClient = new ApiClient();
        //apiClient.setRequestInterceptor(r -> r.headers("x-apisports-key", apiKey));
        this.sportApi = new SportApi(apiClient);
    }

    @Override
    public ApiResponse<List<Sport>> listSports(ListSportsRequest request) {
        var response = this.sportApi.getSports(
                request.id(),
                request.date(),
                request.league(),
                request.season(),
                request.team(),
                request.timezone()
        );
        return response;
    }
}

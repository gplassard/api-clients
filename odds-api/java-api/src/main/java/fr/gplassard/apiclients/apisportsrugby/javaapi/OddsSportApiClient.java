package fr.gplassard.apiclients.apisportsrugby.javaapi;

import fr.gplassard.apiclients.apisportsrugby.javaapi.model.ListSportOddsRequest;
import fr.gplassard.apiclients.apisportsrugby.javaapi.model.ListSportsRequest;
import fr.gplassard.apiclients.oddsapi.javaclient.ApiClient;
import fr.gplassard.apiclients.oddsapi.javaclient.ApiResponse;
import fr.gplassard.apiclients.oddsapi.javaclient.api.base.SportApi;
import fr.gplassard.apiclients.oddsapi.javaclient.model.Odd;
import fr.gplassard.apiclients.oddsapi.javaclient.model.Sport;

import java.util.List;

public class OddsSportApiClient implements OddsSportApi {
    private final SportApi sportApi;
    private final String apiKey;

    public OddsSportApiClient(String apiKey) {
        ApiClient apiClient = new ApiClient();
        this.sportApi = new SportApi(apiClient);
        this.apiKey = apiKey;
    }

    @Override
    public ApiResponse<List<Sport>> listSports(ListSportsRequest request) {
        return this.sportApi.listSportsWithHttpInfo(this.apiKey);
    }

    @Override
    public ApiResponse<List<Odd>> listSportOdds(ListSportOddsRequest request) {
        return this.sportApi.listSportOddsWithHttpInfo(
                request.sport(),
                this.apiKey,
                request.regions(),
                request.markets(),
                request.eventIds(),
                request.commenceTimeFrom(),
                request.commenceTimeTo()
        );
    }
}

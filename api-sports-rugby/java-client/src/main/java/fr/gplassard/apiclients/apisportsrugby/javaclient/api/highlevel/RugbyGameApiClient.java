package fr.gplassard.apiclients.apisportsrugby.javaclient.api.highlevel;

import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiClient;
import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiException;
import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiResponse;
import fr.gplassard.apiclients.apisportsrugby.javaclient.api.base.GameApi;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.Game;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.ListGamesRequest;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.ListGamesResponseContent;
import fr.gplassard.apiclients.apisportsrugby.javaclient.utils.ResponseUtils;

import java.util.List;

public class RugbyGameApiClient implements RugbyGameApi {
    private final GameApi gameApi;

    public RugbyGameApiClient(String apiKey) {
        ApiClient apiClient = new ApiClient();
        apiClient.setRequestInterceptor(r -> r.headers("x-apisports-key", apiKey));
        this.gameApi = new GameApi(apiClient);
    }

    @Override
    public ApiResponse<List<Game>> listGames(ListGamesRequest request) throws ApiException {
        var response = this.gameApi.listGamesWithHttpInfo(
                request.id(),
                request.date(),
                request.league(),
                request.season(),
                request.team(),
                request.timezone()
        );
        return ResponseUtils.handleResponse(
                response,
                ListGamesResponseContent::getErrors,
                ListGamesResponseContent::getResponse
        );
    }
}
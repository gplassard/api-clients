package fr.gplassard.apiclients.footballdata.javaapi;

import fr.gplassard.apiclients.footballdata.javaapi.model.GetMatchRequest;
import fr.gplassard.apiclients.footballdata.javaapi.model.ListMatchsRequest;
import fr.gplassard.apiclients.footballdata.javaclient.ApiClient;
import fr.gplassard.apiclients.footballdata.javaclient.ApiResponse;
import fr.gplassard.apiclients.footballdata.javaclient.api.base.MatchApi;
import fr.gplassard.apiclients.footballdata.javaclient.model.GetMatchResponseContent;
import fr.gplassard.apiclients.footballdata.javaclient.model.ListMatchsResponseContent;

public class FootballMatchApiClient implements FootballMatchApi {
    private final MatchApi matchApi;

    public FootballMatchApiClient(String apiKey) {
        ApiClient apiClient = new ApiClient();
        apiClient.setRequestInterceptor(r -> r.headers("X-Auth-Token", apiKey));
        this.matchApi = new MatchApi(apiClient);
    }

    @Override
    public ApiResponse<GetMatchResponseContent> getMatch(GetMatchRequest request) {
        return this.matchApi.getMatchWithHttpInfo(request.matchId());
    }

    @Override
    public ApiResponse<ListMatchsResponseContent> listMatchs(ListMatchsRequest request) {
        return this.matchApi.listMatchsWithHttpInfo(
                request.ids(),
                request.date(),
                request.from(),
                request.to(),
                request.status()
        );
    }
}

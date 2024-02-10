package fr.gplassard.apiclients.footballdata.javaapi;

import fr.gplassard.apiclients.footballdata.javaapi.model.GetCompetitionRequest;
import fr.gplassard.apiclients.footballdata.javaapi.model.ListCompetitionMatchesRequest;
import fr.gplassard.apiclients.footballdata.javaapi.model.ListCompetitionsRequest;
import fr.gplassard.apiclients.footballdata.javaclient.ApiClient;
import fr.gplassard.apiclients.footballdata.javaclient.ApiResponse;
import fr.gplassard.apiclients.footballdata.javaclient.api.base.CompetitionApi;
import fr.gplassard.apiclients.footballdata.javaclient.model.GetCompetitionResponseContent;
import fr.gplassard.apiclients.footballdata.javaclient.model.ListCompetitionMatchesResponseContent;
import fr.gplassard.apiclients.footballdata.javaclient.model.ListCompetitionsResponseContent;

public class FootballCompetitionApiClient implements FootballCompetitionApi {
    private final CompetitionApi competitionApi;

    public FootballCompetitionApiClient(String apiKey) {
        ApiClient apiClient = new ApiClient();
        apiClient.setRequestInterceptor(r -> r.headers("X-Auth-Token", apiKey));
        this.competitionApi = new CompetitionApi(apiClient);
    }

    @Override
    public ApiResponse<GetCompetitionResponseContent> getCompetition(GetCompetitionRequest request) {
        return this.competitionApi.getCompetitionWithHttpInfo(
                request.code(),
                request.areas()
        );
    }

    @Override
    public ApiResponse<ListCompetitionsResponseContent> listCompetitions(ListCompetitionsRequest request) {
        return this.competitionApi.listCompetitionsWithHttpInfo();
    }

    @Override
    public ApiResponse<ListCompetitionMatchesResponseContent> listCompetitionMatches(ListCompetitionMatchesRequest request) {
        return this.competitionApi.listCompetitionMatchesWithHttpInfo(
                request.code(),
                request.season(),
                request.matchDay(),
                request.status(),
                request.dateFrom(),
                request.dateTo(),
                request.stage(),
                request.group()
        );
    }
}

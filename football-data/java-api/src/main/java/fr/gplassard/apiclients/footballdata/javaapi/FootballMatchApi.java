package fr.gplassard.apiclients.footballdata.javaapi;


import fr.gplassard.apiclients.footballdata.javaapi.model.GetMatchRequest;
import fr.gplassard.apiclients.footballdata.javaapi.model.ListMatchesRequest;
import fr.gplassard.apiclients.footballdata.javaclient.ApiResponse;
import fr.gplassard.apiclients.footballdata.javaclient.model.GetMatchResponseContent;
import fr.gplassard.apiclients.footballdata.javaclient.model.ListMatchesResponseContent;

public interface FootballMatchApi {
    ApiResponse<GetMatchResponseContent> getMatch(GetMatchRequest request);

    ApiResponse<ListMatchesResponseContent> listMatches(ListMatchesRequest request);
}

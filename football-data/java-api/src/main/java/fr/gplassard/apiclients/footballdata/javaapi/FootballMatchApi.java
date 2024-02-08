package fr.gplassard.apiclients.footballdata.javaapi;


import fr.gplassard.apiclients.footballdata.javaapi.model.GetMatchRequest;
import fr.gplassard.apiclients.footballdata.javaapi.model.ListMatchsRequest;
import fr.gplassard.apiclients.footballdata.javaclient.ApiResponse;
import fr.gplassard.apiclients.footballdata.javaclient.model.GetMatchResponseContent;
import fr.gplassard.apiclients.footballdata.javaclient.model.ListMatchsResponseContent;

public interface FootballMatchApi {
    ApiResponse<GetMatchResponseContent> getMatch(GetMatchRequest request);
    ApiResponse<ListMatchsResponseContent> listMatchs(ListMatchsRequest request);
}

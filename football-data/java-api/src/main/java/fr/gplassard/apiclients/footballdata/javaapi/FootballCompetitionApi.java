package fr.gplassard.apiclients.footballdata.javaapi;

import fr.gplassard.apiclients.footballdata.javaapi.model.GetCompetitionRequest;
import fr.gplassard.apiclients.footballdata.javaapi.model.ListCompetitionsRequest;
import fr.gplassard.apiclients.footballdata.javaclient.ApiResponse;
import fr.gplassard.apiclients.footballdata.javaclient.model.GetCompetitionResponseContent;
import fr.gplassard.apiclients.footballdata.javaclient.model.ListCompetitionsResponseContent;

public interface FootballCompetitionApi {
    ApiResponse<GetCompetitionResponseContent> getCompetition(GetCompetitionRequest request);
    ApiResponse<ListCompetitionsResponseContent> listCompetitions(ListCompetitionsRequest request);
}

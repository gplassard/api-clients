package fr.gplassard.apiclients.footballdata.javaapi;


import fr.gplassard.apiclients.footballdata.javaapi.model.GetAreaRequest;
import fr.gplassard.apiclients.footballdata.javaapi.model.ListAreasRequest;
import fr.gplassard.apiclients.footballdata.javaclient.ApiResponse;
import fr.gplassard.apiclients.footballdata.javaclient.model.GetAreaResponseContent;
import fr.gplassard.apiclients.footballdata.javaclient.model.ListAreasResponseContent;


public interface FootballAreaApi {
    ApiResponse<GetAreaResponseContent> getArea(GetAreaRequest request);
    ApiResponse<ListAreasResponseContent> listAreas(ListAreasRequest request);
}

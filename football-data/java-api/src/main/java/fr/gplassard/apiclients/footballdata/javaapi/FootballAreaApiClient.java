package fr.gplassard.apiclients.footballdata.javaapi;

import fr.gplassard.apiclients.footballdata.javaapi.model.GetAreaRequest;
import fr.gplassard.apiclients.footballdata.javaapi.model.ListAreasRequest;
import fr.gplassard.apiclients.footballdata.javaclient.ApiClient;
import fr.gplassard.apiclients.footballdata.javaclient.ApiResponse;
import fr.gplassard.apiclients.footballdata.javaclient.api.base.AreaApi;
import fr.gplassard.apiclients.footballdata.javaclient.model.GetAreaResponseContent;
import fr.gplassard.apiclients.footballdata.javaclient.model.ListAreasResponseContent;


public class FootballAreaApiClient implements FootballAreaApi {
    private final AreaApi areaApi;

    public FootballAreaApiClient(String apiKey) {
        ApiClient apiClient = new ApiClient();
        apiClient.setRequestInterceptor(r -> r.headers("X-Auth-Token", apiKey));
        this.areaApi = new AreaApi(apiClient);
    }

    @Override
    public ApiResponse<GetAreaResponseContent> getArea(GetAreaRequest request) {
        return this.areaApi.getAreaWithHttpInfo(
                request.id()
        );
    }

    @Override
    public ApiResponse<ListAreasResponseContent> listAreas(ListAreasRequest request) {
        return this.areaApi.listAreasWithHttpInfo();
    }
}

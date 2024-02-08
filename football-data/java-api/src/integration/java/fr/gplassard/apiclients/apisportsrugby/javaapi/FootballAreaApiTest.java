package fr.gplassard.apiclients.apisportsrugby.javaapi;

import fr.gplassard.apiclients.apisportsrugby.TestUtils;
import fr.gplassard.apiclients.footballdata.javaapi.FootballAreaApi;
import fr.gplassard.apiclients.footballdata.javaapi.FootballAreaApiClient;
import fr.gplassard.apiclients.footballdata.javaapi.model.GetAreaRequest;
import fr.gplassard.apiclients.footballdata.javaapi.model.ListAreasRequest;
import fr.gplassard.apiclients.footballdata.javaclient.ApiException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FootballAreaApiTest {
    private static final FootballAreaApi footballAreaApi = new FootballAreaApiClient(TestUtils.getFootballDataApiKey());

    @Test
    void getArea() {
        var response = footballAreaApi.getArea(GetAreaRequest.builder().id("2081").build());

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getData().getName()).isEqualTo("France");
    }

    @Test
    void getArea_invalid() {
        assertThatThrownBy(() ->
                footballAreaApi.getArea(GetAreaRequest.builder().id("haha").build())
        )
                .isInstanceOf(ApiException.class)
                .hasMessage("getArea call failed with: 400 - {\"message\":\"Argument 'id' is expected to be an integer in a specified range.\",\"errorCode\":400}");
    }

    @Test
    void listAreas() {
        var response = footballAreaApi.listAreas(ListAreasRequest.builder().build());

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getData().getCount()).isGreaterThan(200);
    }
}

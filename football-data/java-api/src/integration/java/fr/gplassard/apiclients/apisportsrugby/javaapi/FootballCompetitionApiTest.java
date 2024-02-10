package fr.gplassard.apiclients.apisportsrugby.javaapi;

import fr.gplassard.apiclients.apisportsrugby.TestUtils;
import fr.gplassard.apiclients.footballdata.javaapi.FootballCompetitionApi;
import fr.gplassard.apiclients.footballdata.javaapi.FootballCompetitionApiClient;
import fr.gplassard.apiclients.footballdata.javaapi.model.GetCompetitionRequest;
import fr.gplassard.apiclients.footballdata.javaapi.model.ListCompetitionMatchesRequest;
import fr.gplassard.apiclients.footballdata.javaapi.model.ListCompetitionsRequest;
import fr.gplassard.apiclients.footballdata.javaclient.ApiException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FootballCompetitionApiTest {
    private static final FootballCompetitionApi footballCompetitionApi = new FootballCompetitionApiClient(TestUtils.getFootballDataApiKey());

    @Test
    void getCompetition() {
        var response = footballCompetitionApi.getCompetition(GetCompetitionRequest.builder().code("FL1").build());

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getData().getName()).isEqualTo("Ligue 1");
    }

    @Test
    void getCompetition_invalid() {
        assertThatThrownBy(() ->
                footballCompetitionApi.getCompetition(GetCompetitionRequest.builder().code("haha").build())
        )
                .isInstanceOf(ApiException.class)
                .hasMessage("getCompetition call failed with: 400 - {\"message\":\"Argument 'competitionId' is expected to be either an integer in a specified range or a competition code.\",\"errorCode\":400}");
    }

    @Test
    void listCompetitions() {
        var response = footballCompetitionApi.listCompetitions(ListCompetitionsRequest.builder().build());

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getData().getCount()).isGreaterThan(10);
    }

    @Test
    void listCompetitionMatches() {
        var response = footballCompetitionApi.listCompetitionMatches(ListCompetitionMatchesRequest.builder().code("FL1").build());

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getData().getMatches()).hasSizeGreaterThan(10);
    }

    @Test
    void listCompetitionMatches_invalid() {
        assertThatThrownBy(() ->
                footballCompetitionApi.listCompetitionMatches(ListCompetitionMatchesRequest.builder().code("haha").build())
        )
                .isInstanceOf(ApiException.class)
                .hasMessage("listCompetitionMatches call failed with: 400 - {\"message\":\"Argument 'competitionId' is expected to be either an integer in a specified range or a competition code.\",\"errorCode\":400}");
    }
}

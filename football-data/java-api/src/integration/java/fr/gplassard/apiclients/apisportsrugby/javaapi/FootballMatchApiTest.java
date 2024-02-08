package fr.gplassard.apiclients.apisportsrugby.javaapi;

import fr.gplassard.apiclients.apisportsrugby.TestUtils;
import fr.gplassard.apiclients.footballdata.javaapi.FootballMatchApi;
import fr.gplassard.apiclients.footballdata.javaapi.FootballMatchApiClient;
import fr.gplassard.apiclients.footballdata.javaapi.model.GetMatchRequest;
import fr.gplassard.apiclients.footballdata.javaapi.model.ListMatchsRequest;
import fr.gplassard.apiclients.footballdata.javaclient.ApiException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FootballMatchApiTest {
    private static final FootballMatchApi footballMatchApi = new FootballMatchApiClient(TestUtils.getFootballDataApiKey());

    @Test
    void getMatch() {
        var response = footballMatchApi.getMatch(GetMatchRequest.builder().matchId("327117").build());

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getData().getHomeTeam().getName()).isEqualTo("Manchester United FC");
        assertThat(response.getData().getAwayTeam().getName()).isEqualTo("Southampton FC");
    }

    @Test
    void getMatch_invalid() {
        assertThatThrownBy(() ->
                footballMatchApi.getMatch(GetMatchRequest.builder().matchId("haha").build())
        )
                .isInstanceOf(ApiException.class)
                .hasMessage("getMatch call failed with: 400 - {\"message\":\"Argument 'id' is expected to be an integer in a specified range.\",\"errorCode\":400}");
    }

    @Test
    void listMatchs() {
        var response = footballMatchApi.listMatchs(ListMatchsRequest.builder().date(LocalDate.of(2024, Month.FEBRUARY, 9)).build());

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getData().getMatches()).hasSize(8);
    }
}

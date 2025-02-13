package fr.gplassard.apiclients.apisportsrugby.javaapi.league;

import fr.gplassard.apiclients.apisportsrugby.javaapi.RugbyLeagueApi;
import fr.gplassard.apiclients.apisportsrugby.javaapi.RugbyLeagueApiClient;
import fr.gplassard.apiclients.apisportsrugby.javaapi.TestUtils;
import fr.gplassard.apiclients.apisportsrugby.javaapi.model.ListLeaguesRequest;
import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LeagueApiTest {
    private static final RugbyLeagueApi leagueApi = new RugbyLeagueApiClient(TestUtils.getApiSportKey());

    @Test
    void listLeagues() {
        var response = leagueApi.listLeagues(ListLeaguesRequest.builder().build());

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getData()).hasSizeGreaterThan(50);
    }

    @Test
    void listLeagues_invalid() {
        assertThatThrownBy(() ->
                leagueApi.listLeagues(ListLeaguesRequest.builder().season("2025").build())
        )
                .isInstanceOf(ApiException.class)
                .hasMessage("[{plan=Free plans do not have access to this season, try from 2021 to 2023.}]");
    }

}

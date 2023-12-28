package fr.gplassard.apiclients.apisportsrugby.javaclient.league;

import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiException;
import fr.gplassard.apiclients.apisportsrugby.javaclient.api.highlevel.RugbyLeagueApi;
import fr.gplassard.apiclients.apisportsrugby.javaclient.api.highlevel.RugbyLeagueApiClient;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.ListLeaguesRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeagueApiTest {
    private static final RugbyLeagueApi leagueApi = new RugbyLeagueApiClient(TestUtils.getApiSportKey());

    @Test
    void listLeagues() throws ApiException {
        var response = leagueApi.listLeagues(ListLeaguesRequest.builder().build());

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getData()).hasSizeGreaterThan(50);
    }

}

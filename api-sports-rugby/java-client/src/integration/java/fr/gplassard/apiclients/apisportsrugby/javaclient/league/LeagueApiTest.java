package fr.gplassard.apiclients.apisportsrugby.javaclient.league;

import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiClient;
import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiException;
import fr.gplassard.apiclients.apisportsrugby.javaclient.api.LeagueApi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeagueApiTest {
    private static LeagueApi leagueApi;

    @BeforeAll
    static void beforeAll() {
        ApiClient apiClient = new ApiClient();
        apiClient.setRequestInterceptor(r -> r.headers("x-apisports-key", System.getenv("APISPORT_KEY")));
        leagueApi = new LeagueApi(apiClient);
    }

    @Test
    void listLeagues() throws ApiException {
        var leaguesResponse = leagueApi.listLeaguesWithHttpInfo(null, null, null, null, null, null);

        assertThat(leaguesResponse.getStatusCode()).isEqualTo(200);
        assertThat(leaguesResponse.getData().getErrors()).isEmpty();

        var leagues = leaguesResponse.getData().getResponse();
        assertThat(leagues).hasSizeGreaterThan(50);
    }

}

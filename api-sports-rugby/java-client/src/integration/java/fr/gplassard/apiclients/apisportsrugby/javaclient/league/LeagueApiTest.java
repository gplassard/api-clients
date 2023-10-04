package fr.gplassard.apiclients.apisportsrugby.javaclient.league;

import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiException;
import fr.gplassard.apiclients.apisportsrugby.javaclient.api.RugbyLeagueApi;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeagueApiTest {
    private static final RugbyLeagueApi leagueApi = new RugbyLeagueApi(System.getenv("APISPORT_KEY"));

    @Test
    void listLeagues() throws ApiException {
        var leagues = leagueApi.listLeagues(null, null, null, null, null, null);

        assertThat(leagues).hasSizeGreaterThan(50);
    }

}

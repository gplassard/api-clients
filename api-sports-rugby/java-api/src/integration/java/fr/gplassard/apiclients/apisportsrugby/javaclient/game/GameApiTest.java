package fr.gplassard.apiclients.apisportsrugby.javaclient.game;

import fr.gplassard.apiclients.apisportsrugby.javaapi.RugbyGameApi;
import fr.gplassard.apiclients.apisportsrugby.javaapi.model.ListGamesRequest;
import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiException;
import fr.gplassard.apiclients.apisportsrugby.javaclient.TestUtils;
import fr.gplassard.apiclients.apisportsrugby.javaapi.RugbyGameApiClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameApiTest {
    private static final RugbyGameApi leagueApi = new RugbyGameApiClient(TestUtils.getApiSportKey());

    @Test
    void listGames() throws ApiException {
        var response = leagueApi.listGames(ListGamesRequest.builder().season("2023").league("16").build());

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getData()).hasSizeGreaterThan(50);
    }

}

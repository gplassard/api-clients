package fr.gplassard.apiclients.apisportsrugby.javaapi.game;

import fr.gplassard.apiclients.apisportsrugby.javaapi.RugbyGameApi;
import fr.gplassard.apiclients.apisportsrugby.javaapi.TestUtils;
import fr.gplassard.apiclients.apisportsrugby.javaapi.model.ListGamesRequest;
import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiException;
import fr.gplassard.apiclients.apisportsrugby.javaapi.RugbyGameApiClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameApiTest {
    private static final RugbyGameApi gameApi = new RugbyGameApiClient(TestUtils.getApiSportKey());

    @Test
    void listGames() {
        var response = gameApi.listGames(ListGamesRequest.builder().season("2023").league("16").build());

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getData()).hasSizeGreaterThan(50);
    }

    @Test
    void listGames_invalid() {
        assertThatThrownBy(() ->
                gameApi.listGames(ListGamesRequest.builder().season("2023").league("aaaa").build())
            )
            .isInstanceOf(ApiException.class)
            .hasMessage("[{league=The League field must contain an integer.}]");
    }

}

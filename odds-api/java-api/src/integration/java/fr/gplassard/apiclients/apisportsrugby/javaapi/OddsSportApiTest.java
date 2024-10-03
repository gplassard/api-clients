package fr.gplassard.apiclients.apisportsrugby.javaapi;

import fr.gplassard.apiclients.apisportsrugby.TestUtils;
import fr.gplassard.apiclients.apisportsrugby.javaapi.model.ListSportOddsRequest;
import fr.gplassard.apiclients.apisportsrugby.javaapi.model.ListSportsRequest;
import fr.gplassard.apiclients.oddsapi.javaclient.ApiException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OddsSportApiTest {
    private static final OddsSportApi oddsSportApi = new OddsSportApiClient(TestUtils.getOddsApiKey());

    @Test
    void listSports() {
        var response = oddsSportApi.listSports(ListSportsRequest.builder().build());

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getData()).hasSizeGreaterThan(5);
    }

    @Test
    void listSportOdds() {
        var response = oddsSportApi.listSportOdds(ListSportOddsRequest.builder().regions("eu").sport("soccer_france_ligue_one").build());

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getData()).hasSizeGreaterThan(5);
    }

    @Test
    void listSportOdds_invalid() {
        assertThatThrownBy(() ->
                oddsSportApi.listSportOdds(ListSportOddsRequest.builder().regions("DoesNotExist").sport("DoesNotExist").build())
        )
                .isInstanceOf(ApiException.class)
                .hasMessage("listSportOdds call failed with: 404 - {\"message\":\"Unknown sport\",\"error_code\":\"UNKNOWN_SPORT\",\"details_url\":\"https://the-odds-api.com/liveapi/guides/v4/api-error-codes.html#unknown-sport\"}\n");
    }
}

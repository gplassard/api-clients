package fr.gplassard.apiclients.apisportsrugby.javaapi;

import fr.gplassard.apiclients.apisportsrugby.javaapi.model.ListSportOddsRequest;
import fr.gplassard.apiclients.apisportsrugby.javaapi.model.ListSportsRequest;
import fr.gplassard.apiclients.oddsapi.javaclient.ApiResponse;
import fr.gplassard.apiclients.oddsapi.javaclient.model.Odd;
import fr.gplassard.apiclients.oddsapi.javaclient.model.Sport;

import java.util.List;

public interface OddsSportApi {
    ApiResponse<List<Sport>> listSports(ListSportsRequest request);
    ApiResponse<List<Odd>> listSportOdds(ListSportOddsRequest request);
}

package fr.gplassard.apiclients.apisportsrugby.javaapi;

import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiResponse;
import fr.gplassard.apiclients.apisportsrugby.javaapi.model.ListGamesRequest;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.Game;

import java.util.List;

public interface RugbyGameApi {
    ApiResponse<List<Game>> listGames(ListGamesRequest request);
}

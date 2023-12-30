package fr.gplassard.apiclients.apisportsrugby.javaclient.api.highlevel;

import fr.gplassard.apiclients.apisportsrugby.javaclient.ApiResponse;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.Game;
import fr.gplassard.apiclients.apisportsrugby.javaclient.model.ListGamesRequest;

import java.util.List;

public interface RugbyGameApi {
    ApiResponse<List<Game>> listGames(ListGamesRequest request);
}

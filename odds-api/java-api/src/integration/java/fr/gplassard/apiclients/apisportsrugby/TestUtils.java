package fr.gplassard.apiclients.apisportsrugby;

public class TestUtils {
    public static String getOddsApiKey() {
        return System.getenv("ODDS_API_KEY");
    }
}

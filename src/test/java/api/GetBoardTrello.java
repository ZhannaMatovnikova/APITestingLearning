package api;

public class GetBoardTrello {
    private String APIKey;
    private String APIToken;
    public GetBoardTrello(){

    }

    public GetBoardTrello(String APIKey, String APIToken) {
        this.APIKey = APIKey;
        this.APIToken = APIToken;
    }

    public String getAPIKey() {
        return APIKey;
    }

    public String getAPIToken() {
        return APIToken;
    }
}

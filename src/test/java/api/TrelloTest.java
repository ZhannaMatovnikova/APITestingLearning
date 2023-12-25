package api;

import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TrelloTest {
    private final static String Url = "https://api.trello.com";

    @Test
    public void getBoard() {
        Specifications.installSpecification(Specifications.requestSpec(Url), Specifications.responseSpec200());
        String APIKey = "5222f89f4bc716e71193444d9f708848";
        String APIToken = "9ffedcbd9afb704ae17b332ae779bdf9a0c4bdd7ace0026ead9b9358a43f9418";
        BoardAtributesTrello newBoard = new BoardAtributesTrello("TestBoard");
        GetBoardTrello getBoardTrello = given()
                .body(newBoard)
                .when()
                .post("/1/boards/")
                .then().log().all()
                .extract().as(GetBoardTrello.class);
        Assert.assertNotNull(getBoardTrello.getAPIKey());
        Assert.assertNotNull(getBoardTrello.getAPIToken());
        Assert.assertEquals(APIKey, getBoardTrello.getAPIKey());
        Assert.assertEquals(APIToken, getBoardTrello.getAPIToken());

    }
}

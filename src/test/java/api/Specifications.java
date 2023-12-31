package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.runner.Request;

public class Specifications {
    public static RequestSpecification requestSpec(String url){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }
    public static ResponseSpecification responseSpec200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    public static ResponseSpecification responseSpecError400(){
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }
    public static ResponseSpecification responseSpec204() {
        return new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();
    }
    public static ResponseSpecification responseSpecUnique (int status){
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();}

    public static void installSpecification(RequestSpecification request, ResponseSpecification responce){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = responce;
    }
}

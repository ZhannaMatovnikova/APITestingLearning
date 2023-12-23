package api;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class RegresTest {
    private final static String Url = "https://reqres.in/";
    @Test
    public void checkAvatarAndIdTest(){
        Specifications.installSpecification(Specifications.requestSpec("https://reqres.in/"), Specifications.responseSpecError400());
        List<UserData> users = given()
                .when()
//                .contentType(ContentType.JSON)
//                .get(Url+"api/users?page=2")
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
//        users.forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
        /* смотрим перебором for each, х - счетчик переменной,
        убедиться, что имена файлов-аватаров совпадают,
         аватар содержит id
         id integer, поэтому меняем на String
         то есть для
        id 7 https://reqres.in/img/faces/7-image.jpg,
        для id 8 "avatar": "https://reqres.in/img/faces/8-image.jpg"
         */


//        Assert.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));//убедиться, что email пользователей оканчиваются на @reqres.ru

        List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());//создаем список аватарок
        List<String> ids = users.stream().map(x->x.getId().toString()).collect(Collectors.toList());//создаем список id, так как integer, то преобразовываем в сто=року toString

        for (int i=0; i<avatars.size(); i++){
           Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }
}

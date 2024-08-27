package api;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.module.jsv.JsonSchemaValidator;


public class ApiClient {
    private static final String BASE_URI = "https://hr-challenge.dev.tapyou.com/api/test/users";

    public ApiClient() {
        RestAssured.baseURI = BASE_URI;
    }

    public  Response getUserByGender(String gender) {
        String url = BASE_URI + "?gender=" + gender;
        Response response = RestAssured.given()
                .when()
                .get(url);
        return response;
}


    public Response getUser() {
        return RestAssured
                .given()
                .when()
                .get(BASE_URI);
    }
}

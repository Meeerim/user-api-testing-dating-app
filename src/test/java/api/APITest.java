package api;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.cert.CertificateRevokedException;

public class APITest {

    private ApiClient apiClient;

    @BeforeClass
    public void setUp() {
        apiClient = new ApiClient();
    }

    @Test(groups = {"positive"})
    @Description("Проверка получения списка пользователей по полу gender = male")
    @Severity(SeverityLevel.CRITICAL)
    public void testGetUserByGenderMale() {
        Response response = apiClient.getUserByGender("male");
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");
        Assert.assertTrue(response.jsonPath().getBoolean("isSuccess"), "isSuccess is not true");
        Assert.assertNull(response.jsonPath().get("errorMessage"), "errorMessage is not null");
        Assert.assertNotNull(response.jsonPath().getList("idList"), "idList is null");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/getUserGender.json"));
    }

    @Test(groups = {"positive"})
    @Description("Проверка получения списка пользователей по полу gender = female")
    @Severity(SeverityLevel.CRITICAL)
    public void testGetUserByGenderFemale() {
        Response response = apiClient.getUserByGender("female");
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");
        Assert.assertTrue(response.jsonPath().getBoolean("isSuccess"), "isSuccess is not true");
        Assert.assertNull(response.jsonPath().get("errorMessage"), "errorMessage is not null");
        Assert.assertNotNull(response.jsonPath().getList("idList"), "idList is null");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/getUserGender.json"));
    }

    @Test(groups = {"negative"})
    @Description("Проверка обработки некорректного значения параметра gender")
    @Severity(SeverityLevel.CRITICAL)
    public void testGetUserByGenderWithIncorrectValue(){
        Response response = apiClient.getUserByGender("gender");
        Assert.assertEquals(response.getStatusCode(),400, "Status code is not 400");
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
        Assert.assertTrue(responseBody.contains("error"), "Response body does not contain expected error message");
    }

    @Test(groups = {"negative"})
    @Description("Проверка обработки запроса без параметра gender")
    @Severity(SeverityLevel.CRITICAL)
    public void testGetUserWithoutGenderParameter(){
        Response response = apiClient.getUser();
        Assert.assertEquals(response.getStatusCode(),400,"Status code is not 400");
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Required String parameter 'gender' is not present"));
    }
}


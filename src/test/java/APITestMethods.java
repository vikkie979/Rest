import io.restassured.RestAssured;
import org.testng.annotations.Test;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class APITestMethods {
    String baseUri = "https://reqres.in";
    @Test
    public void testGetRequest() {
        RestAssured.baseURI = baseUri;
        given()
            .when()
            .get("/api/users/2")
            .then()
            .statusCode(200)
            .body("data.first_name", equalTo("Janet"));
    }
    @Test
    public void testPostRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "John");
        requestBody.put("job", "developer");
        given()
            .baseUri(baseUri)
            .header("Content-Type", "application/json")
            .body(requestBody.toString())
        .when()
            .post("/api/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("John"));
    }
    @Test
    public void testPutRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "John");
        requestBody.put("job", "senior developer");
        given()
            .baseUri(baseUri)
            .header("Content-Type", "application/json")
            .body(requestBody.toString())
        .when()
            .put("/api/users/2")
        .then()
            .statusCode(200)
            .body("job", equalTo("senior developer"));
    }
    @Test
    public void testDeleteRequest() {
        given()
            .baseUri(baseUri)
        .when()
            .delete("/api/users/2")
        .then()
            .statusCode(204);
    }
    @Test
    public void getPosts() {
        given()
            .baseUri("https://jsonplaceholder.typicode.com")
        .when()
            .get("/posts/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("title", notNullValue());
    }
    @Test
    public void createComment() {
        JSONObject json = new JSONObject();
        json.put("postId", 1);
        json.put("name", "Test Name");
        json.put("email", "test@example.com");
        json.put("body", "Nice article!");
        given()
            .baseUri("https://jsonplaceholder.typicode.com")
            .header("Content-Type", "application/json")
            .body(json.toString())
        .when()
            .post("/comments")
        .then()
            .statusCode(201)
            .body("name", equalTo("Test Name"));
    }
    @Test
    public void getGorestUsers() {
        given()
            .baseUri("https://gorest.co.in/public/v2")
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .body("[0].email", containsString("@"));
    }
}
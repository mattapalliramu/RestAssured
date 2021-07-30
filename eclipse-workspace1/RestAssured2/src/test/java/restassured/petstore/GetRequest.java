package restassured.petstore;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest {
	
	public static void main(String[] args) {
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
		System.out.println("********Response**********");
		System.out.println("status code is"+res.statusCode());
		System.out.println("data is");
		System.out.println(res.asString());
		
	}

}
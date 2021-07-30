package restassured.petstore;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest2 {
	
	static String data;
	public static void main(String[] args) {
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("https://petstore.swagger.io/v2/pet/10");
		System.out.println("********Response**********");
		System.out.println("status code is"+res.statusCode());
		System.out.println("data is");
		data = res.asString();
		System.out.println(data);
		
		if(data.contains(data))
		{
			System.out.println("Retrieved succesfully");
		}else {
			System.out.println("No Data");
		}
		
	}

}
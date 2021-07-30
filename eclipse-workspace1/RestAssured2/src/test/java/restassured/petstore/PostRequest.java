package restassured.petstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.json.JSONTokener;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequest {
	
	private static Response response;
	static int status;
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("../RestAssured2/testData.json");
		
		FileReader fr = new FileReader(f);
		JSONTokener js = new JSONTokener(fr);
		JSONObject ob = new JSONObject(js);
		
		String testData=ob.toString();
		Random r = new Random();
		Integer i = r.nextInt();
		
		testData = testData.replaceAll(Pattern.quote("{{"+"id"+"}}"),i.toString());
		
		 Response res= 
		 given().contentType(ContentType.JSON).body(testData)
		  .when().post("https://petstore.swagger.io/v2/pet");
		  
		  System.out.println("status code is"); 
		  status = res.statusCode();
		  System.out.println(status);
		  if(status==200) {
			  System.out.println("Record created");
		  }else {
			  System.out.println("Record not created");
		  }
		 System.out.println(res.asString());
		 List<Long> idList = response.jsonPath().getList("id");
		 System.out.println(idList);
		 
	}

	
	}
	



package restAssuredPackage;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostPut {
	@Test
	public void postPutMethod(){
		
		RestAssured.baseURI="http://demoqa.com/BookStore/v1/Books/";
		RequestSpecification request = RestAssured.given();
		
		
		// JSONObject is class that represents a simple JSON.
		// We can add key value pair using put method.
        JSONObject requestParams = new JSONObject();
		requestParams.put("userId", "TQ123");
		requestParams.put("isbn", "123456678");
		
		
		// Add a header stating the request body is JSON
		request.header("Content-Type/jason","application/jason");// Add the JSON to the body of the request
		request.body(requestParams.toString());// Post the request and check the response
		Response resp = request.post("/BookStoreV1BooksPost");
		System.out.println("The status recived : "+ resp.statusLine());
		System.out.println("The Status recived : "+ resp.statusCode());
		
		
		
	}

}

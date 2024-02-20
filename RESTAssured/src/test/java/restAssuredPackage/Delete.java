package restAssuredPackage;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete {
	
	@Test
	public void deleteRecord() {
		
		int id = 15410; // Local Variable
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		// JSONObject is class that represents a simple JSON.
		// We can add key value pair using put method.
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Subhajit");
		requestParams.put("age", "28");
		requestParams.put("Salary", "70000");
		
		// Add a header stating the request body is JSON
		request.header("Content-Type","application/jason"); // Add the JSON to the body of the request
		Response resp = request.delete("/delete" + id);
		
		System.out.println("The status recived : " + resp.getStatusLine());
		int statusCode = resp.statusCode();
		System.out.println("Status Code : " + statusCode);
		System.out.println(resp.asString());
		Assert.assertEquals(statusCode, 406);
		System.out.println("Assertion Pass");


		
		
	}

}

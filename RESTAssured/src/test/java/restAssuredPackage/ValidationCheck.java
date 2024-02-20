package restAssuredPackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidationCheck {
	
	@Test
	public void validateResponce() {
		

		RestAssured.baseURI="http://demoqa.com/utilities/weather/city";
		RequestSpecification request = RestAssured.given();
		Response resp = request.get("/bangalore");
		System.out.println(resp.asString());
		System.out.println(resp.prettyPrint());
		
		// Retrieve the body response
		ResponseBody body = resp.getBody();
		System.out.println("Response Body : " + body.asString());
		
		// Validate city from response body
		String s = body.asString();
		Assert.assertEquals(s.contains("bangalore"), true);
		Assert.assertEquals(s.contains("Wind Speed"), true);
		System.out.println("bangalore found in body");
		System.out.println("Wind speed found in body");
		
		// Validate status code & status line
		int statusCode = resp.statusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		System.out.println("Status Code Varified");
		
		String statusLine = resp.statusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		System.out.println("Status Line Verified");
		
		

	}

}

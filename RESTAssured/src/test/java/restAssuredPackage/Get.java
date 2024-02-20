package restAssuredPackage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Get {
	
	@Test
	public void getMethod() {
		
		RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books/";
		RequestSpecification httprequest = RestAssured.given();
		Response resp = httprequest.request(Method.GET,"");
		ResponseBody body = resp.getBody();
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());
		System.out.println(resp.prettyPrint());
		System.out.println(body.asString());
		
	}

}

package apitests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import apireusableutils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LogintTest extends APIBaseTest {
	String token;
	
	@Test
	public void loginTC_01() {
		
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
		
//		Response res = RestAssured.given().headers("Content-Type", "application/json").when()
//		.body("{\"username\":\"mithun@ta.com\", \"password\": \"mithun\"}").post("/login")
//		.then().assertThat().statusCode(201).extract().response();
//		
//		System.out.println(res.asPrettyString());
		
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		
		HashMap<String, String> logincreds = new HashMap<>();
		logincreds.put("username", "mithun@ta.com");
		logincreds.put("password", "mithun");
		
		Response res1 =  RestUtils.postReq(logincreds, headers, "/login");
		
		Assert.assertEquals(res1.statusCode(), 201);
		
		token = res1.jsonPath().getString("token").replace("[", "").replace("]", "");
		
	}
	
//	@Test(dependsOnMethods = "loginTC_01")
	public void getData_TC02() {
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Token", token);
		headers.put("Content-Type", "application/json");
		
		Response getUserData = RestUtils.getReq(headers, "/getdata");
		
		System.out.println(getUserData.prettyPrint());
	}

	
//	@Test(dependsOnMethods = "getData_TC02")
	public void addData_TC02() {
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Token", token);
		headers.put("Content-Type", "application/json");
		
		HashMap<String, String> payload = new HashMap<>();
		payload.put("accountno", "");
		payload.put("departmentno", "");
		payload.put("salary", "");
		payload.put("pincode", "");
		
		Response adduserdata = RestUtils.postReq(payload, headers, "/addData");
		
		System.out.println(adduserdata.prettyPrint());
	}
}

package apitests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.JsonPath;

import api.constants.FileConstants;
import api.testdata.AddUser;
import api.utils.CommonUtilities;
import apireusableutils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.CommonUtils;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class LogintTest extends APIBaseTest {
	
	
	@BeforeClass
	public void setURI() throws IOException {
		String uri = CommonUtilities.readFileAndReturnString(FileConstants.URI_FILE_PATH);
		RestAssured.baseURI = JsonPath.read(uri, "$.login.prod");
		System.out.println(RestAssured.baseURI);
	}
	
	
	@Test(enabled = false)
	public void loginTC_01() {
		
		
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
		
		Response res1 =  RestUtils.postReq(logincreds, headers, "/login")
				.then().assertThat().statusCode(201)
				.body(matchesJsonSchema(new File(FileConstants.LOGIN_SCHEMA)))
				.extract().response();
		
//		res1.then().assertThat().body(matchesJsonSchema(new File(FileConstants.LOGIN_SCHEMA)));
		Assert.assertEquals(res1.statusCode(), 201);
//		token = res1.jsonPath().getString("token").replace("[", "").replace("]", "");
		
	}
	
	@Test(enabled = false)
	public void getData_TC02() {
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Token", token);
		headers.put("Content-Type", "application/json");
		
		Response getUserData = RestUtils.getReq(headers, "/getdata");
		
		System.out.println(getUserData.prettyPrint());
	}

	
	@Test(enabled = true)
	public void addData_TC02() throws JsonProcessingException {
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Token", token);
		headers.put("Content-Type", "application/json");
		
//		HashMap<String, String> payload = new HashMap<>();
//		payload.put("accountno", "");
//		payload.put("departmentno", "");
//		payload.put("salary", "");
//		payload.put("pincode", "");
		
		AddUser anu = new AddUser("TA-1234545", "1", "100000", "678987");
		String sPayload = CommonUtilities.serializeObject(anu);
		Response adduserdata = RestUtils.postReq(sPayload, headers, "/addData");
		
		System.out.println(adduserdata.prettyPrint());
	}
}

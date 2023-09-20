package api.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.testdata.AddUser;


public class CommonUtilities {
	
	public static String readFileAndReturnString(String filePath) throws IOException {
		byte[] fileContents = Files.readAllBytes(Paths.get(filePath));
		return new String(fileContents, StandardCharsets.UTF_8);
	}
	
	// To convert object to string and return the same
	public static String serializeObject(Object user) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		String sJsonPayload = om.writeValueAsString(user);
		System.out.println(sJsonPayload);
		return sJsonPayload;
	}
	
	public static Object deSerializeJSON(String sJson) throws JsonMappingException, JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		AddUser au = om.readValue(sJson, AddUser.class);
		return au;
	}

}

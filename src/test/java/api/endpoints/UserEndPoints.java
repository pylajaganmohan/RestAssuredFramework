package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response createUser(User payload) {
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(Routes.create_url);
		
		return res;
		
	}
	
	
	public static Response getUser(String username) {
		Response res = given()
							.pathParam("username", username)
							
						.when()
							.get(Routes.get_url);
		
		return res;
	}
	
	public static Response updateUser( String username, User payload) {
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
			
		.when()
			.put(Routes.update_url);
		
		return res;
		
	}
	
	public static Response deleteUser(String username) {
		Response res = given()
							.pathParam("username", username)
							
						.when()
							.get(Routes.delete_url);
		
		return res;
	}
}

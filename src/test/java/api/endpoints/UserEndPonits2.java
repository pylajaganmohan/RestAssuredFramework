package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPonits2 {
	
	//Method created for getting URLs from properties file
	static ResourceBundle getURL(){
		ResourceBundle routes = ResourceBundle.getBundle("routes"); //Load properties file
		return routes;
	}
	
	public static Response createUser(User payload) {
		
		String post_url = getURL().getString("create_url");
		
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(post_url);
		
		return res;
		
	}
	
	
	public static Response getUser(String username) {
		String get_url = getURL().getString("get_url");
		
		Response res = given()
							.pathParam("username", username)
							
						.when()
							.get(get_url);
		
		return res;
	}
	
	public static Response updateUser( String username, User payload) {
		String update_url = getURL().getString("update_url");
		
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
			
		.when()
			.put(update_url);
		
		return res;
		
	}
	
	public static Response deleteUser(String username) {
		String delete_url = getURL().getString("delete_url");
		
		Response res = given()
							.pathParam("username", username)
							
						.when()
							.get(delete_url);
		
		return res;
	}
}

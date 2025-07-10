package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.GoRestUser;
import api.utilities.AuthUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GoRestEndPonits {
	
	public static Response createGoRestUser(GoRestUser payload) {
		Response res = given()
					.spec(AuthUtil.getAuthSpec())
					.contentType(ContentType.JSON)
					.body(payload)
					
					.when()
						.post(Routes.gorest_createUrl);
		
		return res;
		
	}
	
	public static Response getGoRestUser(int userid) {
		Response res = given()
						.pathParam("userid", userid)
						
						.when().get(Routes.gorest_getUrl);
		
		return res;
						
	}
	
	public static Response updateGoRestUser(GoRestUser payload, int userid) {
		Response res = given()
					.spec(AuthUtil.getAuthSpec())
					.contentType(ContentType.JSON)
					.pathParam("userid", userid)
					.body(payload)
					
					.when()
						.post(Routes.gorest_updateUrl);
		
		return res;
		
	}
	
	public static Response deleteGoRestUser(int userid) {
		Response res = given()
						.spec(AuthUtil.getAuthSpec())
						.pathParam("userid", userid)
						
						.when().delete(Routes.gorest_deleteUrl);
		
		return res;
						
	}
}

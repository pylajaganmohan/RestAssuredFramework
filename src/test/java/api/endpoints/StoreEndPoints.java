package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {

	public static Response creatOrder(Store payload) {
		Response res = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
					.post(Routes.store_createOrderUrl);
		
		return res;
	}
	
	public static Response getOrder(long orderId) {
		Response res = given()
				.pathParam("orderId", orderId)
				
				.when()
					.get(Routes.store_getOrderUrl);
		
		return res;
	}
	
	public static Response deleteOrder(long orderId) {
		Response res = given()
				.pathParam("orderId", orderId)
				
				.when()
					.delete(Routes.store_deleteOrderUrl);
		
		return res;
	}
	
	public static Response getInventory() {
		Response res = given()
					.accept(ContentType.JSON)
				.when()
					.get(Routes.store_getInventoryUrl);
		
		return res;
	}
	
	
}

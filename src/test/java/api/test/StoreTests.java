package api.test;

import org.joda.time.Instant;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {

	Faker faker;
	Store payload;
	
	@BeforeClass
	public void setUpData() {
		faker = new Faker();
		payload = new Store();
		
		payload.setId(faker.number().randomNumber());
		payload.setPetId(faker.number().numberBetween(1, 1000));
		payload.setQuantity(faker.number().numberBetween(1, 10));
		payload.setShipDate(Instant.now().toString());
		payload.setStatus(Store.Status.PLACED);
		payload.setComplete(faker.bool().bool());
	}
	
	@Test(priority=1)
	public void testGetInventory() {
		Response response = StoreEndPoints.getInventory();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void testCreateOrder() {
		Response response = StoreEndPoints.creatOrder(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testGetOrder() {
		Response response = StoreEndPoints.getOrder(this.payload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void testDeleteOrder() {
		Response response = StoreEndPoints.deleteOrder(this.payload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
}

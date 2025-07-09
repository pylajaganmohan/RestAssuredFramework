package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User payload;
	public Logger logger;

	@BeforeClass
	void setupData() {
		faker = new Faker();
		payload = new User();

		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().username());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(5, 20));
		payload.setPhone(faker.phoneNumber().cellPhone());

		// logs
		logger = LogManager.getLogger(this.getClass());
	}

	@Test(priority = 1)
	public void testCreateUser() {
		logger.info("*********Creating User**********");
		
		Response response = UserEndPoints.createUser(payload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.header("Content-Type"), "application/json");
		
		logger.info("********* User Created **********");

	}

	@Test(priority = 2)
	public void testGetUser() {
		logger.info("*********Retriving User details**********");
		Response response = UserEndPoints.getUser(this.payload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("*********User details displayed**********");
	}

	@Test(priority = 3)
	public void testUpdateUser() {
		logger.info("*********updating User**********");
		// update data using payload
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());

		Response response = UserEndPoints.updateUser(this.payload.getUsername(), payload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.header("Content-Type"), "application/json");

		// Check data after update
		Response responseAfterUpdate = UserEndPoints.getUser(payload.getUsername());
		responseAfterUpdate.then().log().all();
		Assert.assertEquals(this.payload.getEmail(), responseAfterUpdate.body().jsonPath().getString("email"));
		
		logger.info("*********User Updated**********");
	}

	@Test(priority = 4)
	public void testDeleteUser() {
		logger.info("*********Deleting User**********");
		Response response = UserEndPoints.deleteUser(payload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("*********User Deleted**********");
	}
}

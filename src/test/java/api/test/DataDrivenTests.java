package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {

	User payload;

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testCreateUsers(String id, String username, String firstName, String lastName, String email,
			String password, String phone) {
		payload = new User();
		payload.setId(Integer.parseInt(id));
		payload.setUsername(username);
		payload.setFirstName(firstName);
		payload.setLastName(lastName);
		payload.setEmail(email);
		payload.setPassword(password);
		payload.setPhone(phone);
		
		Response res = UserEndPoints.createUser(payload);
		Assert.assertEquals(res.getStatusCode(), 200);

	}
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testGetUsers(String username) {
		Response res = UserEndPoints.getUser(username);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 3, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUsers(String username) {
		Response res = UserEndPoints.deleteUser(username);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}

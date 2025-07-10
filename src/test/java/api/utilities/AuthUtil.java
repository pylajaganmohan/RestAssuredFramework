package api.utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class AuthUtil {

	public static String getToken() {
		return "Bearer 91ca1f0ffc19cdc1816b447a41485dcde0849c03b4dbd70c8a08974a93d2deac";
	}

	public static RequestSpecification getAuthSpec() {
		RequestSpecification reqSpec = new RequestSpecBuilder()
					.addHeader("Authorizathion", getToken())
					.build();

		return reqSpec;
	}
}

package api.endpoints;

/*
 * 
 * Swagger URI - https://petstore.swagger.io/
 * 
 * Create User(POST): https://petstore.swagger.io/v2/user
 * Get User(GET): https://petstore.swagger.io/v2/user/{username}
 * Update User(PUT): https://petstore.swagger.io/v2/user/{username}
 * Delete User(DELETE): https://petstore.swagger.io/v2/user/{username}
 * 
 */

public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Module
	public static String create_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	//Store Module
	public static String store_getInventoryUrl =base_url+"/store/inventory";
	public static String store_createOrderUrl =base_url+"/store/order";
	public static String store_getOrderUrl =base_url+"/store/order/{orderId}";
	public static String store_deleteOrderUrl =base_url+"/store/order/{orderId}";
	
	//GoRest API
	public static String gorest_createUrl = "https://gorest.co.in/public/v2/users";
	public static String gorest_getUrl = "https://gorest.co.in/public/v2/users/{userid}";
	public static String gorest_updateUrl = "https://gorest.co.in/public/v2/users/{userid}";
	public static String gorest_deleteUrl = "https://gorest.co.in/public/v2/users/{userid}";
}

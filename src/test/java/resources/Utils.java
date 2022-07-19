package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	static RequestSpecification req;
	
	/**
	 * Method for request SpecBuilder
	 * @return
	 */
	public RequestSpecification requestSpecification() {
		
		if (req==null) {
			
			PrintStream log = null;
			try {
				log = new PrintStream(new FileOutputStream("logging.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req = new RequestSpecBuilder().
					setBaseUri(getGlobalvalues("baseUrl")).
					addQueryParam("key", "qaclick123").
					addFilter(RequestLoggingFilter.logRequestTo(log)).
					addFilter(ResponseLoggingFilter.logResponseTo(log)).
					setContentType(ContentType.JSON).build();
			return req;
		}
		
	return req;
	
	}
	
	
	/**
	 * Method to read global values from properties file
	 * @param key
	 * @return
	 */
	
	public static String getGlobalvalues(String key) {
		Properties prop=new Properties();
		try {
			FileInputStream file=new FileInputStream("./src/test/java/resources/global.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
	
	
	
	/**
	 * Method to read json response 
	 * @param response
	 * @param key
	 * @return
	 */
	
	public String getJsonPath(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}

}

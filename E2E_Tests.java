package apiTests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class E2E_Tests {

    //public static void main(String[] args) {
      
	    String userID = "11084df8-3433-4aac-91b6-0fa50d0ba7ca";
        String userName = "qa1";
        String password = "Balamurthy@123";
        String baseUrl = "https://bookstore.toolsqa.com";
        static String token;
        String isbn = "9781593275846";
        Response response;
        String jsonString;
        static RequestSpecification request;
        
        @BeforeClass
        public void setup() {
			
			RestAssured.baseURI = baseUrl;
			 request = RestAssured.given();
        }
        
        @Test
        public void generateToken()
        {
        //Step - 1
        //Test will start from generating Token for Authorization
        request.header("Content-Type", "application/json");

         response = request.body("{ \"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}")
                .post("/Account/v1/GenerateToken");

        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);

        jsonString = response.asString();
        Assert.assertTrue(jsonString.contains("token"));

        //This token will be used in later requests
        token = JsonPath.from(jsonString).get("token");
        System.out.println("Token: " + token);
        }
        @Test(dependsOnMethods = {"generateToken"})
        public void getBooks()
		{
        //Step - 2
        // Get Books - No Auth is required for this.
        response = request.get("/BookStore/v1/Books");

        Assert.assertEquals(response.getStatusCode(), 200);

        jsonString = response.asString();
        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        
        
        System.out.println("There are : " + books.size() + " Books!");
        
        for (int i = 0;i < books.size();i++) {
        	System.out.println("Title:" + books.get(i).get("title")+ " Subtitle:" +books.get(i).get("subTitle") );
        }
        
        Assert.assertTrue(books.size() > 0);
		}
        
        @Test(dependsOnMethods= {"generateToken"})
        public void addBook()
        {
        //This isbn will be used in later requests, to add the book with respective isbn
        System.out.println("Isbn: " + isbn);

        //Step - 3
        // Add a book - with Auth Bearer Token
        //The token we had saved in the variable before from response in Step 1, 
        //we will be passing in the headers for each of the succeeding request
        
        String bodyString = 
        		"{"
                		+ "  \"userId\":\""  + userID + "\"" + ","
                		+ "  \"collectionOfIsbns\":"  
                		+ "["
                		+     "{"
                		+ "  \"isbn\":\""  + isbn + "\""
                		+ "    }"
                		+  "  ]"
                		+ "}";
        
        System.out.println(bodyString);

        		response  = given()
        	    .header("Authorization", "Bearer " + token)
        	    .contentType(ContentType.JSON)
        	    .body(bodyString)
        	    .when()
        	    .post("https://bookstore.toolsqa.com/BookStore/v1/Books");

        	System.out.println(response.getStatusCode());
        	System.out.println(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(),201);
        

        }
/*
        //Step - 4
        // Delete a book - with Auth
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"isbn\": \"" + bookId + "\", \"userId\": \"" + userID + "\"}")
                .delete("/BookStore/v1/Book");

        Assert.assertEquals(204, response.getStatusCode());
*/



@Test(dependsOnMethods = {"addBook"})
public void getUser() 
{
        //Step - 5
        // Get User
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.get("/Account/v1/User/" + userID);
        Assert.assertEquals(200, response.getStatusCode());
        
        jsonString = response.asString();
        List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
        //Assert.assertEquals(0, booksOfUser.size());
        
        //Get all books
        request.header("Authorization", "Bearer " + token)
        .header("Content-Type", "application/json");

         response= request.get("/BookStore/v1/Books");
        System.out.println(response.getStatusCode());
    }
}
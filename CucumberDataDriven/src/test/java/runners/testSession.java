package runners;

import java.io.IOException;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class testSession {
    
    @Test 
    public void abc() throws InterruptedException, IOException
    {
        String strbody = "{ " +
"\"userData\" : {" +
    "\"username\":\"FFDCUSER1\"," +
    "\"company\":\"SCOTTLEVER\"}, " +
    "\"requestData\" : { " +
        "\"password\":\"password\"" +
    "}" +
"}" ;
        String sessionId1 = RestAssured.given()
                .contentType("application/json")
                .body(strbody)
                .when()

                .post("http://blrcswfbcc0042:9080/featurebranch/restportal/login")
                .then().log().all()
                .statusCode(200)
                .extract().response().andReturn().sessionId();
        System.out.println(sessionId1);
        
        
        Response res =given().
                sessionId(sessionId1).
                when().
                get("http://blrcswfbcc0042:9080/featurebranch/restportal/countries").
                then().
                extract().response();
        
        System.out.println(res.asString());
        
        
        
    }
}

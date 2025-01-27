package petstore.tests;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        File configFile = new File("src/test/resources/petstore-config.properties");
        Config config = ConfigFactory.parseFile(configFile);
        RestAssured.baseURI = config.getString("baseURI");
        RestAssured.basePath = config.getString("basePath");
    }
}

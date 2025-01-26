package petstore.api.tests;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import petstore.api.controllers.store.StoreController;

import java.io.File;

public class BaseTest {
    static protected StoreController storeController;

    @BeforeAll
    public static void setUp() {
        File configFile = new File("src/test/resources/config.properties");
        Config config = ConfigFactory.parseFile(configFile);
        RestAssured.baseURI = config.getString("baseURI");
        RestAssured.basePath = config.getString("basePath");
        storeController = new StoreController();
    }
}

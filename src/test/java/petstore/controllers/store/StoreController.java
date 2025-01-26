package petstore.controllers.store;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class StoreController {
    private final RequestSpecification requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .build();

    public Response getInventory() {
        return given(requestSpecification)
                .when()
                .get("inventory");
    }

    public Response postOrder(Object order) {
        return given(requestSpecification)
                .when()
                .body(order)
                .post("order");
    }

    public Response getOrder(String orderId) {
        return given(requestSpecification)
                .when()
                .get("order/" + orderId);
    }

    public Response deleteOrder(String orderId) {
        return given(requestSpecification)
                .when()
                .delete("order/" + orderId);
    }
}

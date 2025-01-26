package petstore.api.steps.store;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import petstore.api.controllers.store.StoreController;
import petstore.api.models.store.Order;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StoreSteps extends StoreController {
    @Step("Successful inventory GET request")
    public StoreSteps getInventoryOk() {
        Response response = getInventory();
        assertStatusCode(HttpStatus.SC_OK, response);
        return this;
    }

    @Step("Successful order POST request")
    public StoreSteps postOrderOk(Order order) {
        Response response = postOrder(order);
        assertStatusCode(HttpStatus.SC_OK, response);
        return this;
    }

    @Step("Failed order POST request")
    public StoreSteps postOrderBadRequest(Object order) {
        Response response = postOrder(order);
        assertStatusCode(HttpStatus.SC_BAD_REQUEST, response);
        return this;
    }

    @Step("Successful order GET request")
    public Order getOrderById(String orderId) {
        Response response = getOrder(orderId);
        assertStatusCode(HttpStatus.SC_OK, response);
        return response.as(Order.class);
    }

    @Step("Order not found on GET request")
    public StoreSteps getNotFoundOrderById(String orderId) {
        Response response = getOrder(orderId);
        assertStatusCode(HttpStatus.SC_NOT_FOUND, response);
        return this;
    }

    @Step("Successful order DELETE request")
    public StoreSteps deleteOrderById(String orderId) {
        Response response = deleteOrder(orderId);
        assertStatusCode(HttpStatus.SC_OK, response);
        return this;
    }

    @Step("Status code assertion")
    private void assertStatusCode(int ExpectedStatus, Response response) {
        assertThat(response.statusCode(), equalTo(ExpectedStatus));
    }

    @Step("Order data assertion")
    public StoreSteps assertOrderData(Order expectedOrder) {
        Order order = getOrderById(expectedOrder.getId().toString());
        assertThat(order, equalTo(expectedOrder));
        return this;
    }
}

package petstore.tests.store;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import petstore.models.store.Order;
import petstore.steps.store.StoreSteps;
import petstore.tests.BaseTest;
import petstore.utils.TestDataGenerator;

@Epic("Pet Store")
@Feature("Order")
@Story("Get")
@DisplayName("GET /store/order/{orderId} test cases")
public class GetOrderTest extends BaseTest {
    private final StoreSteps storeSteps = new StoreSteps();

    @Test
    @DisplayName("GET /order/{orderId} request with valid id - OK")
    public void getOrderTest() {
        Order order = TestDataGenerator.generateNewOrder();
        storeSteps.postOrderOk(order).assertOrderData(order);
    }

    @Test
    @DisplayName("GET /order/{orderId} request with invalid id - Not Found")
    public void getNotFoundOrderTest() {
        storeSteps.getNotFoundOrderById("-1");
    }
}

package petstore.api.tests.store;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import petstore.api.models.store.Order;
import petstore.api.steps.store.StoreSteps;
import petstore.api.tests.BaseTest;
import petstore.api.utils.TestDataGenerator;

@Epic("Pet Store")
@Feature("Order")
@Story("Delete")
@DisplayName("DELETE /store/order/{orderId} test cases")
public class DeleteOrderTest extends BaseTest {
    private final StoreSteps storeSteps = new StoreSteps();

    @Test
    @DisplayName("DELETE /order/{orderId} - OK")
    public void deleteOrder() {
        Order order = TestDataGenerator.generateNewOrder();
        storeSteps.postOrderOk(order)
            .deleteOrderById("1")
            .getNotFoundOrderById(order.getId().toString());
    }
}

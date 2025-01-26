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
@Story("Post")
@DisplayName("POST /store/order test cases")
public class PostOrderTest extends BaseTest {
    private final StoreSteps storeSteps = new StoreSteps();

    @Test
    @DisplayName("POST /order - OK")
    public void postOrderSuccessfullyTest() {
        Order order = TestDataGenerator.generateNewOrder();
        storeSteps.postOrderOk(order).assertOrderData(order);
    }

    @Test
    @DisplayName("POST /order with incorrect data - BAD REQUEST")
    public void postOrderBadRequestTest() {
        String wrongOrderJson = "{ \"id\": wrongId }";
        storeSteps.postOrderBadRequest(wrongOrderJson);
    }
}

package petstore.api.tests.store;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import petstore.api.models.store.Inventory;
import petstore.api.models.store.Order;
import petstore.api.steps.store.StoreSteps;
import petstore.api.tests.BaseTest;
import petstore.api.utils.TestDataGenerator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Epic("Pet Store")
@Feature("Inventory")
@Story("Get")
@DisplayName("GET /store/inventory test cases")
public class GetInventoryTest extends BaseTest {
    private final StoreSteps storeSteps = new StoreSteps();

    @Test
    @DisplayName("GET /inventory - OK")
    public void getInventoryTest() {
        storeSteps.getInventoryOk();
    }

    @Test
    @DisplayName("Verify inventory quantities are updated after order")
    public void verifyInventoryQuantitiesAfterOrder() {
        Inventory initialInventory = storeSteps.getInventory().as(Inventory.class);

        int placedQuantity = storeSteps.postOrder(TestDataGenerator.generateNewOrder()).as(Order.class).getQuantity();
        int approvedQuantity = storeSteps.postOrder(TestDataGenerator.generateApprovedOrder()).as(Order.class).getQuantity();
        int deliveredQuantity = storeSteps.postOrder(TestDataGenerator.generateDeliveredOrder()).as(Order.class).getQuantity();

        Inventory finalInventory = storeSteps.getInventory().as(Inventory.class);

        assertThat(finalInventory.getPlaced(), equalTo(initialInventory.getPlaced() + placedQuantity));
        assertThat(finalInventory.getApproved(), equalTo(initialInventory.getApproved() + approvedQuantity));
        assertThat(finalInventory.getDelivered(), equalTo(initialInventory.getDelivered() + deliveredQuantity));
    }
}

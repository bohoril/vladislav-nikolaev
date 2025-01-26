package petstore.api.utils;

import petstore.api.models.store.Order;
import petstore.api.models.store.Status;

import java.util.Date;
import java.util.Random;

public class TestDataGenerator {
    private static Order generateOrder(Status status, Boolean complete) {
        return Order.builder()
                .id(getRandomInt())
                .petId(getRandomInt())
                .quantity(getRandomInt())
                .shipDate(new Date())
                .status(status)
                .complete(complete)
                .build();
    }

    public static Order generateNewOrder() {
        return generateOrder(Status.placed, false);
    }

    public static Order generateApprovedOrder() {
        return generateOrder(Status.approved, false);
    }

    public static Order generateDeliveredOrder() {
        return generateOrder(Status.delivered, true);
    }

    private static Integer getRandomInt() {
        return new Random().nextInt(Integer.MAX_VALUE);
    }
}

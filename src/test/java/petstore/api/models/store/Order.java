package petstore.api.models.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer id;
    private Integer petId;
    private Integer quantity;
    private Date shipDate;
    private Status status;
    private Boolean complete;
}

package petstore.models.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    private Integer placed;
    private Integer approved;
    private Integer delivered;
}

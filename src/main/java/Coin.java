import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Coin {

    private String name;
    private BigDecimal value;
    private int quantity;


    @Override
    public String toString() {
        return "\n" + "Coin{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", quantity=" + quantity +
                '}';
    }
}

package lk.ijse.supermarket.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
/*@Setter
@Getter
@ToString
@EqualsAndHashCode*/
public class Item {
    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
}

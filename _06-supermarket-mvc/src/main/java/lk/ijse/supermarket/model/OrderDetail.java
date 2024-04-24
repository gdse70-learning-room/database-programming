package lk.ijse.supermarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetail {
    private String orderId;
    private String itemCode;
    private int qty;
    private double unitPrice;
}

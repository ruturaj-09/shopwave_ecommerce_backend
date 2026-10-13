package com.shopwave.response;

import com.shopwave.dto.OrderHistory;
import com.shopwave.model.Cart;
import com.shopwave.model.Product;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FunctionResponse {
    private String functionName;
    private Cart userCart;
    private OrderHistory orderHistory;
    private Product product;
}

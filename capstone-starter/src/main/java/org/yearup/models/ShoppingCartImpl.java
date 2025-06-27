package org.yearup.models;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartImpl extends ShoppingCart {public class ShoppingCart {
    private Map<String, ShoppingCartItem> items = new HashMap<>();
    private BigDecimal total;

    // getters and setters
}

    public class ShoppingCartItem {
        private Product product;
        private int quantity;
        private BigDecimal discountPercent;
        private BigDecimal lineTotal;

        // getters and setters
    }
}

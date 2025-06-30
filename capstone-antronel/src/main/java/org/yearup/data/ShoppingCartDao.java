package org.yearup.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import java.util.List;

public interface ShoppingCartDao
{

    List<ShoppingCartItem> getCartItemsByUserId(int userId);

    ShoppingCart getByUserId(int userId);


    void addProduct(int userId, int productId);


    void updateQuantity(int userId, int productId, int quantity);


    void clearCart(int userId);


    void removeProduct(int userId, int productId);
}



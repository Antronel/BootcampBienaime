package org.yearup.data.mysql;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import java.util.List;

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    private final JdbcTemplate jdbcTemplate;

    public ShoppingCartDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ShoppingCartItem> getCartItemsByUserId(int userId) {
        // your SQL logic here
        return null;
    }

    @Override
    public ShoppingCart getByUserId(int userId) {
        return null;
    }

    @Override
    public void addProduct(int userId, int productId) {

    }

    @Override
    public void updateQuantity(int userId, int productId, int quantity) {

    }

    @Override
    public void clearCart(int userId) {

    }

    @Override
    public void removeProduct(int userId, int productId) {

    }

    // implement other methods: add, update, delete, etc.
}

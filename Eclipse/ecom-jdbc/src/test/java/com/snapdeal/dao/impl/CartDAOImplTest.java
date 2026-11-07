
package com.snapdeal.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import com.snapdeal.model.Cart;
import com.snapdeal.util.DBConnection;

class CartDAOImplTest {

    private CartDAOImpl cartDAO;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @BeforeEach
    void setUp() throws SQLException {

        cartDAO = new CartDAOImpl();

        connection = mock(Connection.class);
        preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
    }

    @Test
    void testAddToCartSuccess() throws SQLException {

        Cart cart = new Cart();
        cart.setCustomerId(1L);
        cart.setProductId(10L);
        cart.setQuantity(2);

        when(connection.prepareStatement(anyString()))
                .thenReturn(preparedStatement);

        when(preparedStatement.executeUpdate())
                .thenReturn(1);

        try (MockedStatic<DBConnection> mockedDB =
                     mockStatic(DBConnection.class)) {

            mockedDB.when(DBConnection::getConnection)
                    .thenReturn(connection);

            boolean result = cartDAO.addToCart(cart);

            assertTrue(result);

            verify(preparedStatement).setLong(1, 1L);
            verify(preparedStatement).setLong(2, 10L);
            verify(preparedStatement).setInt(3, 2);
            verify(preparedStatement).executeUpdate();
        }
    }

    @Test
    void testAddToCartFailure() throws SQLException {

        Cart cart = new Cart();
        cart.setCustomerId(1L);
        cart.setProductId(10L);
        cart.setQuantity(2);

        when(connection.prepareStatement(anyString()))
                .thenReturn(preparedStatement);

        when(preparedStatement.executeUpdate())
                .thenReturn(0);

        try (MockedStatic<DBConnection> mockedDB =
                     mockStatic(DBConnection.class)) {

            mockedDB.when(DBConnection::getConnection)
                    .thenReturn(connection);

            assertFalse(cartDAO.addToCart(cart));
        }
    }

    @Test
    void testRemoveFromCartSuccess() throws SQLException {

        when(connection.prepareStatement(anyString()))
                .thenReturn(preparedStatement);

        when(preparedStatement.executeUpdate())
                .thenReturn(1);

        try (MockedStatic<DBConnection> mockedDB =
                     mockStatic(DBConnection.class)) {

            mockedDB.when(DBConnection::getConnection)
                    .thenReturn(connection);

            assertTrue(cartDAO.removeFromCart(5L));

            verify(preparedStatement).setLong(1, 5L);
        }
    }

    @Test
    void testRemoveFromCartFailure() throws SQLException {

        when(connection.prepareStatement(anyString()))
                .thenReturn(preparedStatement);

        when(preparedStatement.executeUpdate())
                .thenReturn(0);

        try (MockedStatic<DBConnection> mockedDB =
                     mockStatic(DBConnection.class)) {

            mockedDB.when(DBConnection::getConnection)
                    .thenReturn(connection);

            assertFalse(cartDAO.removeFromCart(5L));
        }
    }

    @Test
    void testUpdateCartQuantitySuccess() throws SQLException {

        when(connection.prepareStatement(anyString()))
                .thenReturn(preparedStatement);

        when(preparedStatement.executeUpdate())
                .thenReturn(1);

        try (MockedStatic<DBConnection> mockedDB =
                     mockStatic(DBConnection.class)) {

            mockedDB.when(DBConnection::getConnection)
                    .thenReturn(connection);

            assertTrue(cartDAO.updateCartQuantity(5L, 4));

            verify(preparedStatement).setInt(1, 4);
            verify(preparedStatement).setLong(2, 5L);
        }
    }

    @Test
    void testGetCustomerCartSuccess() throws SQLException {

        when(connection.prepareStatement(anyString()))
                .thenReturn(preparedStatement);

        when(preparedStatement.executeQuery())
                .thenReturn(resultSet);

        when(resultSet.next())
                .thenReturn(true, false);

        when(resultSet.getLong("cart_id"))
                .thenReturn(5L);

        when(resultSet.getLong("customer_id"))
                .thenReturn(1L);

        when(resultSet.getLong("product_id"))
                .thenReturn(10L);

        when(resultSet.getInt("quantity"))
                .thenReturn(3);

        try (MockedStatic<DBConnection> mockedDB =
                     mockStatic(DBConnection.class)) {

            mockedDB.when(DBConnection::getConnection)
                    .thenReturn(connection);

            List<Cart> cartList =
                    cartDAO.getCustomerCart(1L);

            assertEquals(1, cartList.size());

            Cart cart = cartList.get(0);

            assertEquals(5L, cart.getCartId());
            assertEquals(1L, cart.getCustomerId());
            assertEquals(10L, cart.getProductId());
            assertEquals(3, cart.getQuantity());

            verify(preparedStatement).setLong(1, 1L);
        }
    }

    @Test
    void testGetCustomerCartEmpty() throws SQLException {

        when(connection.prepareStatement(anyString()))
                .thenReturn(preparedStatement);

        when(preparedStatement.executeQuery())
                .thenReturn(resultSet);

        when(resultSet.next())
                .thenReturn(false);

        try (MockedStatic<DBConnection> mockedDB =
                     mockStatic(DBConnection.class)) {

            mockedDB.when(DBConnection::getConnection)
                    .thenReturn(connection);

            List<Cart> cartList =
                    cartDAO.getCustomerCart(1L);

            assertNotNull(cartList);
            assertTrue(cartList.isEmpty());
        }
    }

    @Test
    void testCalculateCartTotalSuccess() throws SQLException {

        when(connection.prepareStatement(anyString()))
                .thenReturn(preparedStatement);

        when(preparedStatement.executeQuery())
                .thenReturn(resultSet);

        when(resultSet.next())
                .thenReturn(true);

        when(resultSet.getDouble("total"))
                .thenReturn(1500.0);

        try (MockedStatic<DBConnection> mockedDB =
                     mockStatic(DBConnection.class)) {

            mockedDB.when(DBConnection::getConnection)
                    .thenReturn(connection);

            double total =
                    cartDAO.calculateCartTotal(1L);

            assertEquals(1500.0, total);
        }
    }

    @Test
    void testCalculateCartTotalWhenNoItems() throws SQLException {

        when(connection.prepareStatement(anyString()))
                .thenReturn(preparedStatement);

        when(preparedStatement.executeQuery())
                .thenReturn(resultSet);

        when(resultSet.next())
                .thenReturn(true);

        // SQL SUM() returns NULL when there are no matching rows.
        // JDBC getDouble() converts SQL NULL to 0.0.
        when(resultSet.getDouble("total"))
                .thenReturn(0.0);

        try (MockedStatic<DBConnection> mockedDB =
                     mockStatic(DBConnection.class)) {

            mockedDB.when(DBConnection::getConnection)
                    .thenReturn(connection);

            assertEquals(
                    0.0,
                    cartDAO.calculateCartTotal(1L)
            );
        }
    }

    @Test
    void testClearCartSuccess() throws SQLException {

        when(connection.prepareStatement(anyString()))
                .thenReturn(preparedStatement);

        when(preparedStatement.executeUpdate())
                .thenReturn(2);

        try (MockedStatic<DBConnection> mockedDB =
                     mockStatic(DBConnection.class)) {

            mockedDB.when(DBConnection::getConnection)
                    .thenReturn(connection);

            assertTrue(cartDAO.clearCart(1L));

            verify(preparedStatement).setLong(1, 1L);
        }
    }

    @Test
    void testClearCartWithExistingConnection()
            throws SQLException {

        when(connection.prepareStatement(anyString()))
                .thenReturn(preparedStatement);

        when(preparedStatement.executeUpdate())
                .thenReturn(2);

        boolean result = cartDAO.clearCart(1L, connection);

        assertTrue(result);

        verify(preparedStatement).setLong(1, 1L);
        verify(preparedStatement).executeUpdate();
    }

    @Test
    void testClearCartWhenNoItemsDeleted()
            throws SQLException {

        when(connection.prepareStatement(anyString()))
                .thenReturn(preparedStatement);

        when(preparedStatement.executeUpdate())
                .thenReturn(0);

        try (MockedStatic<DBConnection> mockedDB =
                     mockStatic(DBConnection.class)) {

            mockedDB.when(DBConnection::getConnection)
                    .thenReturn(connection);

            assertFalse(cartDAO.clearCart(1L));
        }
    }

    @Test
    void testAddToCartHandlesSQLException()
            throws SQLException {

        Cart cart = new Cart();
        cart.setCustomerId(1L);
        cart.setProductId(10L);
        cart.setQuantity(2);

        when(connection.prepareStatement(anyString()))
                .thenThrow(new SQLException("Database error"));

        try (MockedStatic<DBConnection> mockedDB =
                     mockStatic(DBConnection.class)) {

            mockedDB.when(DBConnection::getConnection)
                    .thenReturn(connection);

            assertFalse(cartDAO.addToCart(cart));
        }
    }
}

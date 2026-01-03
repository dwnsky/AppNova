package com.example.madappnova;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.madappnova.Order;
import java.util.List;

@Dao
public interface OrderDao {

    @Insert
    long insert(Order order);

    @Update
    void update(Order order);

    @Delete
    void delete(Order order);

    @Query("SELECT * FROM orders WHERE id = :orderId")
    Order getOrderById(int orderId);

    @Query("SELECT * FROM orders WHERE sellerId = :sellerId AND status = 'Preparing' ORDER BY timestamp DESC")
    List<Order> getCurrentOrdersBySeller(int sellerId);

    @Query("SELECT * FROM orders WHERE sellerId = :sellerId AND status = 'Preparing' ORDER BY timestamp DESC")
    LiveData<List<Order>> getCurrentOrdersBySellerLive(int sellerId);

    @Query("SELECT * FROM orders WHERE sellerId = :sellerId AND status = 'Done' ORDER BY completedAt DESC")
    List<Order> getPastOrdersBySeller(int sellerId);

    @Query("SELECT * FROM orders WHERE sellerId = :sellerId AND status = 'Done' ORDER BY completedAt DESC")
    LiveData<List<Order>> getPastOrdersBySellerLive(int sellerId);

    @Query("SELECT * FROM orders WHERE customerId = :customerId ORDER BY timestamp DESC")
    List<Order> getOrdersByCustomer(int customerId);

    @Query("SELECT * FROM orders WHERE customerId = :customerId ORDER BY timestamp DESC")
    LiveData<List<Order>> getOrdersByCustomerLive(int customerId);

    @Query("UPDATE orders SET status = :status, completedAt = :completedAt WHERE id = :orderId")
    void updateOrderStatus(int orderId, String status, long completedAt);

    @Query("UPDATE orders SET rating = :rating, review = :review WHERE id = :orderId")
    void updateOrderRating(int orderId, int rating, String review);

    @Query("SELECT COUNT(*) FROM orders WHERE sellerId = :sellerId AND status = 'Preparing'")
    int getCurrentOrdersCount(int sellerId);

    @Query("SELECT AVG(rating) FROM orders WHERE sellerId = :sellerId AND rating > 0")
    double getAverageRating(int sellerId);

    @Query("SELECT * FROM orders WHERE sellerId = :sellerId ORDER BY timestamp DESC")
    List<Order> getAllOrdersBySeller(int sellerId);
}
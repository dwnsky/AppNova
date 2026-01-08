package com.example.madappnova;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.madappnova.AppDatabase;
import com.example.madappnova.OrderDao;
import com.example.madappnova.Order;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class OrderRepository {
    private OrderDao orderDao;

    public OrderRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        orderDao = db.orderDao();
    }

    public long addOrder(Order order) {
        Future<Long> future = AppDatabase.databaseWriteExecutor.submit(() ->
                orderDao.insert(order)
        );
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void updateOrder(Order order) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            orderDao.update(order);
        });
    }

    public List<Order> getCurrentOrdersBySeller(int sellerId) {
        Future<List<Order>> future = AppDatabase.databaseWriteExecutor.submit(() ->
                orderDao.getCurrentOrdersBySeller(sellerId)
        );
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public LiveData<List<Order>> getCurrentOrdersBySellerLive(int sellerId) {
        return orderDao.getCurrentOrdersBySellerLive(sellerId);
    }

    public List<Order> getPastOrdersBySeller(int sellerId) {
        Future<List<Order>> future = AppDatabase.databaseWriteExecutor.submit(() ->
                orderDao.getPastOrdersBySeller(sellerId)
        );
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public LiveData<List<Order>> getPastOrdersBySellerLive(int sellerId) {
        return orderDao.getPastOrdersBySellerLive(sellerId);
    }

    public void updateOrderStatus(int orderId, String status) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            long completedAt = status.equals("Done") ? System.currentTimeMillis() : 0;
            orderDao.updateOrderStatus(orderId, status, completedAt);
        });
    }

    public void updateOrderRating(int orderId, int rating, String review) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            orderDao.updateOrderRating(orderId, rating, review);
        });
    }

    public int getCurrentOrdersCount(int sellerId) {
        Future<Integer> future = AppDatabase.databaseWriteExecutor.submit(() ->
                orderDao.getCurrentOrdersCount(sellerId)
        );
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public double getAverageRating(int sellerId) {
        Future<Double> future = AppDatabase.databaseWriteExecutor.submit(() ->
                orderDao.getAverageRating(sellerId)
        );
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}

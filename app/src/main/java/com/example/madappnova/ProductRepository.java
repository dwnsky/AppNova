package com.example.madappnova;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.madappnova.AppDatabase;
import com.example.madappnova.ProductDao;
import com.example.madappnova.Product;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ProductRepository {
    private ProductDao productDao;

    public ProductRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        productDao = db.productDao();
    }

    public long addProduct(Product product) {
        Future<Long> future = AppDatabase.databaseWriteExecutor.submit(() ->
                productDao.insert(product)
        );
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void updateProduct(Product product) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            productDao.update(product);
        });
    }

    public void deleteProduct(Product product) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            productDao.delete(product);
        });
    }

    public Product getProductById(int productId) {
        Future<Product> future = AppDatabase.databaseWriteExecutor.submit(() ->
                productDao.getProductById(productId)
        );
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> getProductsBySeller(int sellerId) {
        Future<List<Product>> future = AppDatabase.databaseWriteExecutor.submit(() ->
                productDao.getProductsBySeller(sellerId)
        );
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public LiveData<List<Product>> getProductsBySellerLive(int sellerId) {
        return productDao.getProductsBySellerLive(sellerId);
    }

    public List<Product> getAllActiveProducts() {
        Future<List<Product>> future = AppDatabase.databaseWriteExecutor.submit(() ->
                productDao.getAllActiveProducts()
        );
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateProductStatus(int productId, boolean isActive) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            productDao.updateProductStatus(productId, isActive);
        });
    }

    public void updateQuantity(int productId, int quantity) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            productDao.updateQuantity(productId, quantity);
        });
    }
}


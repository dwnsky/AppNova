package com.example.madappnova;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.madappnova.Product;
import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    long insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);

    @Query("SELECT * FROM products WHERE id = :productId")
    Product getProductById(int productId);

    @Query("SELECT * FROM products WHERE sellerId = :sellerId AND isActive = 1 ORDER BY uploadedDate DESC")
    List<Product> getProductsBySeller(int sellerId);

    @Query("SELECT * FROM products WHERE sellerId = :sellerId AND isActive = 1 ORDER BY uploadedDate DESC")
    LiveData<List<Product>> getProductsBySellerLive(int sellerId);

    @Query("SELECT * FROM products WHERE isActive = 1 ORDER BY uploadedDate DESC")
    List<Product> getAllActiveProducts();

    @Query("SELECT * FROM products WHERE isActive = 1 ORDER BY uploadedDate DESC")
    LiveData<List<Product>> getAllActiveProductsLive();

    @Query("UPDATE products SET isActive = :isActive WHERE id = :productId")
    void updateProductStatus(int productId, boolean isActive);

    @Query("UPDATE products SET quantityAvailable = :quantity WHERE id = :productId")
    void updateQuantity(int productId, int quantity);

    @Query("SELECT * FROM products WHERE bestBeforeDate < :currentTime AND isActive = 1")
    List<Product> getExpiredProducts(long currentTime);
}


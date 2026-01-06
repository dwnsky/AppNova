package com.example.madappnova;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

@Entity(tableName = "products",
        foreignKeys = @ForeignKey(entity = User.class,
                parentColumns = "id",
                childColumns = "sellerId",
                onDelete = ForeignKey.CASCADE))
public class Product {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int sellerId;
    private String name;
    private String description;
    private double originalPrice;
    private double discountedPrice;
    private int discountPercentage;
    private String imageUrl;
    private String uploadedDate;
    private String bestBeforeDate;
    private boolean isActive;
    private int quantityAvailable;

    public Product() {
        this.isActive = true;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getSellerId() { return sellerId; }
    public void setSellerId(int sellerId) { this.sellerId = sellerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getOriginalPrice() { return originalPrice; }
    public void setOriginalPrice(double originalPrice) { this.originalPrice = originalPrice; }

    public double getDiscountedPrice() { return discountedPrice; }
    public void setDiscountedPrice(double discountedPrice) { this.discountedPrice = discountedPrice; }

    public int getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(int discountPercentage) { this.discountPercentage = discountPercentage; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getUploadedDate() { return uploadedDate; }
    public void setUploadedDate(String uploadedDate) { this.uploadedDate = uploadedDate; }

    public String getBestBeforeDate() { return bestBeforeDate; }
    public void setBestBeforeDate(String bestBeforeDate) { this.bestBeforeDate = bestBeforeDate; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public int getQuantityAvailable() { return quantityAvailable; }
    public void setQuantityAvailable(int quantityAvailable) { this.quantityAvailable = quantityAvailable; }
}


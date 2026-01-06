package com.example.madappnova;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "chat_messages",
        foreignKeys = {
                @ForeignKey(entity = User.class,
                        parentColumns = "id",
                        childColumns = "senderId",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = User.class,
                        parentColumns = "id",
                        childColumns = "receiverId",
                        onDelete = ForeignKey.CASCADE)
        },
        indices = {@Index(value = {"senderId", "receiverId"})})
public class Chat {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int senderId;
    private int receiverId;
    private String senderName;
    private String lastMessage;
    private long timestamp;
    private int unreadCount;
    private boolean isRead;
    private String userType; // "Seller" or "Customer"

    public Chat() {
        this.timestamp = System.currentTimeMillis();
        this.unreadCount = 0;
        this.isRead = false;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getSenderId() { return senderId; }
    public void setSenderId(int senderId) { this.senderId = senderId; }

    public int getReceiverId() { return receiverId; }
    public void setReceiverId(int receiverId) { this.receiverId = receiverId; }

    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }

    public String getLastMessage() { return lastMessage; }
    public void setLastMessage(String lastMessage) { this.lastMessage = lastMessage; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    public int getUnreadCount() { return unreadCount; }
    public void setUnreadCount(int unreadCount) { this.unreadCount = unreadCount; }

    public boolean isRead() { return isRead; }
    public void setRead(boolean read) { isRead = read; }

    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }
}
package com.example.madappnova;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface ChatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Chat chatMessage);

    @Update
    void update(Chat chatMessage);

    @Delete
    void delete(Chat chatMessage);

    // Get all unique conversations for a user (seller or customer)
    @Query("SELECT * FROM chat_messages WHERE receiverId = :userId " +
            "GROUP BY senderId ORDER BY timestamp DESC")
    LiveData<List<Chat>> getChatMessagesByUserLive(int userId);

    // Get conversation between two users
    @Query("SELECT * FROM chat_messages WHERE " +
            "(senderId = :user1Id AND receiverId = :user2Id) OR " +
            "(senderId = :user2Id AND receiverId = :user1Id) " +
            "ORDER BY timestamp ASC")
    LiveData<List<Chat>> getConversationLive(int user1Id, int user2Id);

    // Update unread count
    @Query("UPDATE chat_messages SET unreadCount = 0, isRead = 1 " +
            "WHERE senderId = :senderId AND receiverId = :receiverId")
    void markMessagesAsRead(int senderId, int receiverId);

    // Get total unread count
    @Query("SELECT SUM(unreadCount) FROM chat_messages WHERE receiverId = :userId")
    LiveData<Integer> getTotalUnreadCountLive(int userId);

    // Get last message between two users
    @Query("SELECT * FROM chat_messages WHERE " +
            "(senderId = :user1Id AND receiverId = :user2Id) OR " +
            "(senderId = :user2Id AND receiverId = :user1Id) " +
            "ORDER BY timestamp DESC LIMIT 1")
    Chat getLastMessage(int user1Id, int user2Id);
}
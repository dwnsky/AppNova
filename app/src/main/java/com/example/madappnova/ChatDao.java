package com.example.madappnova;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.example.madappnova.Chat;
import java.util.List;

@Dao
public interface ChatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Chat chatMessage);

    @Update
    void update(Chat chatMessage);

    @Delete
    void delete(Chat chatMessage);

    @Query("SELECT * FROM chat_messages WHERE (senderId = :userId OR receiverId = :userId) AND userType = :userType ORDER BY timestamp DESC")
    List<Chat> getChatMessagesByUser(int userId, String userType);

    @Query("SELECT * FROM chat_messages WHERE (senderId = :userId OR receiverId = :userId) AND userType = :userType ORDER BY timestamp DESC")
    LiveData<List<Chat>> getChatMessagesByUserLive(int userId, String userType);

    @Query("SELECT * FROM chat_messages WHERE (senderId = :user1Id AND receiverId = :user2Id) OR (senderId = :user2Id AND receiverId = :user1Id) ORDER BY timestamp DESC")
    List<Chat> getConversation(int user1Id, int user2Id);

    @Query("UPDATE chat_messages SET unreadCount = :count WHERE senderId = :senderId AND receiverId = :receiverId")
    void updateUnreadCount(int senderId, int receiverId, int count);

    @Query("SELECT SUM(unreadCount) FROM chat_messages WHERE receiverId = :userId")
    int getTotalUnreadCount(int userId);

    @Query("SELECT SUM(unreadCount) FROM chat_messages WHERE receiverId = :userId")
    LiveData<Integer> getTotalUnreadCountLive(int userId);
}

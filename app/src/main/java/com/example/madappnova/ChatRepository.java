package com.example.madappnova;

import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ChatRepository {
    private ChatDao chatDao;

    public ChatRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        chatDao = db.chatMessageDao();
    }

    public long insertChat(Chat chat) {
        Future<Long> future = AppDatabase.databaseWriteExecutor.submit(() ->
                chatDao.insert(chat)
        );
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void updateChat(Chat chat) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            chatDao.update(chat);
        });
    }

    public void deleteChat(Chat chat) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            chatDao.delete(chat);
        });
    }

    public LiveData<List<Chat>> getChatMessagesByUserLive(int userId) {
        return chatDao.getChatMessagesByUserLive(userId);
    }

    public LiveData<List<Chat>> getConversationLive(int user1Id, int user2Id) {
        return chatDao.getConversationLive(user1Id, user2Id);
    }

    public void markMessagesAsRead(int senderId, int receiverId) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            chatDao.markMessagesAsRead(senderId, receiverId);
        });
    }

    public LiveData<Integer> getTotalUnreadCountLive(int userId) {
        return chatDao.getTotalUnreadCountLive(userId);
    }

    public Chat getLastMessage(int user1Id, int user2Id) {
        Future<Chat> future = AppDatabase.databaseWriteExecutor.submit(() ->
                chatDao.getLastMessage(user1Id, user2Id)
        );
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

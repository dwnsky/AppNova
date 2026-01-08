package com.example.madappnova;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.madappnova.AppDatabase;
import com.example.madappnova.UserDao;
import com.example.madappnova.User;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class UserRepository {
    private UserDao userDao;

    public UserRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        userDao = db.userDao();
    }

    // Authentication
    public User login(String email, String password) {
        Future<User> future = AppDatabase.databaseWriteExecutor.submit(() ->
                userDao.login(email, password)
        );
        try {
            User user = future.get();
            if (user != null) {
                updateLastLogin(user.getId());
            }
            return user;
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean register(User user) {
        Future<Boolean> future = AppDatabase.databaseWriteExecutor.submit(() -> {
            // Check if email already exists
            int count = userDao.checkEmailExists(user.getEmail());
            if (count > 0) {
                return false; // Email already exists
            }
            userDao.insert(user);
            return true;
        });
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User getUserById(int userId) {
        Future<User> future = AppDatabase.databaseWriteExecutor.submit(() ->
                userDao.getUserById(userId)
        );
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getUserByEmail(String email) {
        Future<User> future = AppDatabase.databaseWriteExecutor.submit(() ->
                userDao.getUserByEmail(email)
        );
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateUser(User user) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            userDao.update(user);
        });
    }

    public void updateLastLogin(int userId) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            userDao.updateLastLogin(userId, System.currentTimeMillis());
        });
    }

    public List<User> getUsersByType(String userType) {
        Future<List<User>> future = AppDatabase.databaseWriteExecutor.submit(() ->
                userDao.getUsersByType(userType)
        );
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
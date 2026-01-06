package com.example.madappnova;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String PREF_NAME = "MyShopSession";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_USER_NAME = "userName";
    private static final String KEY_USER_EMAIL = "userEmail";
    private static final String KEY_USER_TYPE = "userType";

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    /**
     * Create login session
     */
    public void createLoginSession(int userId, String userName, String userEmail, String userType) {
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.putInt(KEY_USER_ID, userId);
        editor.putString(KEY_USER_NAME, userName);
        editor.putString(KEY_USER_EMAIL, userEmail);
        editor.putString(KEY_USER_TYPE, userType);
        editor.commit();
    }

    /**
     * Check if user is logged in
     */
    public boolean isLoggedIn() {
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    /**
     * Get logged in user ID
     */
    public int getUserId() {
        return prefs.getInt(KEY_USER_ID, -1);
    }

    /**
     * Get logged in user name
     */
    public String getUserName() {
        return prefs.getString(KEY_USER_NAME, null);
    }

    /**
     * Get logged in user email
     */
    public String getUserEmail() {
        return prefs.getString(KEY_USER_EMAIL, null);
    }

    /**
     * Get logged in user type
     */
    public String getUserType() {
        return prefs.getString(KEY_USER_TYPE, null);
    }

    /**
     * Check if user is seller
     */
    public boolean isSeller() {
        return "Seller".equals(getUserType());
    }

    /**
     * Check if user is customer
     */
    public boolean isCustomer() {
        return "Customer".equals(getUserType());
    }

    /**
     * Check if user is volunteer
     */
    public boolean isVolunteer() {
        return "Volunteer".equals(getUserType());
    }

    /**
     * Clear session (logout)
     */
    public void logout() {
        editor.clear();
        editor.commit();
    }

    /**
     * Update user name
     */
    public void updateUserName(String userName) {
        editor.putString(KEY_USER_NAME, userName);
        editor.commit();
    }
}

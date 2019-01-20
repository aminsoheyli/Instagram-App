package com.example.mohammad.instagram.dbobj;

/**
 * Created by Mohammad Amin Soheyli on 20/01/2019.
 */
public class User {
    private String userId;
    private String userFollower;

    public User(String userId, String userFollower) {
        this.userId = userId;
        this.userFollower = userFollower;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFollower() {
        return userFollower;
    }

    public void setUserFollower(String userFollower) {
        this.userFollower = userFollower;
    }
}
package com.oyl.cics.model.user;

public interface UserDao {
    User queryByUsername(String username);
}

package com.oyl.cics.impl.user;

import com.oyl.cics.model.user.User;

public interface UserMapper {
    User queryByUsername(String username);
}

package com.oyl.cics.impl.user;

import com.oyl.cics.model.user.User;
import com.oyl.cics.model.user.request.SearchCondition;

import java.util.List;

public interface UserMapper {
    User queryByUsername(String username);

    void create(User user);

    int numOf(SearchCondition condition);

    List<User> search(SearchCondition condition);
}

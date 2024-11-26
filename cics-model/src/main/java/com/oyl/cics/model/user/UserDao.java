package com.oyl.cics.model.user;

import com.oyl.cics.model.user.request.CreateRequest;
import com.oyl.cics.model.user.request.SearchCondition;

import java.util.List;

public interface UserDao {
    User queryByUsername(String username);

    User create(CreateRequest request);

    int numOf(SearchCondition condition);

    List<User> search(SearchCondition condition);
}

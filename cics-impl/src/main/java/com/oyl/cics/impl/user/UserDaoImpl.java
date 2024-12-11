package com.oyl.cics.impl.user;

import com.oyl.cics.model.user.User;
import com.oyl.cics.model.user.UserDao;
import com.oyl.cics.model.user.request.CreateRequest;
import com.oyl.cics.model.user.request.SearchCondition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper userMapper;

    @Override
    public User queryByUsername(String username) {
        return userMapper.queryByUsername(username);
    }

    @Override
    public User create(CreateRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        userMapper.create(user);
        return user;
    }

    @Override
    public int numOf(SearchCondition condition) {
        return userMapper.numOf(condition);
    }

    @Override
    public List<User> search(SearchCondition condition) {
        return userMapper.search(condition);
    }

    @Override
    public void remove(long userId) {
        userMapper.remove(userId);
    }

}

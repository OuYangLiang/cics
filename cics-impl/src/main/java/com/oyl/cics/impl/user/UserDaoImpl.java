package com.oyl.cics.impl.user;

import com.oyl.cics.model.user.User;
import com.oyl.cics.model.user.UserDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper userMapper;

    @Override
    public User queryByUsername(String username) {
        return userMapper.queryByUsername(username);
    }

}

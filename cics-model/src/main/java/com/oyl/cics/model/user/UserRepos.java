package com.oyl.cics.model.user;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserRepos {

    @Resource
    private UserDao userDao;

    public User queryByUsername(String username) {
        return userDao.queryByUsername(username);
    }
}

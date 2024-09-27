package com.oyl.cics.impl.user;

import com.oyl.cics.model.user.User;
import com.oyl.cics.model.user.UserRepos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserReposTest {
    @Resource
    private UserRepos userRepos;

    @Test
    public void test() {
        User user = userRepos.queryByUsername("abc");
        assertNull(user);

        user = userRepos.queryByUsername("OYL");
        assertNull(user);

        user = userRepos.queryByUsername("oyl");
        assertNotNull(user);
        assertNotNull(user.getId());
        assertEquals("oyl", user.getUsername());
        assertEquals("pwd123", user.getPassword());

        user = userRepos.queryByUsername("yumin");
        assertNotNull(user);
        assertNotNull(user.getId());
        assertEquals("yumin", user.getUsername());
        assertEquals("haha123", user.getPassword());
    }
}

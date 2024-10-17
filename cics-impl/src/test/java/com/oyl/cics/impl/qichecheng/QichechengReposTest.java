package com.oyl.cics.impl.qichecheng;

import com.oyl.cics.model.qichecheng.request.SearchCondition;
import com.oyl.cics.model.qichecheng.response.SearchResult;
import com.oyl.cics.model.qichecheng.QichechengRepos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QichechengReposTest {

    @Resource
    private QichechengRepos qichechengRepos;

    @Test
    public void test() {
        SearchCondition condition = new SearchCondition();

        SearchResult result = qichechengRepos.search(condition);

        assertEquals(1, result.getPage());
        assertEquals(10, result.getPageSize());
        assertTrue(result.getRecords().isEmpty());
    }
}
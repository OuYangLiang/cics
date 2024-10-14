package com.oyl.cics.impl.guidaoheng;

import com.oyl.cics.impl.common.cfg.PropertiesConfig;
import com.oyl.cics.model.guidaoheng.GuidaohengRepos;
import com.oyl.cics.model.guidaoheng.request.SearchCondition;
import com.oyl.cics.model.guidaoheng.response.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GuidaohengReposTest {

    @Resource
    private GuidaohengRepos guidaohengRepos;

    @Resource
    private PropertiesConfig propertiesConfig;

    @Test
    public void test() {
        SearchCondition condition = new SearchCondition();

        SearchResult result = guidaohengRepos.search(condition);

        assertEquals(1, result.getPage());
        assertEquals(10, result.getPageSize());
        assertTrue(result.getRecords().isEmpty());

        assertEquals("P24092600001", propertiesConfig.getAppId());
        assertEquals("67f64378ab857718", propertiesConfig.getAppSecret());
        assertEquals("27f44dd996091d1c", propertiesConfig.getDataSecret());
    }
}
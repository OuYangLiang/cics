package com.oyl.cics.impl.employee;

import com.oyl.cics.model.employee.EmployeeRepos;
import com.oyl.cics.model.employee.request.SearchCondition;
import com.oyl.cics.model.employee.response.SearchResult;
import com.oyl.cics.model.setting.SettingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeReposTest {
    @Resource
    private EmployeeRepos employeeRepos;

    @Resource
    private SettingService settingService;

    @Test
    public void testSetting() {
        assertTrue(settingService.autoUpload());
    }

    @Test
    public void test() {
        SearchCondition condition = new SearchCondition();
        condition.setPageSize(3);
        condition.setPage(3);
        condition.setDepartment("研发中心");

        SearchResult result = employeeRepos.search(condition);
        assertNotNull(result);
        assertEquals(3, result.getPageSize());
        assertEquals(3, result.getPage());
        assertNotNull(result.getRecords());
        assertEquals(10, result.getNumOfRecords());
        assertEquals(3, result.getRecords().size());
        assertEquals("18652930168", result.getRecords().get(2).getPhone());
        assertEquals("喻敏8", result.getRecords().get(2).getEmployeeName());
        assertEquals(1900000, result.getRecords().get(2).getSalary().longValue());

        condition = new SearchCondition();
        condition.setPageSize(4);
        condition.setPage(3);
        condition.setEmployeeNamePrefix("喻");

        result = employeeRepos.search(condition);
        assertNotNull(result);
        assertEquals(4, result.getPageSize());
        assertEquals(3, result.getPage());
        assertNotNull(result.getRecords());
        assertEquals(10, result.getNumOfRecords());
        assertEquals(2, result.getRecords().size());
        assertEquals("18652930168", result.getRecords().get(0).getPhone());
        assertEquals("喻敏8", result.getRecords().get(0).getEmployeeName());
        assertEquals(1900000, result.getRecords().get(0).getSalary().longValue());
    }

    @Test
    public void test2() {
        SearchCondition condition = new SearchCondition();
        condition.setPageSize(0);
        condition.setPage(3);
        condition.setDepartment("研发中心");

        boolean flag = false;
        try {
            SearchResult result = employeeRepos.search(null);
        } catch (IllegalArgumentException e) {
            assertEquals("查询对象不能为空", e.getMessage());
            flag = true;
        }
        assertTrue(flag);

        flag = false;
        try {
            SearchResult result = employeeRepos.search(condition);
        } catch (IllegalArgumentException e) {
            assertEquals("分页大小最小为1", e.getMessage());
            flag = true;
        }
        assertTrue(flag);
    }
}

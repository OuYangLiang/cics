package com.oyl.cics.model.user;
import com.oyl.cics.model.common.utils.MD5Encryptor;
import com.oyl.cics.model.common.validation.ValidParam;
import com.oyl.cics.model.user.request.RemoveRequest;
import com.oyl.cics.model.user.request.SearchCondition;
import com.oyl.cics.model.user.response.SearchResult;
import com.oyl.cics.model.user.request.CreateRequest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;

@Component
public class UserRepos {

    @Resource
    private UserDao userDao;

    @ValidParam
    public SearchResult search(@Valid @NotNull(message = "查询对象不能为空") SearchCondition searchCondition) {
        int numOfRecords = userDao.numOf(searchCondition);

        SearchResult result = new SearchResult();
        result.setPage(searchCondition.getPage());
        result.setPageSize(searchCondition.getPageSize());
        result.setNumOfRecords(numOfRecords);

        if (( (searchCondition.getPage() - 1) * searchCondition.getPageSize()) >= numOfRecords) {
            result.setRecords(Collections.emptyList());
        } else {
            result.setRecords(userDao.search(searchCondition));
        }

        return result;
    }

    public User queryByUsername(String username) {
        return userDao.queryByUsername(username);
    }

    @ValidParam
    public User create(@Valid CreateRequest request) {

        if (null != userDao.queryByUsername(request.getUsername())) {
            throw new IllegalArgumentException("用户名已存在");
        }

        request.setPassword(MD5Encryptor.inst.getMD5(request.getPassword().trim()));
        return userDao.create(request);
    }

    @ValidParam
    public void remove(@Valid RemoveRequest request) {
        userDao.remove(request.getUserId());
    }
}

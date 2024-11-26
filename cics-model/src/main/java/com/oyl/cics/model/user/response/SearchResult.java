package com.oyl.cics.model.user.response;

import com.oyl.cics.model.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchResult {
    private int numOfRecords;
    private int page;
    private int pageSize;
    private List<User> records;
}

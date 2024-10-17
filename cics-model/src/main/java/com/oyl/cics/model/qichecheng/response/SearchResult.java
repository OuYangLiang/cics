package com.oyl.cics.model.qichecheng.response;

import com.oyl.cics.model.qichecheng.Qichecheng;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchResult {
    private int numOfRecords;
    private int page;
    private int pageSize;
    private List<Qichecheng> records;
}

package com.oyl.cics.model.meizhi.response;

import com.oyl.cics.model.meizhi.Meizhi;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchResult {
    private int numOfRecords;
    private int page;
    private int pageSize;
    private List<Meizhi> records;
}

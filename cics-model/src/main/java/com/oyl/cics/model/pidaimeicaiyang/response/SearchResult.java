package com.oyl.cics.model.pidaimeicaiyang.response;

import com.oyl.cics.model.pidaimeicaiyang.Pidaimeicaiyang;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchResult {
    private int numOfRecords;
    private int page;
    private int pageSize;
    private List<Pidaimeicaiyang> records;
}

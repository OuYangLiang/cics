package com.oyl.cics.model.huayandan.request;

import com.oyl.cics.model.shared.UploadStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class SearchCondition {
    @Min(value = 1, message = "请求页最小1")
    private int page = 1;

    @Min(value = 1, message = "分页大小最小为1")
    private int pageSize = 10;

    private String mybs;

    private UploadStatus uploadStatus;

    private String[] ywrqRange;

    private String group;

    public String getYwrqRangeStart() {
        return null == ywrqRange || ywrqRange.length == 0 ? null : ywrqRange[0] + " 00:00:00";
    }

    public String getYwrqRangeEnd() {
        return null == ywrqRange || ywrqRange.length == 0 ? null : ywrqRange[1] + " 23:59:59";
    }

    public int getOffset() {
        return (page - 1) * pageSize;
    }
}

package com.oyl.cics.web.qichecheng.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UploadRequest {
    @NotNull(message = "上报ID不能为空")
    private Long[] ids;

    @NotBlank(message = "操作人不能为空")
    private String operator;
}

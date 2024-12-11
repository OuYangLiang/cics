package com.oyl.cics.web.setting.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ConfigRequest {
    @NotNull(message = "autoUpload不能为空")
    private Boolean autoUpload;
}

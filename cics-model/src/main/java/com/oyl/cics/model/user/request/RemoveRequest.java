package com.oyl.cics.model.user.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RemoveRequest {
    @NotNull(message = "用户ID不能为空")
    private Long userId;
}

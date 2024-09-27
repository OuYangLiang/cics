package com.oyl.cics.web.common.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestResult<T> {
    private boolean success;
    private T data;
    private String errorCode;
    private String errorMsg;

    public static <T> RestResult<T> ok(T t) {
        RestResult<T> result = new RestResult<>();
        result.setSuccess(true);
        result.setData(t);

        return result;
    }

    public static <T> RestResult<T> fail(String errorCode, String errorMsg) {
        RestResult<T> result = new RestResult<>();
        result.setSuccess(false);
        result.setErrorCode(errorCode);
        result.setErrorMsg(errorMsg);

        return result;
    }
}

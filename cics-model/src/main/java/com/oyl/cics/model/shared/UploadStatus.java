package com.oyl.cics.model.shared;

import lombok.Getter;

@Getter
public enum UploadStatus {

    pending(0, "未上报"),
    success(1, "上报成功"),
    failed(2, "上报失败");

    private final int code;
    private final String desc;

    UploadStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static UploadStatus init(int code) {
        for (UploadStatus item : UploadStatus.values()) {
            if (item.getCode() == code) {
                return item;
            }
        }

        throw new IllegalArgumentException();
    }
}

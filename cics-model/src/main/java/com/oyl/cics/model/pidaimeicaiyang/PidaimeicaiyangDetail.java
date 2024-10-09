package com.oyl.cics.model.pidaimeicaiyang;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PidaimeicaiyangDetail {
    /**
     * 初级子样量
     */
    private Double dtCjzyl;
    /**
     * 采样单元编码
     */
    private String dtCydybm;
    /**
     * 采样单元煤量
     */
    private Double dtCydyml;
    /**
     * 预留字段1
     */
    private String dtCydyreserve1;
    /**
     * 预留字段2
     */
    private String dtCydyreserve2;
    /**
     * 预留字段3
     */
    private String dtCydyreserve3;
    /**
     * 预留字段4
     */
    private String dtCydyreserve4;
    /**
     * 预留字段5
     */
    private String dtCydyreserve5;
    /**
     * 采样单元序号
     */
    private Long dtCydyxh;
    /**
     * 采样结束日期
     */
    private String dtCyedate;
    /**
     * 采样结束时间
     */
    private String dtCyetime;
    /**
     * 采样方式
     */
    private String dtCyfs;
    /**
     * 采样间隔时间
     */
    private Long dtCyjgsj;
    /**
     * 采样设备编号
     */
    private String dtCysbbm;
    /**
     * 采样设备ID
     */
    private String dtCysbid;
    /**
     * 采样设备名称
     */
    private String dtCysbmc;
    /**
     * 采样开始日期
     */
    private String dtCysdate;
    /**
     * 采样开始时间
     */
    private String dtCystime;
    /**
     * 采样总量
     */
    private Double dtCyzl;
    /**
     * 二级缩分次数
     */
    private Long dtErjisfcs;
    /**
     * 二级缩分延迟时间
     */
    private Long dtErjisfcysj;
    /**
     * 二级缩分间隔
     */
    private Long dtErjisfjg;
    /**
     * 二级缩分时间
     */
    private Long dtErjisfsj;
    /**
     * 留样桶数
     */
    private Long dtLytongshu;
    /**
     * 一级缩分次数
     */
    private Long dtYijisfcs;
    /**
     * 一级缩分延迟时间
     */
    private Long dtYijisfcysj;
    /**
     * 一级缩分间隔
     */
    private Long dtYijisfjg;
    /**
     * 一级缩分时间
     */
    private Long dtYijisfsj;
    /**
     * 留样总量
     */
    private Double dtYlzl;
    /**
     * 主表ID
     */
    private Long mybs;
}

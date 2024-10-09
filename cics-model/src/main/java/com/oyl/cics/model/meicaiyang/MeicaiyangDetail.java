package com.oyl.cics.model.meicaiyang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeicaiyangDetail {
    /**
     * 采样单元详情-初级子样量
     */
    private Double dtCjzyl;
    /**
     * 采样单元详情-采样单元编码
     */
    private String dtCydybm;
    /**
     * 采样单元详情-车数
     */
    private Long dtCydycs;
    /**
     * 采样单元详情-采样点数（子样数）
     */
    private Long dtCydyds;
    /**
     * 采样单元详情-采样单元煤量
     */
    private Double dtCydyml;
    /**
     * 采样单元详情-预留字段1
     */
    private String dtCydyreserve1;
    /**
     * 采样单元详情-预留字段2
     */
    private String dtCydyreserve2;
    /**
     * 采样单元详情-预留字段3
     */
    private String dtCydyreserve3;
    /**
     * 采样单元详情-预留字段4
     */
    private String dtCydyreserve4;
    /**
     * 采样单元详情-预留字段5
     */
    private String dtCydyreserve5;
    /**
     * 采样单元详情-采样单元序号
     */
    private String dtCydyxh;
    /**
     * 采样单元详情-采样结束日期
     */
    private String dtCyedate;
    /**
     * 采样单元详情-采样结束时间
     */
    private String dtCyetime;
    /**
     * 采样单元详情-采样方式
     */
    private String dtCyfs;
    /**
     * 采样单元详情-采样区域
     */
    private String dtCyquyu;
    /**
     * 采样单元详情-采样设备ID
     */
    private String dtCysbid;
    /**
     * 采样单元详情-采样设备名称
     */
    private String dtCysbmc;
    /**
     * 采样单元详情-采样深度
     */
    private String dtCysd;
    /**
     * 采样单元详情-采样开始日期
     */
    private String dtCysdate;
    /**
     * 采样单元详情-采样开始时间
     */
    private String dtCystime;
    /**
     * 采样单元详情-采样总量
     */
    private Double dtCyzl;
    /**
     * 采样单元详情-二级缩分次数
     */
    private Long dtErjisfcs;
    /**
     * 采样单元详情-二级缩分延迟时间
     */
    private Long dtErjisfcysj;
    /**
     * 采样单元详情-二级缩分间隔
     */
    private Long dtErjisfjg;
    /**
     * 采样单元详情-二级缩分时间
     */
    private Long dtErjisfsj;
    /**
     * 采样单元详情-留样桶数
     */
    private Long dtLytonshu;
    /**
     * 采样单元详情-留样总量
     */
    private Double dtLyzl;
    /**
     * 采样单元详情-人工采样总量
     */
    private Double dtRengongcyzl;
    /**
     * 采样单元详情-一级缩分次数
     */
    private Long dtYijisfcs;
    /**
     * 采样单元详情-一级缩分延迟时间
     */
    private Long dtYijisfcysj;
    /**
     * 采样单元详情-一级缩分间隔
     */
    private Long dtYijisfjg;
    /**
     * 采样单元详情-一级缩分时间
     */
    private Long dtYijisfsj;
    /**
     * 批次煤样标识
     */
    private String mybs;

}

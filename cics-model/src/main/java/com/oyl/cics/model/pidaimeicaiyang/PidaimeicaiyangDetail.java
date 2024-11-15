package com.oyl.cics.model.pidaimeicaiyang;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PidaimeicaiyangDetail {

    private Long id;

    /**
     * 采样单元详情-采样设备编号
     */
    private String dtCysbbm;
    /**
     * 采样单元详情-初级子样量
     */
    private Double dtCjzyl;
    /**
     * 采样单元详情-采样单元编码
     */
    private String dtCydybm;
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
    private Long dtCydyxh;
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
     * 采样单元详情-采样间隔时间
     */
    private Long dtCyjgsj;
    /**
     * 采样单元详情-采样设备ID
     */
    private String dtCysbid;
    /**
     * 采样单元详情-采样设备名称
     */
    private String dtCysbmc;
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
    private Long dtLytongshu;
    /**
     * 采样单元详情-留样总量
     */
    private Double dtLyzl;
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

    public void setDefaultValues() {
        String valString = "9999";
        String valDate = "99999999";
        String valTime = "000000";
        long valLong = -1L;
        double valDouble = -1;

        if (null == mybs || this.mybs.trim().isEmpty()) {
            this.mybs = valString;
        }

        if (null == dtCydyxh) {
            this.dtCydyxh = valLong;
        }

        if (null == dtCydybm || this.dtCydybm.trim().isEmpty()) {
            this.dtCydybm = valString;
        }

        if (null == dtCysdate || this.dtCysdate.trim().isEmpty()) {
            this.dtCysdate = valDate;
        }

        if (null == dtCystime || this.dtCystime.trim().isEmpty()) {
            this.dtCystime = valTime;
        }

        if (null == dtCyedate || this.dtCyedate.trim().isEmpty()) {
            this.dtCyedate = valDate;
        }

        if (null == dtCyetime || this.dtCyetime.trim().isEmpty()) {
            this.dtCyetime = valTime;
        }

        if (null == dtCysbmc || this.dtCysbmc.trim().isEmpty()) {
            this.dtCysbmc = valString;
        }

        if (null == dtCysbid || this.dtCysbid.trim().isEmpty()) {
            this.dtCysbid = valString;
        }

        if (null == dtCydyml) {
            this.dtCydyml = valDouble;
        }

        if (null == dtCyjgsj) {
            this.dtCyjgsj = valLong;
        }

        if (null == dtCjzyl) {
            this.dtCjzyl = valDouble;
        }

        if (null == dtYijisfsj) {
            this.dtYijisfsj = valLong;
        }

        if (null == dtYijisfjg) {
            this.dtYijisfjg = valLong;
        }

        if (null == dtYijisfcysj) {
            this.dtYijisfcysj = valLong;
        }

        if (null == dtYijisfcs) {
            this.dtYijisfcs = valLong;
        }
    }
}

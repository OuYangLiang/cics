package com.oyl.cics.model.pidaimeicaiyang;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pidaimeicaiyang {

    private Long id;

    /**
     * 备用字段1
     */
    private String byzd1;
    /**
     * 备用字段10
     */
    private String byzd10;
    /**
     * 备用字段2
     */
    private String byzd2;
    /**
     * 备用字段3
     */
    private String byzd3;
    /**
     * 备用字段4
     */
    private String byzd4;
    /**
     * 备用字段5
     */
    private String byzd5;
    /**
     * 备用字段6
     */
    private String byzd6;
    /**
     * 备用字段7
     */
    private String byzd7;
    /**
     * 备用字段8
     */
    private String byzd8;
    /**
     * 备用字段9
     */
    private String byzd9;
    /**
     * 采样单元数量
     */
    private Long cydysl;
    /**
     * 采样批煤量
     */
    private Double cypml;
    /**
     * 采样单元详情数据
     */
    private List<PidaimeicaiyangDetail> dtCydy;
    /**
     * 批次煤样标识
     */
    private String mybs;
    /**
     * 数据推送单位
     */
    private String sjtsdanwei;
    /**
     * 数据源系统
     */
    private String sjyxt;
    /**
     * 所属二级公司
     */
    private String ssejdw;
    /**
     * 所属二级公司代码
     */
    private String ssejdwid;
    /**
     * 所属三级公司
     */
    private String sssjdw;
    /**
     * 所属三级公司代码
     */
    private String sssjdwid;
    /**
     * 数据推送日期
     */
    private String xtscjlI;
    /**
     * 数据推送时间
     */
    private String xtscjlT;

    public void setDefaultValues() {
        String valString = "9999";
        String valDate = "99999999";
        String valTime = "000000";
        long valLong = -1L;
        double valDouble = -1;

        if (null == mybs || this.mybs.trim().isEmpty()) {
            this.mybs = valString;
        }

        if (null == cypml) {
            this.cypml = valDouble;
        }

        if (null == cydysl) {
            this.cydysl = valLong;
        }

        if (null == sjyxt || this.sjyxt.trim().isEmpty()) {
            this.sjyxt = valString;
        }

        if (null == sjtsdanwei || this.sjtsdanwei.trim().isEmpty()) {
            this.sjtsdanwei = valString;
        }

        if (null == xtscjlI || this.xtscjlI.trim().isEmpty()) {
            this.xtscjlI = valDate;
        }

        if (null == xtscjlT || this.xtscjlT.trim().isEmpty()) {
            this.xtscjlT = valTime;
        }

        if (null != this.getDtCydy()) {
            for (PidaimeicaiyangDetail item : this.getDtCydy()) {
                item.setDefaultValues();
            }
        }
    }
}

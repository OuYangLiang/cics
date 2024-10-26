package com.oyl.cics.model.guidaoheng;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuidaohengDetail {
    private Long id;
    /**
     * 明细磅单号
     */
    private String zmxdocNo;

    /**
     * 每车详情-序号
     */
    private String dtSortno;

    /**
     * 每车详情-车号
     */
    private String dtChehao;

    /**
     * 每车详情-车型
     */
    private String dtChexing;

    /**
     * 每车详情-毛重
     */
    private Double dtMaozhong;

    /**
     * 每车详情-皮重
     */
    private Double dtPizhong;

    /**
     * 每车详情-净重
     */
    private Double dtJingzhong;

    /**
     * 每车详情-标重吨数
     */
    private Double dtBzdunshu;

    /**
     * 每车详情-票重
     */
    private Double dtPiaozhong;

    /**
     * 每车详情-盈吨
     */
    private Double dtYingdun;

    /**
     * 每车详情-亏吨
     */
    private Double dtKuidun;

    /**
     * 每车详情-运损
     */
    private Double dtYunsun;

    /**
     * 每车详情-扣吨
     */
    private Double dtKoudun;

    /**
     * 每车详情-检重时间
     */
    private String dtCztime;

    /**
     * 每车详情-检轻时间
     */
    private String dtCqtime;

    /**
     * 每车详情-过衡速度
     */
    private Double dtGhsudu;

    /**
     * 每车详情-预留字段1
     */
    private String dtReserve1;

    /**
     * 每车详情-预留字段2
     */
    private String dtReserve2;

    /**
     * 每车详情-预留字段3
     */
    private String dtReserve3;

    /**
     * 每车详情-预留字段4
     */
    private String dtReserve4;

    /**
     * 每车详情-预留字段5
     */
    private String dtReserve5;

    public void setDefaultValues() {
        String valString = "9999";
        String valDate = "99999999";
        String valTime = "000000";
        long valLong = -1L;
        double valDouble = -1;

        if (null == this.dtSortno || this.dtSortno.trim().isEmpty()) {
            this.dtSortno = valString;
        }

        if (null == this.dtChehao || this.dtChehao.trim().isEmpty()) {
            this.dtChehao = valString;
        }

        if (null == this.dtChexing || this.dtChexing.trim().isEmpty()) {
            this.dtChexing = valString;
        }

        if (null == this.dtMaozhong) {
            this.dtMaozhong = valDouble;
        }

        if (null == this.dtPizhong) {
            this.dtPizhong = valDouble;
        }

        if (null == this.dtJingzhong) {
            this.dtJingzhong = valDouble;
        }

        if (null == this.dtBzdunshu) {
            this.dtBzdunshu = valDouble;
        }
    }
}

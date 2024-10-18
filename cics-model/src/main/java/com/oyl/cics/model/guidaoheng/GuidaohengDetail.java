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

}

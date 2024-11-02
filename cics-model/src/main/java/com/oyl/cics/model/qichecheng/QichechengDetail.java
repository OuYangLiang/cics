package com.oyl.cics.model.qichecheng;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QichechengDetail {
    private Long id;
    /**
     * 每车详情-车牌号
     */
    private String dtChepaihao;
    /**
     * 每车详情-净重
     */
    private Double dtJingzhong;
    /**
     * 每车详情-检轻日期
     */
    private String dtJqdate;
    /**
     * 每车详情-检轻衡ID
     */
    private String dtJqhid;
    /**
     * 每车详情-检轻衡名称
     */
    private String dtJqhmc;
    /**
     * 每车详情-检轻时间
     */
    private String dtJqtime;
    /**
     * 每车详情-检重日期
     */
    private String dtJzdate;
    /**
     * 每车详情-检重衡ID
     */
    private String dtJzhid;
    /**
     * 每车详情-检重衡名称
     */
    private String dtJzhmc;
    /**
     * 每车详情-检重时间
     */
    private String dtJztime;
    /**
     * 每车详情-扣吨量
     */
    private Double dtKoudunl;
    /**
     * 每车详情-亏吨
     */
    private Double dtKuidun;
    /**
     * 每车详情-毛重
     */
    private Double dtMaozhong;
    /**
     * 每车详情-票重
     */
    private Double dtPiaozhong;
    /**
     * 每车详情-皮重
     */
    private Double dtPizhong;
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
    /**
     * 每车详情-序号
     */
    private String dtSortno;
    /**
     * 每车详情-盈吨
     */
    private Double dtYingdun;
    /**
     * 每车详情-运损
     */
    private Double dtYunsun;
    /**
     * 明细磅单号
     */
    private String zmxdocNo;

    public void setDefaultValues() {
        String valString = "9999";
        String valDate = "99999999";
        String valTime = "000000";
        long valLong = -1L;
        double valDouble = -1;

        if (null == this.dtSortno || this.dtSortno.trim().isEmpty()) {
            this.dtSortno = valString;
        }

        if (null == this.dtChepaihao || this.dtChepaihao.trim().isEmpty()) {
            this.dtChepaihao = valString;
        }

        if (null == dtMaozhong) {
            this.dtMaozhong = valDouble;
        }

        if (null == dtPizhong) {
            this.dtPizhong = valDouble;
        }

        if (null == dtJingzhong) {
            this.dtJingzhong = valDouble;
        }

        if (null == dtKoudunl) {
            this.dtKoudunl = valDouble;
        }

        if (null == dtJzdate || this.dtJzdate.trim().isEmpty()) {
            this.dtJzdate = valDate;
        }

        if (null == dtJztime || this.dtJztime.trim().isEmpty()) {
            this.dtJztime = valTime;
        }

        if (null == dtJqdate || this.dtJqdate.trim().isEmpty()) {
            this.dtJqdate = valDate;
        }

        if (null == dtJqtime || this.dtJqtime.trim().isEmpty()) {
            this.dtJqtime = valTime;
        }

        if (null == this.dtJzhmc || this.dtJzhmc.trim().isEmpty()) {
            this.dtJzhmc = valString;
        }

        if (null == this.dtJzhid || this.dtJzhid.trim().isEmpty()) {
            this.dtJzhid = valString;
        }

        if (null == this.dtJqhmc || this.dtJqhmc.trim().isEmpty()) {
            this.dtJqhmc = valString;
        }

        if (null == this.dtJqhid || this.dtJqhid.trim().isEmpty()) {
            this.dtJqhid = valString;
        }
    }

}

package com.oyl.cics.model.qichecheng;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Qichecheng {
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
     * 车数
     */
    private Double cheshu;

    /**
     * 结算煤量
     */
    private Double jiesuanmeiliang;
    /**
     * 计量单位
     */
    private String jiliangdanwei;
    /**
     * 计量衡器用途
     */
    private String jlhqyt;
    /**
     * 总扣吨量
     */
    private Double koudunzongliang;
    /**
     * 客户编号
     */
    private String kunnr;
    /**
     * 煤炭来源
     */
    private String meitanlaiyuan;
    /**
     * 煤炭来源编码
     */
    private String meitanlaiyuanbm;
    /**
     * 煤种
     */
    private String meizhong;
    /**
     * 煤种编码
     */
    private String meizhongbm;
    /**
     * 煤源矿点编码
     */
    private String mykuangdianbm;
    /**
     * 煤源矿点名称
     */
    private String mykuangdianmc;
    /**
     * 客户名称
     */
    private String name1;
    /**
     * 数据推送单位
     */
    private String sjtsdanwei;
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
     * 销售组织代码
     */
    private String vkorg;
    /**
     * 销售组织描述
     */
    private String vtext;
    /**
     * 数据推送日期
     */
    private String xtscjlI;
    /**
     * 数据推送时间
     */
    private String xtscjlT;
    /**
     * 批煤过磅开始日期
     */
    private String zbeginI;
    /**
     * 批煤过磅开始时间
     */
    private String zbeginT;
    /**
     * 批煤过磅结束日期
     */
    private String zendI;
    /**
     * 批煤过磅结束时间
     */
    private String zendT;
    /**
     * 交货方式
     */
    private String zjhfs;
    /**
     * 收货单位编码（终到用户）
     */
    private String zkunnr;
    /**
     * 主磅单号
     */
    private String zmasterNo;
    /**
     * 发运量
     */
    private Double zmeng;
    /**
     * 验收量
     */
    private Double zmengpod;
    /**
     * 明细磅单号
     */
    private String zmxdocNo;
    /**
     * 收货单位名称（终到用户）
     */
    private String zname1;
    /**
     * 车队名称
     */
    private String zname1Car;
    /**
     * 总净重
     */
    private Double zongjingzhong;
    /**
     * 总亏吨
     */
    private Double zongkuidun;
    /**
     * 总毛重
     */
    private Double zongmaozhong;
    /**
     * 总票重
     */
    private Double zongpiaozhong;
    /**
     * 总皮重
     */
    private Double zongpizhong;
    /**
     * 总盈吨
     */
    private Double zongyingdun;
    /**
     * 总盈亏
     */
    private Double zongyingkui;
    /**
     * 总运损
     */
    private Double zongyunsun;
    /**
     * 发运站编码
     */
    private String zsitebm;
    /**
     * 发运站名称
     */
    private String zsitename;

    /**
     * 详情数据
     */
    private List<QichechengDetail> dtData;
}

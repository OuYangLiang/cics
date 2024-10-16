package com.oyl.cics.model.huayandan;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Huayandan {
    /**
     * 化验编号
     */
    private String assayid;
    /**
     * 备用字段1
     */
    private String byzd1;
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
     * 化验日期
     */
    private String dtAssayI;
    /**
     * 化验时间
     */
    private String dtAssayT;
    /**
     * 粘结指数
     */
    private Double dtBondindex;
    /**
     * 对应煤量
     */
    private Double dtDuiyingml;
    /**
     * 哈式可磨指数
     */
    private Double dtHgi;
    /**
     * 化验单ID
     */
    private String dtHydid;
    /**
     * 化验单序号
     */
    private String dtHydxh;
    /**
     * 快/慢灰
     */
    private String dtKuaimanhui;
    /**
     * 灰分（空干基）（%）
     */
    private Double dtNgyaad;
    /**
     * 分析水（%）
     */
    private Double dtNgymad;
    /**
     * 全水分（%）
     */
    private Double dtNgymt;
    /**
     * 挥发分（空干基）（%）
     */
    private Double dtNgyvad;
    /**
     * 挥发分（干燥无灰基）（%）
     */
    private Double dtNgyvdaf;
    /**
     * 灰熔融性-变形温度
     */
    private Double dtNhrdt;
    /**
     * 灰熔融性-流动温度
     */
    private Double dtNhrft;
    /**
     * 灰熔融性-半球温度
     */
    private Double dtNhrht;
    /**
     * 灰熔融性-软化温度
     */
    private Double dtNhrst;
    /**
     * 灰分（收到基）（%）
     */
    private Double dtNlcfaar;
    /**
     * 灰分（干基）（%）
     */
    private Double dtNlcfad;
    /**
     * 硫分（空干基）（%）
     */
    private Double dtNlcfstad;
    /**
     * 硫分（收到基）（%）
     */
    private Double dtNlcfstar;
    /**
     * 硫分（干基）（%）
     */
    private Double dtNlcfstd;
    /**
     * 挥发分（收到基）（%）
     */
    private Double dtNlcfvar;
    /**
     * 挥发分（干基）（%）
     */
    private Double dtNlcfvd;
    /**
     * 弹筒发热量（MJ/kg）
     */
    private Double dtNqbadmj;
    /**
     * 高位发热量（空气干燥基）（kcal/kg）
     */
    private Double dtNqgradkc;
    /**
     * 高位发热量（空气干燥基）（MJ/kg）
     */
    private Double dtNqgradmj;
    /**
     * 高位发热量（收到基）
     */
    private Double dtNqgrarmj;
    /**
     * 高位发热量（干燥基）（kcal/kg）
     */
    private Double dtNqgrdkc;
    /**
     * 高位发热量（干基）（MJ/kg）
     */
    private Double dtNqgrdmj;
    /**
     * 低位发热量（收到基）（MJ/kg）
     */
    private Double dtNqnetarmj;
    /**
     * 低位发热量（收到基）（kcal/kg）
     */
    private Double dtNqnetmarkc;
    /**
     * 碳（干燥无灰基）
     */
    private Double dtNycdaf;
    /**
     * 氢（干燥无灰基）
     */
    private Double dtNyhdaf;
    /**
     * 焦渣特性
     */
    private Long dtNymqcrc;
    /**
     * 碳（空干基）
     */
    private Double dtNyscad;
    /**
     * 碳（干基）
     */
    private Double dtNyscd;
    /**
     * 固定碳（空干基）（%）
     */
    private Double dtNysfcad;
    /**
     * 氢（空干基）
     */
    private Double dtNyshad;
    /**
     * 氢（收到基）
     */
    private Double dtNyshar;
    /**
     * 氢（干基）
     */
    private Double dtNyshd;
    /**
     * 固定碳（干基）（%）
     */
    private Double dtNyshfcd;
    /**
     * 化验室名称
     */
    private String hyorgname;
    /**
     * 检测方式
     */
    private String jiancefangshi;
    /**
     * 检测结果用途
     */
    private String jiancejieguoyt;
    /**
     * 检测设备ID
     */
    private String jiancesbid;
    /**
     * 检测设备名称
     */
    private String jiancesbmc;
    /**
     * 煤种
     */
    private String meizhong;
    /**
     * 煤种编码
     */
    private String meizhongbm;
    /**
     * 批次煤样标识
     */
    private String mybs;
    /**
     * 采样日期
     */
    private String sampeldate;
    /**
     * 采样编号
     */
    private String sampleid;
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
     * 数据推送日期
     */
    private String xtscjlI;
    /**
     * 数据推送时间
     */
    private String xtscjlT;

}
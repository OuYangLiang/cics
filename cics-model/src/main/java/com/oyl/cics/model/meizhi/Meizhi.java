package com.oyl.cics.model.meizhi;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Meizhi {
    /**
     * 化验日期
     */
    private String assayI;
    /**
     * 化验时间
     */
    private String assayT;
    /**
     * 备注
     */
    private String beizhu;
    /**
     * 粘结指数
     */
    private Double bondindex;
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
     * 编组编号
     */
    private String bzId;
    /**
     * 出证日期
     */
    private String czrq;
    /**
     * 详情数据
     */
    private List<MeizhiDetail> dtHydbhxq;
    /**
     * 哈式可磨指数
     */
    private Double hgi;
    /**
     * 化验单数量
     */
    private String hydsl;
    /**
     * 化验室名称
     */
    private String hyorgname;
    /**
     * 化验总批煤量
     */
    private Double hypml;
    /**
     * 检测方式
     */
    private String jiancefangshi;
    /**
     * 检测设备ID
     */
    private String jiancesbid;
    /**
     * 检测设备名称
     */
    private String jiancesbmc;
    /**
     * 快/慢灰
     */
    private String kuaimanhui;
    /**
     * 装车尾车号
     */
    private String loadEndNo;
    /**
     * 装车首车号
     */
    private String loadStartNo;
    /**
     * 煤种
     */
    private String meizhong;
    /**
     * 煤种编码
     */
    private String meizhongbm;
    /**
     * 煤灰成分Al2O3
     */
    private Double mhcfAlo;
    /**
     * 煤灰成分CaO
     */
    private Double mhcfCao;
    /**
     * 煤灰成分Fe2O3
     */
    private Double mhcfFeo;
    /**
     * 煤灰成分K2O
     */
    private Double mhcfKo;
    /**
     * 煤灰成分MgO
     */
    private Double mhcfMgo;
    /**
     * 煤灰成分NaO2
     */
    private Double mhcfNao;
    /**
     * 煤灰成分P2O5
     */
    private Double mhcfPo;
    /**
     * 煤灰成分SiO2
     */
    private Double mhcfSio;
    /**
     * 煤灰成分SO3
     */
    private Double mhcfSo;
    /**
     * 煤灰成分TiO2
     */
    private Double mhcfTio;
    /**
     * 批次煤样标识
     */
    private String mybs;
    /**
     * 灰分（空干基）（%）
     */
    private Double ngyaad;
    /**
     * 分析水（%）
     */
    private Double ngymad;
    /**
     * 全水分（%）
     */
    private Double ngymt;
    /**
     * 挥发分（空干基）（%）
     */
    private Double ngyvad;
    /**
     * 挥发分（干燥无灰基）（%）
     */
    private Double ngyvdaf;
    /**
     * 灰熔融性-变形温度
     */
    private String nhrDt;
    /**
     * 灰熔融性-流动温度
     */
    private String nhrFt;
    /**
     * 灰熔融性-半球温度
     */
    private String nhrHt;
    /**
     * 灰熔融性-软化温度
     */
    private String nhrSt;
    /**
     * 灰分（收到基）（%）
     */
    private Double nlcfaar;
    /**
     * 灰分（干基）（%）
     */
    private Double nlcfad;
    /**
     * 硫分（空干基）（%）
     */
    private Double nlcfstad;
    /**
     * 硫分（收到基）（%）
     */
    private Double nlcfstar;
    /**
     * 硫分（干基）（%）
     */
    private Double nlcfstd;
    /**
     * 挥发分（收到基）（%）
     */
    private Double nlcfvar;
    /**
     * 挥发分（干基）（%）
     */
    private Double nlcfvd;
    /**
     * 弹筒发热量（MJ/kg）
     */
    private Double nqbadmj;
    /**
     * 高位发热量（空气干燥基）（kcal/kg）
     */
    private Double nqgradkc;
    /**
     * 高位发热量（空气干燥基）（MJ/kg）
     */
    private Double nqgradmj;
    /**
     * 高位发热量（收到基）
     */
    private Double nqgrarmj;
    /**
     * 高位发热量（干燥基）（kcal/kg）
     */
    private Double nqgrdkc;
    /**
     * 高位发热量（干基）（MJ/kg）
     */
    private Double nqgrdmj;
    /**
     * 低位发热量（收到基）（MJ/kg）
     */
    private Double nqnetarmj;
    /**
     * 低位发热量（收到基）（kcal/kg）
     */
    private Double nqnetmarkc;
    /**
     * 碳（干燥无灰基）
     */
    private Double nycdaf;
    /**
     * 氢（干燥无灰基）
     */
    private Double nyhdaf;
    /**
     * 焦渣特性
     */
    private Long nymqcrc;
    /**
     * 碳（空干基）
     */
    private Double nyscad;
    /**
     * 碳（干基）
     */
    private Double nyscd;
    /**
     * 固定碳（空干基）（%）
     */
    private Double nysfcad;
    /**
     * 氢（空干基）
     */
    private Double nyshad;
    /**
     * 氢（收到基）
     */
    private Double nyshar;
    /**
     * 氢（干基）
     */
    private Double nyshd;
    /**
     * 固定碳（干基）（%）
     */
    private Double nyshfcd;
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
     * 煤质信息状态
     */
    private String status;
    /**
     * 委托单号
     */
    private String wtdh;
    /**
     * 卸车单号
     */
    private String xiecheid;
    /**
     * 数据推送日期
     */
    private String xtscjlI;
    /**
     * 数据推送时间
     */
    private String xtscjlT;
    /**
     * 装车单号
     */
    private String zcdanhao;
    /**
     * 证书编号
     */
    private String zsbh;
}

package com.oyl.cics.model.guidaoheng;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Guidaoheng {

    /**
     * 明细磅单号
     */
    private String zmxdocNo;

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
     * 装车站点
     */
    private String zczhandian;

    /**
     * 装车站点编码
     */
    private String zczhandianbm;

    /**
     * 车次
     */
    private String zccheci;

    /**
     * 车型
     */
    private String chexing;

    /**
     * 煤源矿点名称
     */
    private String mykuangdianmc;

    /**
     * 煤源矿点编码
     */
    private String mykuangdianbm;

    /**
     * 煤炭来源
     */
    private String meitanlaiyuan;

    /**
     * 煤炭来源编码
     */
    private String meitanlaiyuanbm;

    /**
     * 收货单位名称（终到用户）
     */
    private String zname1;

    /**
     * 收货单位编号（终到用户）
     */
    private String zkunnr;

    /**
     * 销售组织描述
     */
    private String vtext;

    /**
     * 销售组织代码
     */
    private String vkorg;

    /**
     * 首车号
     */
    private String shouchehao;

    /**
     * 尾车号
     */
    private String weichehao;

    /**
     * 车数
     */
    private Long cheshu;

    /**
     * 计量单位
     */
    private String jiliangdanwei;

    /**
     * 总票重
     */
    private Double zongpiaozhong;

    /**
     * 总毛重
     */
    private Double zongmaozhong;

    /**
     * 总皮重
     */
    private Double zongpizhong;

    /**
     * 总净重
     */
    private Double zongjingzhong;

    /**
     * 总扣吨量
     */
    private Double koudunzongliang;

    /**
     * 结算煤量
     */
    private Double jiesuanmeiliang;

    /**
     * 总盈亏
     */
    private Double zongyingkui;

    /**
     * 总盈吨
     */
    private Double zongyingdun;

    /**
     * 总亏吨
     */
    private Double zongkuidun;

    /**
     * 总运损
     */
    private Double zongyunsun;

    /**
     * 过衡时间
     */
    private String duiweisj;

    /**
     * 过衡日期
     */
    private String duiweirq;

    /**
     * 业务日期
     */
    private String yewurq;

    /**
     * 煤种
     */
    private String zcmeizhong;

    /**
     * 煤种编码
     */
    private String zcmeizhongbm;

    /**
     * 外购煤供应商
     */
    private String wgmgys;

    /**
     * 数据源系统
     */
    private String sjyxt;

    /**
     * 车源
     */
    private String cheyuan;

    /**
     * 运单号
     */
    private String yundanhaoyundanhao;

    /**
     * 计量类型
     */
    private String jltypetype;

    /**
     * 计量衡器用途
     */
    private String jlhqyt;

    /**
     * 计量衡器名称
     */
    private String jlhqmc;

    /**
     * 计量衡器ID
     */
    private String jlhqmcid;

    /**
     * 到站
     */
    private String daozhan;

    /**
     * 发站
     */
    private String fazhan;

    /**
     * 终到站
     */
    private String zhongdao;

    /**
     * 数据推送单位
     */
    private String sjtsdanwei;

    /**
     * 数据推送日期
     */
    private String xtscjlI;
    /**
     * 数据推送时间
     */
    private String xtscjlT;

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
     * 备用字段10
     */
    private String byzd10;

    /**
     * 详情数据
     */
    private List<GuidaohengDetail> dtData;

}
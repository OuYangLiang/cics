package com.oyl.cics.model.guidaoheng;

import com.oyl.cics.model.common.utils.DateUtil;
import com.oyl.cics.model.shared.UploadStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Guidaoheng {

    private Long id;

    private Date ywrq;

    private String appID;

    private String sjscfs;

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

    /**
     * 上报状态
     */
    private UploadStatus uploadStatus;

    /**
     * 上报时间
     */
    private Date uploadTime;

    /**
     * 上报操作人
     */
    private String operator;

    public String getUploadStatusDesc() {
        return null == uploadStatus ? null : uploadStatus.getDesc();
    }

    public void setDefaultValues() {
        String valString = "9999";
        String valDate = "99999999";
        String valTime = "000000";
        long valLong = -1L;
        double valDouble = -1;

        if (null == this.getZmxdocNo() || this.getZmxdocNo().trim().isEmpty()) {
            this.setZmxdocNo(valString);
        }

        if (null == this.getSsejdw() || this.getSsejdw().trim().isEmpty()) {
            this.setSssjdw(valString);
        }

        if (null == this.getSsejdwid() || this.getSsejdwid().trim().isEmpty()) {
            this.setSsejdwid(valString);
        }

        if (null == this.getSssjdw() || this.getSssjdw().trim().isEmpty()) {
            this.setSssjdw(valString);
        }

        if (null == this.getSssjdwid() || this.getSssjdwid().trim().isEmpty()) {
            this.setSssjdwid(valString);
        }

        if (null == this.getZczhandian() || this.getZczhandian().trim().isEmpty()) {
            this.setZczhandian(valString);
        }

        if (null == this.getZczhandianbm() || this.getZczhandianbm().trim().isEmpty()) {
            this.setZczhandianbm(valString);
        }

        if (null == this.getZccheci() || this.getZccheci().trim().isEmpty()) {
            this.setZccheci(valString);
        }

        if (null == this.getChexing() || this.getChexing().trim().isEmpty()) {
            this.setChexing(valString);
        }

        if (null == this.mykuangdianmc || this.mykuangdianmc.trim().isEmpty()) {
            this.mykuangdianmc = valString;
        }

        if (null == this.mykuangdianbm || this.mykuangdianbm.trim().isEmpty()) {
            this.mykuangdianbm = valString;
        }

        if (null == this.shouchehao || this.shouchehao.trim().isEmpty()) {
            this.shouchehao = valString;
        }

        if (null == this.weichehao || this.weichehao.trim().isEmpty()) {
            this.weichehao = valString;
        }

        if (null == this.cheshu) {
            this.cheshu = valLong;
        }

        if (null == this.jiliangdanwei || this.jiliangdanwei.trim().isEmpty()) {
            this.jiliangdanwei = valString;
        }

        if (null == this.zongmaozhong) {
            this.zongmaozhong = valDouble;
        }

        if (null == this.zongpizhong) {
            this.zongpizhong = valDouble;
        }

        if (null == this.zongjingzhong) {
            this.zongjingzhong = valDouble;
        }

        if (null == this.koudunzongliang) {
            this.koudunzongliang = valDouble;
        }

        if (null == this.duiweisj || this.duiweisj.trim().isEmpty()) {
            this.duiweisj = valDate;
        }

        if (null == this.duiweirq || this.duiweirq.trim().isEmpty()) {
            this.duiweirq = valTime;
        }

        if (null == this.yewurq || this.yewurq.trim().isEmpty()) {
            this.yewurq = valDate;
        }

        if (null == this.zcmeizhong || this.zcmeizhong.trim().isEmpty()) {
            this.zcmeizhong = valString;
        }

        if (null == this.zcmeizhongbm || this.zcmeizhongbm.trim().isEmpty()) {
            this.zcmeizhongbm = valString;
        }

        if (null == this.sjyxt || this.sjyxt.trim().isEmpty()) {
            this.sjyxt = valString;
        }

        if (null == this.jltypetype || this.jltypetype.trim().isEmpty()) {
            this.jltypetype = valString;
        }

        if (null == this.jlhqyt || this.jlhqyt.trim().isEmpty()) {
            this.jlhqyt = valString;
        }

        if (null == this.jlhqmc || this.jlhqmc.trim().isEmpty()) {
            this.jlhqmc = valString;
        }

        if (null == this.sjtsdanwei || this.sjtsdanwei.trim().isEmpty()) {
            this.sjtsdanwei = valString;
        }

        if (null == this.xtscjlI || this.xtscjlI.trim().isEmpty()) {
            this.xtscjlI = DateUtil.inst.date();
        }

        if (null == this.xtscjlT || this.xtscjlT.trim().isEmpty()) {
            this.xtscjlT = DateUtil.inst.time();
        }

        if (null != this.getDtData()) {
            for (GuidaohengDetail item : this.getDtData()) {
                item.setDefaultValues();
            }
        }
    }
}
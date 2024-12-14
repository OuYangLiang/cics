package com.oyl.cics.model.kjhuayandan;

import com.oyl.cics.model.shared.UploadStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Kjhuayandan {
    private Long id;
    private Date ywrq;
    private String appID;
    private String sssjdwid;
    private String mybs;
    private String dtHydid;
    private String dtHydxh;
    private String hyorgname;
    private String sampeldate;
    private String sampleid;
    private String assayid;
    private String jiancejieguoyt;
    private String jiancefangshi;
    private String jiancesbmc;
    private String jiancesbid;
    private String meizhong;
    private String meizhongbm;
    private String dtAssayI;
    private String dtAssayT;
    private Double dtDuiyingml;
    private String version;
    private String equipmentId;
    private Long infoCount;
    private String scanNumber;
    private String onLineStatus;
    private String indexUuid;
    private String coalName;
    private String tailNumber;
    private String loadNumber;
    private String loadSite;
    private String firstNumber;
    private String loadTime;
    private String avglowHeatValueMj;
    private String avghighHeatValueMj;
    private String avglowHeatValueKcal;
    private String avghighHeatValueKcal;
    private String avgashContent;
    private String avgsulfurContent;
    private String avgfullyWash;
    private String avgashMeltingPoint;
    private String avgcarbonContent;
    private String avghydrogenContent;
    private String avgvolatileMatter;
    private String sjscfs;
    private String avgfixedCarbon;
    private String avgharmfulElementCI;
    private String avgharmfulElementP;
    private String avgDryVolatileMatter;
    private String avgDeformationTemp;
    private String avgSofteningTemp;
    private String avgHemisphereTemp;
    private String avgFlowTemp;
    private String singleIndex;
    private String singlelowHeatValueMj;
    private String singlehighHeatValueMj;
    private String singlelowHeatValueKcal;
    private String singlehighHeatValueKcal;
    private String singleashContent;
    private String singlesulfurContent;
    private String singlefullyWash;
    private String singleashMeltingPoint;
    private String singlecarbonContent;
    private String singlehydrogenContent;
    private String singlevolatileMatter;
    private String singllefixedCarbon;
    private String singleharmfulElementCI;
    private String singleharmfulElementP;
    private String singleDryVolatileMatter;
    private String singleDeformationTemp;
    private String singleSofteningTemp;
    private String singleHemisphereTemp;
    private String singleFlowTemp;
    private String startTime;
    private String finishTime;
    private String volume;
    private String algoModel;
    private String algoModelUpdateTime;
    private String sampleParameter1;
    private String sampleParameter2;
    private String trainNumberStop;
    private String trainNumber;
    private String testSampleCount;
    private String reserve1;
    private String reserve2;
    private String reserve3;
    private String reserve4;
    private String reserve5;
    private String reserve6;
    private String reserve7;

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

        if (null == mybs || this.mybs.trim().isEmpty()) {
            this.mybs = valString;
        }

        if (null == dtHydid || this.dtHydid.trim().isEmpty()) {
            this.dtHydid = valString;
        }

        if (null == dtHydxh || this.dtHydxh.trim().isEmpty()) {
            this.dtHydxh = valString;
        }

        if (null == jiancejieguoyt || this.jiancejieguoyt.trim().isEmpty()) {
            this.jiancejieguoyt = valString;
        }

        if (null == jiancefangshi || this.jiancefangshi.trim().isEmpty()) {
            this.jiancefangshi = valString;
        }

        if (null == jiancesbmc || this.jiancesbmc.trim().isEmpty()) {
            this.jiancesbmc = valString;
        }

        if (null == jiancesbid || this.jiancesbid.trim().isEmpty()) {
            this.jiancesbid = valString;
        }

        if (null == meizhong || this.meizhong.trim().isEmpty()) {
            this.meizhong = valString;
        }

        if (null == meizhongbm || this.meizhongbm.trim().isEmpty()) {
            this.meizhongbm = valString;
        }

        if (null == dtAssayI || this.dtAssayI.trim().isEmpty()) {
            this.dtAssayI = valDate;
        }

        if (null == dtAssayT || this.dtAssayT.trim().isEmpty()) {
            this.dtAssayT = valTime;
        }

        if (null == dtDuiyingml) {
            this.dtDuiyingml = valDouble;
        }

    }
}

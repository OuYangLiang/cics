package com.oyl.cics.model.meizhi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeizhiDetail {

    private Long id;

    /**
     * 化验单1ID
     */
    private String dtHyd1id;
    /**
     * 化验单2ID
     */
    private String dtHyd2id;
    /**
     * 化验单3ID
     */
    private String dtHyd3id;
    /**
     * 化验单4ID
     */
    private String dtHyd4id;
    /**
     * 化验单5ID
     */
    private String dtHyd5id;
    /**
     * 化验单6ID
     */
    private String dtHyd6id;
    /**
     * 化验单7ID
     */
    private String dtHyd7id;
    /**
     * 化验单8ID
     */
    private String dtHyd8id;
    /**
     * 批次煤样标识
     */
    private String mybs;

    public void setDefaultValues() {
        String valString = "9999";
        String valDate = "99999999";
        String valTime = "000000";
        long valLong = -1L;
        double valDouble = -1;

        if (null == dtHyd1id || this.dtHyd1id.trim().isEmpty()) {
            this.dtHyd1id = valString;
        }

        if (null == dtHyd2id || this.dtHyd2id.trim().isEmpty()) {
            this.dtHyd2id = valString;
        }

        if (null == dtHyd3id || this.dtHyd3id.trim().isEmpty()) {
            this.dtHyd3id = valString;
        }

        if (null == dtHyd4id || this.dtHyd4id.trim().isEmpty()) {
            this.dtHyd4id = valString;
        }

        if (null == dtHyd5id || this.dtHyd5id.trim().isEmpty()) {
            this.dtHyd5id = valString;
        }

        if (null == dtHyd6id || this.dtHyd6id.trim().isEmpty()) {
            this.dtHyd6id = valString;
        }

        if (null == dtHyd7id || this.dtHyd7id.trim().isEmpty()) {
            this.dtHyd7id = valString;
        }

        if (null == dtHyd8id || this.dtHyd8id.trim().isEmpty()) {
            this.dtHyd8id = valString;
        }

    }
}

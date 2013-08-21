package org.questionairemanager.engine;

public class LegalValueItemData {
    
    private String sLegalValueItemGuid;
    private String sLegalValueTableGuid;
    private String sValue;
    private String sOrdinal;
    private String sShortName;
    private String sTag;
    private Boolean bHidden;
    private String sReportLabel;
    
    /**
     * @return the sLegalValueItemGuid
     */
    public String getsLegalValueItemGuid() {
        return sLegalValueItemGuid;
    }
    /**
     * @param sLegalValueItemGuid the sLegalValueItemGuid to set
     */
    public void setsLegalValueItemGuid(String sLegalValueItemGuid) {
        this.sLegalValueItemGuid = sLegalValueItemGuid;
    }
    /**
     * @return the sLegalValueTableGuid
     */
    public String getsLegalValueTableGuid() {
        return sLegalValueTableGuid;
    }
    /**
     * @param sLegalValueTableGuid the sLegalValueTableGuid to set
     */
    public void setsLegalValueTableGuid(String sLegalValueTableGuid) {
        this.sLegalValueTableGuid = sLegalValueTableGuid;
    }
    /**
     * @return the sValue
     */
    public String getsValue() {
        return sValue;
    }
    /**
     * @param sValue the sValue to set
     */
    public void setsValue(String sValue) {
        this.sValue = sValue;
    }
    /**
     * @return the sOrdinal
     */
    public String getsOrdinal() {
        return sOrdinal;
    }
    /**
     * @param sOrdinal the sOrdinal to set
     */
    public void setsOrdinal(String sOrdinal) {
        this.sOrdinal = sOrdinal;
    }
    /**
     * @return the sShortName
     */
    public String getsShortName() {
        return sShortName;
    }
    /**
     * @param sShortName the sShortName to set
     */
    public void setsShortName(String sShortName) {
        this.sShortName = sShortName;
    }
    /**
     * @return the sTag
     */
    public String getsTag() {
        return sTag;
    }
    /**
     * @param sTag the sTag to set
     */
    public void setsTag(String sTag) {
        this.sTag = sTag;
    }
    /**
     * @return the bHidden
     */
    public Boolean getbHidden() {
        return bHidden;
    }
    /**
     * @param bHidden the bHidden to set
     */
    public void setbHidden(Boolean bHidden) {
        this.bHidden = bHidden;
    }
    /**
     * @return the sReportLabel
     */
    public String getsReportLabel() {
        return sReportLabel;
    }
    /**
     * @param sReportLabel the sReportLabel to set
     */
    public void setsReportLabel(String sReportLabel) {
        this.sReportLabel = sReportLabel;
    }
    
    /**
     * @param sLegalValueItemGuid
     * @param sLegalValueTableGuid
     * @param sValue
     * @param sOrdinal
     * @param sShortName
     * @param sTag
     * @param bHidden
     * @param sReportLabel
     */
    public LegalValueItemData(String sLegalValueItemGuid, String sLegalValueTableGuid, String sValue,
            String sOrdinal, String sShortName, String sTag, Boolean bHidden, String sReportLabel) {
        
        this.sLegalValueItemGuid = sLegalValueItemGuid;
        this.sLegalValueTableGuid = sLegalValueTableGuid;
        this.sValue = sValue;
        this.sOrdinal = sOrdinal;
        this.sShortName = sShortName;
        this.sTag = sTag;
        this.bHidden = bHidden;
        this.sReportLabel = sReportLabel;
    }
    
    
    /**
     * 
     */
    public LegalValueItemData() {
    }
    
    
    


}

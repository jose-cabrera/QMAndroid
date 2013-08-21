/**
 * 
 */
package org.questionnairemanager.engine.core;

/**
 * Items for a question type (radiobutton, checkbox and more) (checkpoints,
 * radiobuttons, ...)
 * 
 * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
 * <date>Jul, 30 2013</date>
 * 
 */
public class LegalValueItem {

	// ATTRIBUTES
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
	 * @return the sLegalValueTableGuid
	 */
	public String getsLegalValueTableGuid() {
		return sLegalValueTableGuid;
	}

	/**
	 * @return the sValue
	 */
	public String getsValue() {
		return sValue;
	}

	/**
	 * @return the sOrdinal
	 */
	public String getsOrdinal() {
		return sOrdinal;
	}

	/**
	 * @return the sShortName
	 */
	public String getsShortName() {
		return sShortName;
	}

	/**
	 * @return the sTag
	 */
	public String getsTag() {
		return sTag;
	}

	/**
	 * @return the bHidden
	 */
	public Boolean getbHidden() {
		return bHidden;
	}

	/**
	 * @return the sReportLabel
	 */
	public String getsReportLabel() {
		return sReportLabel;
	}

	
	/**
	 * Constructor class
	 */
	public LegalValueItem() {
		this.sLegalValueItemGuid = "";
		this.sLegalValueTableGuid = "";
		this.sValue = "";
		this.sOrdinal = "";
		this.sShortName = "";
		this.sTag = "";
		this.bHidden = false;
		this.sReportLabel = "";
	}

	/**
	 * Constructor class
	 * 
	 * @param sLegalValueItemGuid, GUID of item
	 * @param sLegalValueTableGuid, GUID parent
	 * @param sValue, value
	 * @param sOrdinal, screen order
	 * @param sShortName, short name for item
	 * @param sTag, tag the item
	 * @param bHidden, is item hidden ?
	 * @param sReportLabel, string label for report
	 */
	public LegalValueItem(String sLegalValueItemGuid,
			String sLegalValueTableGuid, String sValue, String sOrdinal,
			String sShortName, String sTag, Boolean bHidden, String sReportLabel) {

		this.sLegalValueItemGuid = sLegalValueItemGuid;
		this.sLegalValueTableGuid = sLegalValueTableGuid;
		this.sValue = sValue;
		this.sOrdinal = sOrdinal;
		this.sShortName = sShortName;
		this.sTag = sTag;
		this.bHidden = bHidden;
		this.sReportLabel = sReportLabel;
	}

}

package org.questionnairemanager.engine.core;

import java.util.ArrayList;

/**
 * Class get the type of question group 
 * (checkpoints, radiobuttons, ...)
 * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
 * <date>Jul, 30 2013</date>
 *
 */
public class LegalValueTable {

	/// ATTRIBUTS
	private String sLegalValueTableGuid; // GUID
	private String sDatatype;	// DATA TYPE
	

	/**
	 * @return the sLegalValueTableGuid
	 */
	public String getsLegalValueTableGuid() {
		return sLegalValueTableGuid;
	}

	/**
	 * @return the sDatatype
	 */
	public String getsDatatype() {
		return sDatatype;
	}


	/**
	 * Class constructor
	 */
	public LegalValueTable(){
		this.sLegalValueTableGuid = "";
		this.sDatatype = "";
	}

	/**
	 * Class constructor
	 * @param sLegalValueTableGuid, GUID 
	 * @param sDatatype, Data type for this Legal Value Table 
	 * @param lviList, Array list items of this table
	 */
	public LegalValueTable(String sLegalValueTableGuid, String sDatatype) {
		this.sLegalValueTableGuid = sLegalValueTableGuid;
		this.sDatatype = sDatatype;

	}



}

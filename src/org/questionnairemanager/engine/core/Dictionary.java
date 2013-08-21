/**
 * 
 */

package org.questionnairemanager.engine.core;

/**
 * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>Aug 7, 2013</date>
 */
public class Dictionary {

    private String sGuid;
    private String sLanguageId;
    private String sPropertyName;
    private String sText;

    /**
     * @return the sGuid
     */
    public String getsGuid() {

	return sGuid;
    }

    /**
     * @return the sLanguageId
     */
    public String getsLanguageId() {

	return sLanguageId;
    }

    /**
     * @return the sProperty
     */
    public String getsProperty() {

	return sPropertyName;
    }

    /**
     * @return the sText
     */
    public String getsText() {

	return sText;
    }

    /**
     * @param sGuid the sGuid to set
     */
    public void setsGuid(String sGuid) {

	this.sGuid = sGuid;
    }

    /**
     * @param sLanguageId the sLanguageId to set
     */
    public void setsLanguageId(String sLanguageId) {

	this.sLanguageId = sLanguageId;
    }

    /**
     * @param sProperty the sProperty to set
     */
    public void setsProperty(String sProperty) {

	this.sPropertyName = sProperty;
    }

    /**
     * @param sText the sText to set
     */
    public void setsText(String sText) {

	this.sText = sText;
    }

    /**
     * @param sGuid
     * @param sLanguageId
     * @param sProperty
     * @param sText
     */
    public Dictionary(String sGuid, String sLanguageId, String sProperty, String sText) {

	this.sGuid = sGuid;
	this.sLanguageId = sLanguageId;
	this.sPropertyName = sProperty;
	this.sText = sText;
    }

    /**
     * Return the element with text, if conditions are true
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Aug 9, 2013</date>
     *
     * @param guid, guid of dictionary
     * @param guidlang, guid for language
     * @return String with text or null in case condition is false.
     */
    public String getDataText (String guid, String guidlang){
	
	if (this.getsGuid().equalsIgnoreCase(guid) && this.getsLanguageId().equalsIgnoreCase(guidlang))
	{
	    return this.getsText();
	}
	
	return null;
	
    }


}

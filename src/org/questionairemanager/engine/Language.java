/**
 * 
 */
package org.questionairemanager.engine;


/**
 * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
 * <date>Aug 07, 2013</date>
 *
 */
public class Language {
    
    private String sLanguageId;
    private String sLanguageName;
    
    /**
     * @param sLanguageId
     * @param sLanguageName
     */
    public Language(String sLanguageId, String sLanguageName) {

	this.sLanguageId = sLanguageId;
	this.sLanguageName = sLanguageName;
    }
    
    /**
     * 
     */
    public Language() {

    }

    
    /**
     * @return the sLanguageId
     */
    public String getsLanguageId() {
    
        return sLanguageId;
    }

    
    /**
     * @return the sLanguageName
     */
    public String getsLanguageName() {
    
        return sLanguageName;
    }

    
    /**
     * @param sLanguageId the sLanguageId to set
     */
    public void setsLanguageId(String sLanguageId) {
    
        this.sLanguageId = sLanguageId;
    }

    
    /**
     * @param sLanguageName the sLanguageName to set
     */
    public void setsLanguageName(String sLanguageName) {
    
        this.sLanguageName = sLanguageName;
    }
    
    
    
    

}

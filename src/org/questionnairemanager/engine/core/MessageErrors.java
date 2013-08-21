/**
 * 
 */

package org.questionnairemanager.engine.core;

/**
 * Operate the all messages of error
 * 
 * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> 
 * <date>Aug 05, 2013 </date>
 */
public class MessageErrors {

    private int iCode;	// Code of message
    private String sMessage; // Message
    private boolean bIsVisible; // Is visible

    /**
     * @return the iCode
     */
    public int getiCode() {

	return iCode;
    }

    /**
     * @return the sMessage
     */
    public String getsMessage() {

	return sMessage;
    }

    /**
     * @return the bIsVisible
     */
    public boolean isbIsVisible() {

	return bIsVisible;
    }

    /**
     * @param iCode the iCode to set
     */
    public void setiCode(int iCode) {

	this.iCode = iCode;
    }

    /**
     * @param sMessage the sMessage to set
     */
    public void setsMessage(String sMessage) {

	this.sMessage = sMessage;
    }

    /**
     * @param bIsVisible the bIsVisible to set
     */
    public void setbIsVisible(boolean bIsVisible) {

	this.bIsVisible = bIsVisible;
    }

    /**
     * Constructor class
     */
    public MessageErrors(){
	this.iCode = 0;
	this.sMessage = "";
	this.bIsVisible = false;
    }
    
    /**
     * Constructor class
     * @param iCode, code of message
     * @param sMessage, text of message
     * @param bIsVisible, is visible TRUE, is not visible FALSE
     */
    public MessageErrors(int iCode, String sMessage, boolean bIsVisible) {

	this.iCode = iCode;
	this.sMessage = sMessage;
	this.bIsVisible = bIsVisible;
    }
    
    

}

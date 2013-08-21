/**
 * 
 */
package org.questionnairemanager.engine.core;


/**
 * Operate all error messages
 * @author Enner Escobedo C. <email>enner.casitllo@centrikal.com</email>
 * <date>Aug 05, 2013</date>
 *
 */
public class Errors {

    //METHODS
    private MessageErrors mMessages = new MessageErrors();
    
    
    /**
     * @return the mMessages
     */
    public MessageErrors getmMessages() {
    
        return mMessages;
    }

    
    /**
     * @param mMessages the mMessages to set
     */
    public void setmMessages(MessageErrors mMessages) {
    
        this.mMessages = mMessages;
    }

    // ATTRIBS
    public final static String MESSAGESTUDYNOTFOUND = "Studies not found!";
    public final static String MESSAGEQNOTFOUND = "Questionnaire not fund!";
    public final static String MESSAGEQGNOTFOUND = "Questionnaire group not found!";
    public final static String MESSAGEQUNOTFOUND = "Question not found!";
    public final static String MESSAGEINFOTFOUND = "Info screen not found!";
    public final static String MESSAGECHNOTFOUND = "Checkpoint not found!";
    
    /**
     * 
     */
    public Errors() {

	// TODO Auto-generated constructor stub
    }

}

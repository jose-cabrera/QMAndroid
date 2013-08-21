/**
 * 
 */
package org.questionnairemanager.engine.core;
/*
import org.questionairemanager.core.ObjectStoreUtility;
import org.questionairemanager.core.StoreObject;
*/
/**
 * Evaluates the current screen to determinate
 * the previous or next screen
 * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
 * <date>July 11, 2013</date>
 *
 */
public class Engine {
    
    /// Properties
    
    private Boolean bSubjectSelectionPending;
    private Context cContext;
    private Screen scrStartScreen;
   
    ///Methods
    
    /**
     * @return the cContextScreen
     */
    public Context getcContext() {
        return this.cContext;
    }

    /**
     * @return the bSubjectSelectionPending
     */
    public Boolean getbSubjectSelectionPending() {
        return bSubjectSelectionPending;
    }
    
    /**
     * @return the osPendingSubjectId
     */
/*    public String getOsPendingSubjectId() {
        return ObjectStoreUtility.getGUID();
    }*/
    
    /**
     * Performes initialization tasks
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 12, 2013</date>
     */
    public void getStartScreen (){

        // Get the start Screen of the Current Section
        this.scrStartScreen = this.cContext.getStarScreen();
    }
    
    /**
     * Performes finalization tasks
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 12, 2013</date>
     * @param bSequenceInterrupted, Indicates if the sequence ended due to an interruption.
     */
    public void Finish(Boolean bSequenceInterrupted){
        
        if (!bSequenceInterrupted)
            this.cContext.stkScreenStack.clear();
        else
        {
            //If the sequence was interrupted by the user...
            
            //Store the last screen used
            //TODO: TO CORRECT this.cContext.sbjCurrentSubject("SubjectLastScreenId") = this.cContext.getScrCurrentScreen();
            
        }
        
    }
    
    
}

/**
 * 
 */
package org.questionnairemanager.engine.core;

import java.util.ArrayList;

/**
 * Gets the transitions a screen can have
 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
 * <date>02/07/2013</date>
 *
 */
public class Transition {
    
    private Integer iScreenId;
    //private Integer iOrder;
    private Integer iDestinationScreenId;
    private Integer iOnTransitionProcedureId;
    private Boolean bCondition;
    
    private Screen scrDestinationScreen;


    /**
     * @return the scrDestinationScreen
     */
/*    public Screen getScrDestinationScreen() {
        
        if (scrDestinationScreen == null)
            this.scrDestinationScreen = new Screen (this.iDestinationScreenId);
        
        return this.scrDestinationScreen;
        return scrDestinationScreen;
    }*/


    /**
     * @param scrDestinationScreen the scrDestinationScreen to set
     */
    public void setScrDestinationScreen(Screen scrDestinationScreen) {
        this.scrDestinationScreen = scrDestinationScreen;
    }


    /**
     * @param iScreenId the iScreenId to set
     */
    public void setiScreenId(Integer iScreenId) {
        this.iScreenId = iScreenId;
    }


//    /**
//     * @param iOrder the iOrder to set
//     */
//    public void setiOrder(Integer iOrder) {
//        this.iOrder = iOrder;
//    }


    /**
     * @param iDestinationScreenId the iDestinationScreenId to set
     */
    public void setiDestinationScreenId(Integer iDestinationScreenId) {
        this.iDestinationScreenId = iDestinationScreenId;
    }


    /**
     * @param iOnTransitionProcedureId the iOnTransitionProcedureId to set
     */
    public void setiOnTransitionProcedureId(Integer iOnTransitionProcedureId) {
        this.iOnTransitionProcedureId = iOnTransitionProcedureId;
    }


    /**
     * @param bCondition the bCondition to set
     */
    public void setbCondition(Boolean bCondition) {
        this.bCondition = bCondition;
    }


    /**
     * Return the screen id
     * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
     * <date>02/07/2013</date>
     * @return the iScreenId, Screen id
     */
    public Integer getiScreenId() {
        return iScreenId;
    }


//    /**
//     * Return the screen order
//     * @return the iOrder, Order number
//     */
//    public Integer getiOrder() {
//        return iOrder;
//    }


    /**
     * Return Destination screen id
     * @return the iDestinationScreenId
     */
    public Integer getiDestinationScreenId() {
        return iDestinationScreenId;
    }


    /**
     * Return transition procedure Id
     * @return the iOnTransitionProcedureId
     */
    public Integer getiOnTransitionProcedureId() {
        return iOnTransitionProcedureId;
    }


    /**
     * Return condition screen
     * @return the bCondition
     */
    public Boolean getbCondition() {
        return bCondition;
    }

    
    /**
     * Get all the transitions a specific screen can have
     * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
     * <date>Jul 2, 2013</date>
     * @return listOfTransition, A list of screen transitions
     */
    public ArrayList<Object> GetAll (){
        
        ArrayList<Object> listOfTransition = null;
        
        // TODO: Get all transition on code by Julios
        
        
        
        return listOfTransition;
    }
   
    /**
     * TODO: Agregar c?digo para evaluar condici?n en la transici?n
    public Boolean EvaluateCondition(){
        
        return this.bCondition ? Evaluator.EvaluateCondition() : false;
        
    }
    
    public void ExecuteOnTransitionProcedure(){
        if (this.iOnTransitionProcedureId != null)
            Procedure.Execute(this.iOnTransitionProcedureId);
    }
     */

    /**
     * Constructor class Transition
     * @param iScreenId, Screen identifier
     //  @ param iOrder, order
     * @param iDestinationScreenId, Destination screen identifier
     * @param iOnTransitionProcedureId, on Transition procedure identifier
     * @param bCondition, Condition transition
     * @param scrDestinationScreen, Destination screen source
     */
    public Transition(Integer iScreenId, /* Integer iOrder, */ Integer iDestinationScreenId,
            Integer iOnTransitionProcedureId, Boolean bCondition, Screen scrDestinationScreen) {
        super();
        this.iScreenId = iScreenId;
        //this.iOrder = iOrder;
        this.iDestinationScreenId = iDestinationScreenId;
        
        this.bCondition = bCondition;
        this.scrDestinationScreen = scrDestinationScreen;
        
        if (iOnTransitionProcedureId == null)
            this.iOnTransitionProcedureId = null;
        else
            this.iOnTransitionProcedureId = (Integer)iOnTransitionProcedureId;
        
        if (bCondition == null)
            this.bCondition = false;
        else
            this.bCondition = (Boolean)bCondition;
    }
    

    
    
    
    
}

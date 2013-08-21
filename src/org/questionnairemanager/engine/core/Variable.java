/**
 * 
 */
package org.questionnairemanager.engine.core;

import java.util.ArrayList;

/**
 * Sets a variable values
 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
 * <date>July 04, 2013</date>
 */
public class Variable {
    
    private String sVariableName;
    private String sDataType;
    private String sMainText;
    private String sHelpText;
    private Boolean bIsRequired;
    private String sAbsMin;
    private String sAbsMax;
    private String sPromptUnder;
    private String sPromptOver;
    private String sLegalValueTable;
    
    /**
     * @return the sVariableName
     */
    public String getsVariableName() {
        return sVariableName;
    }
    
    /**
     * @return the sDataType
     */
    public String getsDataType() {
        return sDataType;
    }
    
    /**
     * @return the sMainText
     */
    public String getsMainText() {
        return sMainText;
    }
    /**
     * @return the sHelpText
     */
    public String getsHelpText() {
        return sHelpText;
    }
    /**
     * @return the bIsRequired
     */
    public Boolean getbIsRequired() {
        return bIsRequired;
    }
    /**
     * @return the sAbsMin
     */
    public String getsAbsMin() {
        return sAbsMin;
    }
    
    /**
     * @return the sAbsMax
     */
    public String getsAbsMax() {
        return sAbsMax;
    }
    
    /**
     * @return the sPromptUnder
     */
    public String getsPromptUnder() {
        return sPromptUnder;
    }
    
    /**
     * @return the sPromptOver
     */
    public String getsPromptOver() {
        return sPromptOver;
    }
    
    /**
     * @return the sLegalValueTable
     */
    public String getsLegalValueTable() {
        return sLegalValueTable;
    }
    
    /**
     * Class constructor Variable
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 04, 2013</date>
     * @param sVariableName, variable name
     */
    public Variable (String sVariableName){
        
        ArrayList<Variable> alVarNames = null; // TODO: get data DA.Variable.GetSingle (variableName)
        
        PopulateProperties (alVarNames);
    }

    /**
     * Populate properties of class Variable
     * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
     * <date>Jul 4, 2013</date>
     * @param alVarNames, Array list with variable names
     */
    private void PopulateProperties(ArrayList<Variable> alVarNames) {
        // TODO Auto-generated method stub
        for (Variable oVariableName : alVarNames){
            this.sVariableName = oVariableName.getsVariableName();
            this.sDataType = oVariableName.getsDataType();
            
            //.
            //.
            //.
            
        }
        
    }
    
    /**
     * Indicates if a variable with the specified identifier exists
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 8, 2013</date>
     * @param sVariableName, Name of the variable
     * @return true if the variable exists, FALSE otherwise.
     */
    public Boolean Exists (String sVariableName){
        return true;
        // DA.Variable.Exits(sVariableName);
    }
    
    
    

}

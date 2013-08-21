/**
 * 
 */
package org.questionnairemanager.engine.core;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Represents a Screen to be displayed in a Questionnaire
 * Provide access to the properties and methods that rule
 * the behavior of the screen
 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
 * <date>Jul 05, 2013</date>
 *
 */
public class Screen {


    // Static data
    // QUESTIONNAIRE TYPE = 1
    // GROUP TYPE = 2
    public enum VariableScopeType {
        QUESTIONNAIRE (1),
        GROUP (2);
        
        private Integer iValue;
        
        VariableScopeType (Integer pValue){
            this.iValue = pValue;
        }
        
        public Integer getValue() {
            return iValue; 
        } 
    }

    
    //private variables
    private Integer iScreenId; 
    private Integer iGroupId;
    private String sName;
    private String sType;
    private String sNumber;
    private Integer iScreenTemplateId;
    private String sArguments;
    private Integer iVariableScope;
    private String sVariableName;
    private String sDataType; 
    
    private String sMainText;
    private String sMainTextColor;
    private String sOtherText1;
    private String sOtherText1Color;
    private String sOtherText2;
    private String sOtherText2Color;
    private String sOtherText3;
    private String sOtherText3Color;
    private String sHelpText;
    
    private boolean bRequired;
    private boolean bAbsAdmin;
    private boolean bAbsMax;
    private boolean bPromptUnder;
    private boolean bPromptOver;
    
    private String sLegalValueTable;
    private boolean bCustomValidation;
    private String sCustomValidationFailMessage;
    private boolean bOnChange;
    private boolean bOnLoad;
    private boolean bOnUnload;
    private boolean bConfirmChange;
    private boolean bHideNext;
    private boolean bHideBack;
    private boolean bConfirmNext;
    private boolean bConfirmBack;
    
    private ScreenTemplate scrtemScreenTemplate;
    private Variable vVariable;
    
    private ArrayList<Transition> alTransitions;
    
    private HashMap hmArgumentsDictionary;
    

    /**
     * @return the questionnaire
     */
    public static VariableScopeType getQuestionnaire() {
        return VariableScopeType.QUESTIONNAIRE;
    }
    
    /**
     * @return the section
     */
    public static VariableScopeType getSection() {
        return VariableScopeType.GROUP;
    }
    
    /**
     * @return the iScreenId
     */
    public Integer getiScreenId() {
        return iScreenId;
    }
    /**
     * @return the iSectionId
     */
    public Integer getiSectionId() {
        return iGroupId;
    }
    /**
     * @return the sName
     */
    public String getsName() {
        return sName;
    }
    /**
     * @return the sType
     */
    public String getsType() {
        return sType;
    }
    
    /**
     * @return the sNumber
     */
    public String getsNumber() {
        return sNumber;
    }

    /**
     * @return the iScreenTemplateId
     */
    public Integer getiScreenTemplateId() {
        return iScreenTemplateId;
    }
    /**
     * @return the sArguments
     */
    public String getsArguments() {
        return sArguments;
    }
    /**
     * @return the iVariableScope
     */
    public Integer getiVariableScope() {
        return iVariableScope;
    }
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
     * @return the sMainTextColor
     */
    public String getsMainTextColor() {
        return sMainTextColor;
    }
    /**
     * @return the sOtherText1
     */
    public String getsOtherText1() {
        return sOtherText1;
    }
    /**
     * @return the sOtherText1Color
     */
    public String getsOtherText1Color() {
        return sOtherText1Color;
    }
    /**
     * @return the sOtherText2
     */
    public String getsOtherText2() {
        return sOtherText2;
    }
    /**
     * @return the sOtherText2Color
     */
    public String getsOtherText2Color() {
        return sOtherText2Color;
    }
    /**
     * @return the sOtherText3
     */
    public String getsOtherText3() {
        return sOtherText3;
    }
    /**
     * @return the sOtherText3Color
     */
    public String getsOtherText3Color() {
        return sOtherText3Color;
    }
    /**
     * @return the sHelpText
     */
    public String getsHelpText() {
        return sHelpText;
    }
    /**
     * @return the bRequired
     */
    public boolean isbRequired() {
        return bRequired;
    }
    /**
     * @return the bAbsAdmin
     */
    public boolean isbAbsAdmin() {
        return bAbsAdmin;
    }
    /**
     * @return the bAbsMax
     */
    public boolean isbAbsMax() {
        return bAbsMax;
    }
    /**
     * @return the bPromptUnder
     */
    public boolean isbPromptUnder() {
        return bPromptUnder;
    }
    /**
     * @return the bPromptOver
     */
    public boolean isbPromptOver() {
        return bPromptOver;
    }
    /**
     * @return the sLegalValueTable
     */
    public String getsLegalValueTable() {
        return sLegalValueTable;
    }
    /**
     * @return the bCustomValidation
     */
    public boolean isbCustomValidation() {
        return bCustomValidation;
    }
    /**
     * @return the sCustomValidationFailMessage
     */
    public String getsCustomValidationFailMessage() {
        return sCustomValidationFailMessage;
    }
    /**
     * @return the bOnChange
     */
    public boolean isbOnChange() {
        return bOnChange;
    }
    /**
     * @return the bOnLoad
     */
    public boolean isbOnLoad() {
        return bOnLoad;
    }
    /**
     * @return the bOnUnload
     */
    public boolean isbOnUnload() {
        return bOnUnload;
    }
    /**
     * @return the bConfirmChange
     */
    public boolean isbConfirmChange() {
        return bConfirmChange;
    }
    /**
     * @return the bHideNext
     */
    public boolean isbHideNext() {
        return bHideNext;
    }
    /**
     * @return the bHideBack
     */
    public boolean isbHideBack() {
        return bHideBack;
    }
    /**
     * @return the bConfirmNext
     */
    public boolean isbConfirmNext() {
        return bConfirmNext;
    }
    /**
     * @return the bConfirmBack
     */
    public boolean isbConfirmBack() {
        return bConfirmBack;
    }
    /**
     * @return the scrtemScreenTemplate
     */
    public ScreenTemplate getScrtemScreenTemplate() {
        return scrtemScreenTemplate;
    }
    
    /**
     * Get the data of Variable
     * @return the vVariable
     */
    public Variable getvVariable() {
        //return vVariable;
        if (this.vVariable == null ){
            if ((this.sVariableName == "") && (this.vVariable.Exists(this.sVariableName))){
                this.vVariable = new Variable (this.sVariableName);
            }
        }
        
        return this.vVariable;
    }
    /**
     * @return the alTransitions
     */
    public ArrayList<Transition> getAlTransitions() {
        return alTransitions;
    }
    
    /**
     * This property expect to find an arguments string in the _arguments field
     * of the following form: key1=value1; key2=value2; key3=value3
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>15/07/2013</date>
     * @return the hmArgumentsDictionary
     */
    @SuppressWarnings("rawtypes")
    public HashMap getHmArgumentsDictionary(String hmArgumentToSearch) {
        if (this.hmArgumentsDictionary.isEmpty())
            return null;
        else
            return  (HashMap)this.hmArgumentsDictionary.get(hmArgumentToSearch);
    }
    
    public Integer getScreen (Integer pScreenId){
        //Obtener informaci?n de la pantalla de la base de datos
        // DataRow = DA.Screen.GetSingle (pScreenId)
        // Get data with class StoreObject DAL
        return pScreenId;
    }
    
    
    /**
     * Replace old number with the new number
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 10, 2013</date>
     * @param sOldChar, old number
     * @param sNewChar, new number
     */
    public String replaceNumber (String sOldChar, String sNewChar){
        this.sNumber.replace(sOldChar, sNewChar);
        
        return this.getsNumber();
    }
    
    
    /**
     * Get an array list with the items in the Legal VAlue list for this Screen
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 8, 2013</date>
     * @return ArrayList<String> Data to return
     */
    public ArrayList<String> getLegalValueListItems (){
        HashMap hmFilterVariableName;
        String sFilterVariableValue = null;
        String sFilterVariableData;
        ArrayList<String> alDataToReturn = null;
        
        //Obtiene el valor y el key del Hashmap
        hmFilterVariableName = this.getHmArgumentsDictionary("filterVariable");
        
        sFilterVariableData = hmFilterVariableName.toString();
        
        //sFilterVariableValue = hmFilterVariableName.values();
        
        //return (ArrayList<String>) sFilterVariableValue;
        
        if (hmFilterVariableName.isEmpty()){
            //Verificar si existe en:
            //CurrentSection.DataRecord
            //CurrentQuestionnaire
            //CurrentSubject
            //else, error
            
        }
        
        if (sFilterVariableValue == "")
            return null;
        else{
            
            //Debe retornar DA.Common.GetLegalValueTableItems (LevalValueTable, filterVariableValue)
            return alDataToReturn;
        }
        
    }
    
    /**
     * Inserts a new item into a Legal Value TAble
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 8, 2013</date>
     * @param pTable, The name of the legal value table.
     * @param pValue, The value for the new item
     * @param pOrder, The order for the new item
     * @param sText, The text for the new item
     * @param pShortName, The short name for the new item
     * @param pGroup, The group for the new item
     */
    public void insLegalValueTableItem (String pTable, Integer pValue, Integer pOrder, String sText, String pShortName, String pGroup){
        
        // Realiza la inserci?n en la tabla
        //DA.Common.InsertLegalValueTableItem (table, value, order, text, shortname, group);
    }
    

    
    /**
     * Gets the value of the Variable that this Screen access.
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 8, 2013</date>
     * @param pVariableName, Variable name
     * @return Object, with data to fill Screen
     */
    public Object getInitialValue (String pVariableName){
        if (pVariableName == null)
            return null;
        else {
            
                if (this.getiVariableScope() == VariableScopeType.QUESTIONNAIRE.getValue())
                        return VariableScopeType.values();
                        //Context.CurrentSection(pVariableName) , add to 2 
              
                   
                if (this.getiVariableScope() == VariableScopeType.GROUP.getValue())
                    return VariableScopeType.values();
                        // return Context.CurrentQuestionnaire (pVariableName)
                
            }
            return pVariableName;
            
        }
    
    /**
     * Gets the value of the Variable that this Screen access
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 8, 2013</date>
     * @return An object if there is a value, Nothing otherwise.
     */
    public Object getInitialValue (){
        return getInitialValue(this.sVariableName);
    }
    
    /**
     * Stores the value thtat the user provided in the Variable thtat this Screen access.
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 8, 2013</date>
     * @param oValue, The value to store in the Variable
     */
    public void StoreValue (Object oValue){
        StoreValue (this.sVariableName, oValue);
    }
    
    
    /**
     * Stores the value that the user provided in the specified Variable
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 8, 2013</date>
     * @param sVariableName, The name of the variable
     * @param oValue, The value to store in the Variable.
     */
    public void StoreValue (String sVariableName, Object oValue){
        if (sVariableName == "" || vVariable.Exists(sVariableName)){
           return;
        }
        
        if (this.getiVariableScope() == VariableScopeType.QUESTIONNAIRE.getValue())
            return;
            //Context.CurrentQuestionnaire = oValue;
  
       
    /*if (this.getiVariableScope() == VariableScopeType.SECTION.getValue())
        return;
        //return VariableScopeType.values();
            // return Context.CurrentSection  = oValue;
*/    
    
/*    if (this.getiVariableScope() == VariableScopeType.SUBJECT.getValue())
        return;
        //return VariableScopeType.values();
        // return Context.CurrentSubject = oValue;
    }*/
    
    /**
     * Evaluates the custom validation and returns the result
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 8, 2013</date>
     * @param oInputValue, The user input in the screen
     * @return Boolean, The result of the evaluation of the External Validation
     */
//    public Boolean EvaluateCondition (Object oInputValue){
//        
//        if (this.bCustomValidation){
//            return false;
//            // return (Boolean)EvaluateFunction(Context.ConditionsDotNetClassName, "Condition" & Context.MethodNameSufix, Boolean, Nothing);
//        }
//        else
//            return true;
//        
//    }
    
    /**
     * Locates and executes the specified Method
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 8, 2013</date>
     * @param sMehotdName, Name of method
     * @param oParameters, Parameters to Evaluate
     * @return The logical (true/false) result of the evaluation.
     */
//    public Boolean EvaluateCondition(String sMehotdName, Object oParameters){
//        
//        MethodClass mMethod = null;
//        Object oResult = mMethod.(oParameters);
//    }
    
    
/*    //TODO: Add for the next
    public Boolean EvaluateCustomValidation (Object oInputValue){
        if (this.bCustomValidation){
            
            //TODO: Evaluator.EvaluateFunction (Context.ValidationsDotNetClassName, "CustomValidation" & Context.MethodNameSufix, TypeCode.Boolean, New Object(){inputValue}))
            
            
            return true;
        }
        
        return false;
    }*/
    
/*    public void ExecuteOnChangeProcedure (){
        
        if (this.bOnChange){
            Procedure.Execute(Context.EventsDotNetClassName, "OnChange" & Context.MethodNameSufix, Nothing);
            
        }
        
        
    }
    */
    
    
    }  
}

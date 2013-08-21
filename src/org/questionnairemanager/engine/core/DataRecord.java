/**
 * 
 */
package org.questionnairemanager.engine.core;
//import org.questionairemanager.core.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

/**
 * Class generate data record
 * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
 * <date>Jul 04, 2013</date>
 *
 */
public class DataRecord {
    
    //Attributes
    private Byte bSubjectQuesstionnaireInstanceId;
    private String sDataTableName;
    private HashMap dctValues; 
    private Boolean bGhostRecord;
    private String sGuid;
    
    
    // Methods Get and Set
    public String getsSubjectId (){
        return sGuid;
    }
    
    /**
     * @return the bSubjectQuesstionnaireInstanceId
     */
    public Byte getbSubjectQuesstionnaireInstanceId() {
        return bSubjectQuesstionnaireInstanceId;
    }
    
    
    // Constructor
    
    /**
     * Constructor or data record in Memory
     * @param sDataTableName
     * @param bSubjectQuestionnaireInstanceId
     * @param dctInitialValues
     */
    public DataRecord(String sDataTableName, Byte bSubjectQuestionnaireInstanceId) {
        // TODO Auto-generated constructor stub
        // TODO: row = DA.Data.GetRecord(dataTableName, subjectid, subjectQuestionnaireInstanceid)
        
        /// If row is nothing >> applicationexception
        this.sDataTableName = sDataTableName;
        this.bSubjectQuesstionnaireInstanceId = bSubjectQuestionnaireInstanceId;
        //TODO: Se obtiene de la base de datos, campo "PDALastModifDate"
        this.bGhostRecord = false;
        
        //sGuid = ObjectStoreUtility.getGUID();
    }

    
    

    // Methods
    
    /**
     * @return the sDataTableName
     */
    public String getsDataTableName() {
        return sDataTableName;
    }

    /**
     * Add an item to hashmap with the value indicated
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 11, 2013</date>
     * @param sName, key
     * @param oValue, value to add
     */
    @SuppressWarnings("rawtypes")
    public void setDctValues(String sName, Object oValue){
        
        // If the field does'n exists, throw an exception
        if (!(this.dctValues.containsKey(sName))){
            
            //TODO: ERROR the field does not exists in the data table
            
            
        }
        else{
            if (this.dctValues.containsKey(sName)){
                this.dctValues.put(sName.toString(), oValue);
                
                //TODO:update data
                //DA.DATA.updaterecord(datatablename, subjectid, subjectQu, Name, value, cu.pdausername, cs.version, pdaserial, pdaname
                this.bGhostRecord = false;
            }
        }
    }
    
    /**
     * Get the value of the hash map
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 11, 2013</date>
     * @param sName, key to search
     * @return Object with the value to evaluate
     */
    public Object getDctValue(String sName){
        
        return this.dctValues.get(sName);
    }
    
    /**
     * Get the hashtable of the all values
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 11, 2013</date>
     * @return HashMap with the all values
     */
    @SuppressWarnings("rawtypes")
    public HashMap getDctValues(){
        return this.dctValues;
    }
    
    public Boolean VariableExists (String sVariableName){
        return (Boolean) this.dctValues.get(sVariableName);
    }
    
    /**
     * Create dictionary of DataRecord with HashMap
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 12, 2013</date>
     * @param sDataTableName, Name of table
     * @param bSubjectQuestionnaireInstanceId, Id of subject questionnaire instance id
     * @param dctInitialValues, inital values of hashmap
     * @return DataRecord object with all information.
     */
    public Object DrCreate (String sDataTableName, Byte bSubjectQuestionnaireInstanceId, HashMap dctInitialValues){
        
        //TODO: Add Data to Record
        //DA.Data.CreateRecord(dataTableName, subjectId, subjectQuestionnaireInstanceId,
        // initialValues, CurrentUser.PdaUserName, CurrentStudy.Version, PdaSerialNumber, PdaName)
        
        
        
        return new DataRecord(sDataTableName, bSubjectQuestionnaireInstanceId);
    }
    
    
    public void PopulateProperties (ArrayList <String> alRow){
        
        this.dctValues = null;
        // TODO: Add two elements
        
    }
    
   /* public DataRecord (String sDataTableName, StoreObject soSubjectId, Byte bSubjectQuestionnaireInstanceId){
        
        // Get the elements to the DataBAse
        // TODO: 
        //ArrayList<Object> alDataRow = DA.Data.GetRecord(sDataTableName, bSubjectQuestionnaireInstanceId);
        
        
        // Add the elements to this object
        //this.sDataTableName = name;
    }*/
}

/**
 * 
 */
package org.questionnairemanager.engine.core;

/*import org.questionairemanager.core.ObjectStoreUtility;
import org.questionairemanager.core.StoreObject;*/

/**
 * Represets the Subject of a studey
 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
 * <date>02 July, 2013 </date>
 *
 */
public class Subject {
    
    /**
     * Traslado enum
     */
    
    //private Guid gSubjectId;
    private DataRecord drDataRecord;
    private Site stSite;
    private QuestionnaireSet qsQuestionnaireSet;
    
    
    /**
     * @author Enner Escobedo C. <email>enner.castillo@centrikalcom</email>
     * <date>Jul, 12 2013</date>
     * @return the gSubjectId (GUID)
     */
/*    public String getSubjectId() {
        return ObjectStoreUtility.getGUID();
    }*/
    
    /**
     * @return the drDataRecord
     */
    public DataRecord getDrDataRecord() {
        return drDataRecord;
    }
    
    /**
     * @return the stSite
     */
    public Site getStSite() {
        return stSite;
    }
    
    /**
     * @return the qsQuestionnaireSet
     */
    public QuestionnaireSet getQsQuestionnaireSet() {
        return qsQuestionnaireSet;
    }
    
    
    
    

}

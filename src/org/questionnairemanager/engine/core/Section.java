/**
 * 
 */
package org.questionnairemanager.engine.core;

/**
 * Represents a Section of a Questionnaire
 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
 * <date>03/07/2013</date>
 *
 */
public class Section {
    
    private Integer iSectionId;
    private Integer iQuestionnaireId;
    private Integer iOrder;
    private Integer iStartScreenId;
    private Integer iExitScreenId;
    private Boolean bModifiable;
    private String sShortName;
    private String sNameSection;
    
    private Boolean bPreCondition;
    private Boolean bOnNewRecord;
    
    private Screen scrStartScreen;
    private Screen scrExitScreen;
    private String sDataTableName;
    private DataRecord drDataRecord;
    
    
    /**
     * @return the iSectionId
     */
    public Integer getiSectionId() {
        return iSectionId;
    }
    
    /**
     * @return the iQuestionnaireId
     */
    public Integer getiQuestionnaireId() {
        return iQuestionnaireId;
    }
    
    /**
     * @return the iOrder
     */
    public Integer getiOrder() {
        return iOrder;
    }
    
    /**
     * @return the iStartScreenId
     */
    public Integer getiStartScreenId() {
        return iStartScreenId;
    }
    
    /**
     * @return the iExitScreenId
     */
    public Integer getiExitScreenId() {
        return iExitScreenId;
    }
    
    /**
     * @return the bModifiable
     */
    public Boolean getbModifiable() {
        return bModifiable;
    }
    
    /**
     * @return the sShortName
     */
    public String getsShortName() {
        return sShortName;
    }
    
    /**
     * @return the sNameSection
     */
    public String getsNameSection() {
        return sNameSection;
    }
    
    /**
     * @return the scrStartScreen
     */
    public Screen getScrStartScreen() {
        return scrStartScreen;
    }
    
    /**
     * @return the scrExitScreen
     */
    public Screen getScrExitScreen() {
        return scrExitScreen;
    }
    
    /**
     * 
     * 
     * @author ennercastillo <email>eriec.42@gmail.com</email>
     * <date>Jul 3, 2013</date>
     * @return
     */
    public Boolean HasRecord(){
        return bModifiable;
        
        // TODO: Pendiente agregar la informaci?n del datarecord
        
    }
    
    public Boolean IsComplete (){
        return bModifiable;
        
    }

}

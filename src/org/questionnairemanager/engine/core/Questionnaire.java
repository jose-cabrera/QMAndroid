/**
 * 
 */

package org.questionnairemanager.engine.core;

import java.util.ArrayList;

/**
 * @author ennercastillo
 */
public class Questionnaire extends Node {

    private String sQuestionnaireGuid; // GUID Questionnaire
    private String sShortName; // Name of Questionnaire
    private String sOnNew; // On new
    private Boolean bModifiable;
    private Boolean bMultipleInstance;

    private String sMultipleInstanceAbsMin;
    private String sMultipleInstanceAbsMax;
    private String sMultipleInstancePromptUnder;
    private String sMultipleInstancePromptOver;

    private String sSearchVariables;
    private String sConfirmVariables;

    private Boolean bRequired;
    private String sUnique;

    private ArrayList<Question> alQuestions;

    // Screens this questionnaire
    private ArrayList<Screen> alScreens;

    /**
     * @return the alScreens
     */
    public ArrayList<Screen> getAlScreens() {

	return alScreens;
    }

    /**
     * @return the sQuestionnaireGuid
     */
    public String getsQuestionnaireGuid() {

	return sQuestionnaireGuid;
    }

    /**
     * @return the sShortName
     */
    public String getsShortName() {

	return sShortName;
    }

    /**
     * @return the sOnNew
     */
    public String getsOnNew() {

	return sOnNew;
    }

    /**
     * @return the bModifiable
     */
    public Boolean getbModifiable() {

	return bModifiable;
    }

    /**
     * @return the sMultipleInstance
     */
    public Boolean getbMultipleInstance() {

	return bMultipleInstance;
    }

    /**
     * @return the sMultipleInstanceAbsMin
     */
    public String getsMultipleInstanceAbsMin() {

	return sMultipleInstanceAbsMin;
    }

    /**
     * @return the sMultipleInstanceAbsMax
     */
    public String getsMultipleInstanceAbsMax() {

	return sMultipleInstanceAbsMax;
    }

    /**
     * @return the sMultipleInstancePromptUnder
     */
    public String getsMultipleInstancePromptUnder() {

	return sMultipleInstancePromptUnder;
    }

    /**
     * @return the sMultipleInstancePromptOver
     */
    public String getsMultipleInstancePromptOver() {

	return sMultipleInstancePromptOver;
    }

    /**
     * @return the sSearchVariables
     */
    public String getsSearchVariables() {

	return sSearchVariables;
    }

    /**
     * @return the bConfirmVariables
     */
    public String getsConfirmVariables() {

	return sConfirmVariables;
    }

    /**
     * @return the bRequired
     */
    public Boolean getbRequired() {

	return bRequired;
    }

    /**
     * @return the unique
     */
    public String getsUnique() {

	return sUnique;
    }

    /**
     * @return the alQuestions
     */
    public ArrayList<Question> getAlQuestions() {

	return alQuestions;
    }

    /**
     * Add questions to this questionnaire
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>13/08/2013</date>
     * @param alQuestions, array list of questions for this questionnaire
     */
    public void setAlQuestions(ArrayList<Question> alQuestions) {

	if (this.alQuestions.isEmpty()) this.alQuestions = new ArrayList<Question>();

	this.alQuestions = alQuestions;
    }

    /**
     * Constructor class
     */
    public Questionnaire() {

	this.sQuestionnaireGuid = "";
	this.sShortName = "";
	this.sOnNew = "";
	this.bModifiable = false;
	this.bMultipleInstance = false;
	this.sMultipleInstanceAbsMin = "";
	this.sMultipleInstanceAbsMax = "";
	this.sMultipleInstancePromptUnder = "";
	this.sMultipleInstancePromptOver = "";
	this.sSearchVariables = "";
	this.sConfirmVariables = "";
	this.bRequired = false;
	this.sUnique = "";
    }

    /**
     * @param sQuestionnaireGuid
     * @param sShortName
     * @param sOnNew
     * @param bModifiable
     * @param bMultipleInstance
     * @param sMultipleInstanceAbsMin
     * @param sMultipleInstanceAbsMax
     * @param sMultipleInstancePromptUnder
     * @param sMultipleInstancePromptOver
     * @param sSearchVariables
     * @param sConfirmVariables
     * @param bRequired
     * @param sUnique
     */
    public Questionnaire(Node nData, String sQuestionnaireGuid, String sShortName, String sOnNew, Boolean bModifiable, Boolean bMultipleInstance,
	    String sMultipleInstanceAbsMin, String sMultipleInstanceAbsMax, String sMultipleInstancePromptUnder, String sMultipleInstancePromptOver,
	    String sSearchVariables, String sConfirmVariables, Boolean bRequired, String sUnique) {

	super(nData);
	this.sQuestionnaireGuid = sQuestionnaireGuid;
	this.sShortName = sShortName;
	this.sOnNew = sOnNew;
	this.bModifiable = bModifiable;
	this.bMultipleInstance = bMultipleInstance;
	this.sMultipleInstanceAbsMin = sMultipleInstanceAbsMin;
	this.sMultipleInstanceAbsMax = sMultipleInstanceAbsMax;
	this.sMultipleInstancePromptUnder = sMultipleInstancePromptUnder;
	this.sMultipleInstancePromptOver = sMultipleInstancePromptOver;
	this.sSearchVariables = sSearchVariables;
	this.sConfirmVariables = sConfirmVariables;
	this.bRequired = bRequired;
	this.sUnique = sUnique;

    }

    /**
     * Show the information for Questionnaire
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>14/08/2013</date>
     */
    public void ShowInformation() {

	this.PrintNodeInformation();

	System.out.println("questionnaire guid" + this.getsQuestionnaireGuid());
	System.out.println("short name " + this.getsShortName());
	System.out.println("s on new" + this.getsOnNew());
	System.out.println("is modifiable " + this.getbModifiable());
	System.out.println("is absmin " + this.getsMultipleInstanceAbsMin());
	System.out.println("is absmax " + this.getsMultipleInstanceAbsMax());
	System.out.println("prompt under " + this.getsMultipleInstancePromptUnder());
	System.out.println("prompt over " + this.getsMultipleInstancePromptOver());
	System.out.println("search variable" + this.getsSearchVariables());
	System.out.println("confirm var " + this.getsConfirmVariables());
	System.out.println("is required " + this.getbRequired());
	System.out.println("unique " + this.getsUnique());
    }

    public String getsOrdinal() {

	String hola = null;

	return hola;
    }

}

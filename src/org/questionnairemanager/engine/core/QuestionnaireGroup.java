/**
 * 
 */

package org.questionnairemanager.engine.core;

/**
 * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>Aug 14, 2013</date>
 */
public class QuestionnaireGroup extends Node {

    private String iQuestionnaireGroupGuid;
    private Boolean bSorted;
    private Boolean bExclusive;
    private String sCompleteness;
    private Boolean bMultipleInstance;
    private String sMultipleInstanceAbsMin;
    private String sMultipleInstanceAbsMax;
    private String sMultipleInstancePromptUnder;
    private String sMultipleInstancePromptOver;
    private String sSearchVariables;
    private String sConfirmVariables;
    private Boolean bRequired;

    /**
     * @return the iQuestionnaireGroupGuid
     */
    public String getiQuestionnaireGroupGuid() {

	return iQuestionnaireGroupGuid;
    }

    /**
     * @return the bSorted
     */
    public Boolean getbSorted() {

	return bSorted;
    }

    /**
     * @return the exclusive
     */
    public Boolean getbExclusive() {

	return bExclusive;
    }

    /**
     * @return the sCompleteness
     */
    public String getsCompleteness() {

	return sCompleteness;
    }

    /**
     * @return the bMultipleInstance
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
     * @return the sConfirmVariables
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
     * Constructor class
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>Aug 14, 2013</date>
     */
    public QuestionnaireGroup() {

    }

    /**
     * Constructor class with data
     * 
     * @param iQuestionnaireGroupGuid
     * @param bSorted
     * @param exclusive
     * @param sCompleteness
     * @param bMultipleInstance
     * @param sMultipleInstanceAbsMin
     * @param sMultipleInstanceAbsMax
     * @param sMultipleInstancePromptUnder
     * @param sMultipleInstancePromptOver
     * @param sSearchVariables
     * @param sConfirmVariables
     * @param bRequired
     */
    public QuestionnaireGroup(Node nData, String iQuestionnaireGroupGuid, Boolean bSorted, Boolean exclusive, String sCompleteness, Boolean bMultipleInstance,
	    String sMultipleInstanceAbsMin, String sMultipleInstanceAbsMax, String sMultipleInstancePromptUnder, String sMultipleInstancePromptOver,
	    String sSearchVariables, String sConfirmVariables, Boolean bRequired) {

	super(nData);

	this.iQuestionnaireGroupGuid = iQuestionnaireGroupGuid;
	this.bSorted = bSorted;
	this.bExclusive = exclusive;
	this.sCompleteness = sCompleteness;
	this.bMultipleInstance = bMultipleInstance;
	this.sMultipleInstanceAbsMin = sMultipleInstanceAbsMin;
	this.sMultipleInstanceAbsMax = sMultipleInstanceAbsMax;
	this.sMultipleInstancePromptUnder = sMultipleInstancePromptUnder;
	this.sMultipleInstancePromptOver = sMultipleInstancePromptOver;
	this.sSearchVariables = sSearchVariables;
	this.sConfirmVariables = sConfirmVariables;
	this.bRequired = bRequired;
    }

    /**
     * Show all information for this Questionnaire Group
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>14/08/2013</date>
     */
    public void ShowInformation() {

	super.PrintNodeInformation();

	System.out.println("qg guid" + this.getiQuestionnaireGroupGuid());
	System.out.println("sorted " + this.getbSorted());
	System.out.println("exclusive " + this.getbExclusive());
	System.out.println("completness " + this.getsCompleteness());
	System.out.println("multiple instance" + this.getbMultipleInstance());
	System.out.println("abs min" + this.getsMultipleInstanceAbsMin());
	System.out.println("abs max" + this.getsMultipleInstanceAbsMax());
	System.out.println("prompt under" + this.getsMultipleInstancePromptUnder());
	System.out.println("prompt over " + this.getsMultipleInstancePromptOver());
	System.out.println("search variable " + this.getsSearchVariables());
	System.out.println("confirm var " + this.getsConfirmVariables());
	System.out.println("required " + this.getbRequired());
    }

}

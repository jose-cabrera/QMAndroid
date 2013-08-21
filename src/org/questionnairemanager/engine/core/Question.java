
package org.questionnairemanager.engine.core;

public class Question extends Node {

    private String sQuestionGuid;	// Guid de Question
    private String sLegalValueTableGuid;	// Guid del legal value table, para cuando son elementos del tipo RADIOBUTTON, CHECKBOX Y DROPDOWN
    // Solo con los anteriores es requeridos, else debe ser null
    private String sVariableName;		// Nombre de la variable
    private String sScreenTemplateGuid;		// valor del elemento a buscar en el Screen Template
    private String sArguments;			// Argumentos
    private Boolean bRequired;
    private String sAbsMin;
    private String sAbsMax;
    private String sPromptUnder;
    private String sPromptOver;
    private String sCustomValidationExpressionGuid;
    private String sOnChange;
    private String sUnique;

    // Elementos agregados!
    private String sMainText;	// Se trae del diccionario
    private String sHelpText;	// Se trae del diccionario

    /**
     * @return the sQuestionGuid
     */
    public String getsQuestionGuid() {

	return sQuestionGuid;
    }

    /**
     * @return the sLegalValueTableGuid
     */
    public String getsLegalValueTableGuid() {

	return sLegalValueTableGuid;
    }

    /**
     * @return the sScreenTemplateGuid
     */
    public String getsScreenTemplateGuid() {

	return sScreenTemplateGuid;
    }

    /**
     * @return the sArguments
     */
    public String getsArguments() {

	return sArguments;
    }

    /**
     * @return the bRequired
     */
    public Boolean getbRequired() {

	return bRequired;
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
     * @return the sCustomValidationExpressionGuid
     */
    public String getsCustomValidationExpressionGuid() {

	return sCustomValidationExpressionGuid;
    }

    /**
     * @return the sOnChange
     */
    public String getsOnChange() {

	return sOnChange;
    }

    /**
     * @return the sUnique
     */
    public String getsUnique() {

	return sUnique;
    }

    /**
     * @return the sVariableName
     */
    public String getsVariableName() {

	return sVariableName;
    }

    /**
     * Constructor without data
     */
    public Question() {

	this.sQuestionGuid = "";
	this.sLegalValueTableGuid = "";
	this.sScreenTemplateGuid = "";
	this.sArguments = "";
	this.bRequired = false;
	this.sAbsMin = "";
	this.sAbsMax = "";
	this.sPromptUnder = "";
	this.sPromptOver = "";
	this.sCustomValidationExpressionGuid = "";
	this.sOnChange = "";
	this.sUnique = "";
	this.sVariableName = "";

    }

    /**
     * Constructor with data
     * 
     * @param sQuestionGuid
     * @param sLegalValueTableGuid
     * @param sVariableName
     * @param sScreenTemplateGuid
     * @param sArguments
     * @param bRequired
     * @param sAbsMin
     * @param sAbsMax
     * @param sPromptUnder
     * @param sPromptOver
     * @param sCustomValidationExpressionGuid
     * @param sOnChange
     * @param sUnique
     */
    public Question(Node nData, String sQuestionGuid, String sLegalValueTableGuid, String sVariableName, String sScreenTemplateGuid, String sArguments,
	    Boolean bRequired, String sAbsMin, String sAbsMax, String sPromptUnder, String sPromptOver, String sCustomValidationExpressionGuid,
	    String sOnChange, String sUnique) {

	super(nData);
	this.sQuestionGuid = sQuestionGuid;
	this.sLegalValueTableGuid = sLegalValueTableGuid;
	this.sVariableName = sVariableName;
	this.sScreenTemplateGuid = sScreenTemplateGuid;
	this.sArguments = sArguments;
	this.bRequired = bRequired;
	this.sAbsMin = sAbsMin;
	this.sAbsMax = sAbsMax;
	this.sPromptUnder = sPromptUnder;
	this.sPromptOver = sPromptOver;
	this.sCustomValidationExpressionGuid = sCustomValidationExpressionGuid;
	this.sOnChange = sOnChange;
	this.sUnique = sUnique;
    }

    /**
     * Show the all information of question
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>16/08/2013</date>
     */
    public void ShowInformation() {

	super.PrintNodeInformation();
	System.out.println("question guid" + this.getsQuestionGuid());
	System.out.println("guid lvt " + this.getsLegalValueTableGuid());
	System.out.println("var name " + this.getsVariableName());
	System.out.println("stguid " + this.getsScreenTemplateGuid());
	System.out.println("arguments " + this.getsArguments());
	System.out.println("b required " + this.getbRequired());
	System.out.println("abs main " + this.getsAbsMin());
	System.out.println("abs max " + this.getsAbsMax());
	System.out.println("prompt under " + this.getsPromptUnder());
	System.out.println("prompt over " + this.getsPromptOver());
	System.out.println("custom validation " + this.getsCustomValidationExpressionGuid());
	System.out.println("on change " + this.getsOnChange());
	System.out.println("is unique " + this.getsUnique());
    }
}

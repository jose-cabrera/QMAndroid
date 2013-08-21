/**
 * 
 */

package org.questionnairemanager.engine.core;

import java.util.ArrayList;

/**
 * Represents a Questionnaire Set
 * 
 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email> <date>09/07/2013
 */
public class QuestionnaireSet {

    // Attributes
    private Integer iQuestionnaireSetId;
    private Integer iOrder;
    private String sShortName;
    private String sName;
    private Boolean bPreCondition;
    private String sSubjectSecondaryIdField;
    private String sSubjectAlternativeSearchField;
    private String sSubjectConfirmationFields;
    private Integer iNewSubjectSecionId;
    private Boolean bOnNewSubject;

    private ArrayList<Questionnaire> alQuestionnaires;

    /**
     * @return the iQuestionnaireSetId
     */
    public Integer getiQuestionnaireSetId() {

	return iQuestionnaireSetId;
    }

    /**
     * @return the iOrder
     */
    public Integer getiOrder() {

	return iOrder;
    }

    /**
     * @return the sShortName
     */
    public String getsShortName() {

	return sShortName;
    }

    /**
     * @return the sName
     */
    public String getsName() {

	return sName;
    }

    /**
     * @return the sSubjectSecondaryIdField
     */
    public String getsSubjectSecondaryIdField() {

	return sSubjectSecondaryIdField;
    }

    /**
     * @return the sSubjectAlternativeSearchField
     */
    public String getsSubjectAlternativeSearchField() {

	return sSubjectAlternativeSearchField;
    }

    /**
     * @return the sSubjectConfirmationFields
     */
    public String getsSubjectConfirmationFields() {

	return sSubjectConfirmationFields;
    }

    /**
     * @return the iNewSubjectSecionId
     */
    public Integer getiNewSubjectSecionId() {

	return iNewSubjectSecionId;
    }

    /**
     * Get all Questionnaires of this Context.
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>Jul 9, 2013</date>
     * @return Array List with all Questionnaires of this session
     */
    public ArrayList<Questionnaire> getalQuestionnaires() {

	// Questionnaire qInformation = new Questionnaire();

	if (this.alQuestionnaires.isEmpty()) {
	    // this.alQuestionnaires = qInformation.getAll(this.iQuestionnaireSetId);
	}

	return this.alQuestionnaires;
    }

    /**
     * Gets all the Questionnaire Sets of the Study
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>Jul 9, 2013</date>
     * @return
     */
    public ArrayList<QuestionnaireSet> getAll() {

	ArrayList<QuestionnaireSet> alListQuestionnaireSet = null;
	// ArrayList<Object> alListRecords = new ArrayList<Object>();

	// TODO: DA.QuestionnaireSet.GetAll()
	// TODO: Agregar los datos que devuelve la consulta de todos los questionnaires set

	return alListQuestionnaireSet;

    }

    /**
     * Get all the Questionnaire Sets of the Study that fulfills their Precondition.
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>Jul 9, 2013</date>
     * @return a List (of QuestionnaireSet) with all the Questionnaire Sets of the Study that fulfills their Precondition.
     */
    // TODO: Utiliza EvaluationPrecondition
    public ArrayList<QuestionnaireSet> getAllValid() {

	ArrayList<QuestionnaireSet> alValidQuestionnaireSets = null;

	return alValidQuestionnaireSets;
    }

    /**
     * Evaluate the function of this context
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>Jul 10, 2013</date>
     */
    public void ExecuteOnNewSubjectProcedure() {

	if (this.bOnNewSubject) {
	    // TODO: Realizar este llamado y como funciona el Procedure o Invoke.
	    // Procedure.Execute(Context.ConstructorsDontNetClassName, "OnNewSubject_" & Me.ShortName, Nothing)
	}
    }

    /**
     * Evaluate pre condition this context
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>Jul 10, 2013</date>
     * @return True/False the evaluate this context
     */
    public Boolean EvaluatePreCondition() {

	if (this.bPreCondition) {
	    // TODO: Operate the function Evaluate Function, use Reflection
	    // Evaluator.EvaluateFunction(Context.PreconditionsDotNetClassName, "Precondition" & Me.ShortName, TypeCode.Boolean, Nothing))
	    return true;
	}

	return true;
    }

    /**
     * Create subject in this context
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>Jul 10, 2013</date>
     * @return Subject created
     */
    /*    public function CreateSubject() {
            return Subject.Create(this, Context.CurrentSite);
        }
        */

}

/**
 * 
 */

package org.questionnairemanager.engine.core;

import java.util.Stack;

/**
 * Provides access to the current state of the application.
 * 
 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email> <date>July 03,
 *         2013 </date>
 */
public class Context {

    public enum UserAction {
        CREATESUBJECT,
        MODIFYSUBJECT,
        VIEWREPORT
    }

    private Study uCurrentStudy;
    public UserAction uaCurrentAction;
    public Site stCurrentSite;
    public Subject sbjCurrentSubject;
    public QuestionnaireSet qsCurrentQuestionnaireSet;
    public Questionnaire qCurrentQuestionnaire;
    public Section sctCurrentSection;
    public Screen scrCurrentScreen;

    public Report rptCurrentReport;
    public Stack<Screen> stkScreenStack;

    public String sPdaSerialNumber;
    public String sPdaName;

    /**
     * @return the scrCurrentScreen
     */
    public Screen getScrCurrentScreen() {
        return scrCurrentScreen;
    }
    
    /**
     * Get the start screen
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     * <date>Jul 12, 2013</date>
     * @return Screen, start screen
     */
    public Screen getStarScreen(){
        
        return this.sctCurrentSection.getScrStartScreen();
    }

    /**
     * @return the uCurrentStudy
     */
    public Study getuCurrentStudy() {
        return uCurrentStudy;
    }

    /**
     * @param uCurrentStudy the uCurrentStudy to set
     */
    public void setuCurrentStudy(Study uCurrentStudy) {

        this.uCurrentStudy = uCurrentStudy;

        // TODO: Agregar dato a la base de datos
        // DA.Common.Init (_currentStudy.SecurityFile, _currentStudy.ConfigFile,
        // _currentStudy.DataFile)
    }

    /**
     * String format to QM.Conditions
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     *         <date>Jul 10, 2013</date>
     * @return String with the new format
     */
    public String ConditionsDotNetClassName() {
        String sFormat;

        sFormat = String.format("%s.QM.Conditions.%s.%s,%s.QM", this.uCurrentStudy.getsShortName(),
                this.qsCurrentQuestionnaireSet.getsShortName(),
                this.qCurrentQuestionnaire.getsShortName(), this.sctCurrentSection.getsShortName());

        return sFormat;
    }

    /**
     * String format to Validation class name
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     *         <date>Jul 10, 2013</date>
     * @return String with the new format
     */
    public String ValidationsClassName() {
        String sFormat;

        sFormat = String.format("%s.QM.Events.%s.%s%s,%s.QM", this.uCurrentStudy.getsShortName(),
                this.qsCurrentQuestionnaireSet.getsShortName(),
                this.qCurrentQuestionnaire.getsShortName(),
                this.sctCurrentSection.getsShortName(),
                this.uCurrentStudy.getsShortName());

        return sFormat;

    }

    /**
     * String fotmat to event class name
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     *         <date>Jul 10, 2013</date>
     * @return String event class name with the new format
     */
    public String EventsClassName() {
        String sFormat;

        sFormat = String.format("%s.QM.Events.%s.%s%s,%s.QM",
                this.uCurrentStudy.getsShortName(),
                this.qsCurrentQuestionnaireSet.getsShortName(),
                this.qCurrentQuestionnaire.getsShortName(),
                this.sctCurrentSection.getsShortName(),
                this.uCurrentStudy.getsShortName());

        return sFormat;
    }

    /**
     * String format to preconditions class name
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     *         <date>Jul 10, 2013</date>
     * @return String with the format to precondition class name
     */
    public String PreconditionsClassName() {
        String sFormat;

        sFormat = String.format("%s.QM.Preconditions,%s.QM", this.uCurrentStudy.getsShortName(),
                this.uCurrentStudy.getsShortName());

        return sFormat;
    }

    /**
     * String format to constructor class name.
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     *         <date>Jul 10, 2013</date>
     * @return String with the format to constructor class name
     */
    public String ConstructorsClassName() {
        String sFormat;

        sFormat = String.format("%s.QM.Constructors,%s.QM", this.uCurrentStudy.getsShortName(),
                this.uCurrentStudy.getsShortName());

        return sFormat;

    }

    /**
     * Set the sufix to method name
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
     *         <date>Jul 10, 2013</date>
     * @return String with the new name to method sufix
     */
    public String MethodNameSufix() {

        return String.format("_%s", this.scrCurrentScreen.replaceNumber(".", "_"));

    }

}

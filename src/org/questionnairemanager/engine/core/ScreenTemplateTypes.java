/**
 * 
 */

package org.questionnairemanager.engine.core;

/**
 * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>Jul, 30 2013 </date> Constants of type Screen Template
 */
public enum ScreenTemplateTypes {

    TEXTBOX, TEXTAREA, DROPDOWN, RADIOBUTTON, INTEGER, DECIMAL, DATETIME, DATE, TIME, CHECKBOX, GRID, NAME, GPSREADING, INFO, SECTIONEXITSCREEN;

    /**
     * Return signified of element enum type.
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>12/08/2013</date> (non-Javadoc)
     * @see java.lang.Enum#toString()
     * @return String with description in lowercase.
     */
    @Override
    public String toString() {

	switch (this) {

	    case TEXTBOX:
		return "textbox"; // nvarchar (50)

	    case TEXTAREA:
		return "textarea"; // nvarchar(255)

	    case DROPDOWN:
		return "dropdown"; // integer

	    case RADIOBUTTON:
		return "radiobutton"; // integer

	    case INTEGER:
		return "integer"; // integer

	    case DECIMAL:
		return "decimal"; // numeric

	    case DATETIME:
		return "datetime"; // datetime

	    case DATE:
		return "date"; // datetime

	    case TIME:
		return "time"; // datetime

	    case CHECKBOX:
		return "checkbox"; // bit

	    case GRID:
		return "grid"; // null

	    case GPSREADING:
		return "gpsreading"; // null

	    case INFO:
		return "info"; // null

	    case SECTIONEXITSCREEN:
		return "exitscreen"; // null

	    default:
		return "unspecified"; // ERROR

	}
    }

    /**
     * Return guid of element
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>12/08/2013</date>
     * @return String GUID of element
     */
    public String getGuid() {

	switch (this) {

	    case TEXTBOX:
		return "guidtb"; // nvarchar (50)

	    case TEXTAREA:
		return "guidta"; // nvarchar(255)

	    case DROPDOWN:
		return "guiddd"; // integer

	    case RADIOBUTTON:
		return "guidrb"; // integer

	    case INTEGER:
		return "guidin"; // integer

	    case DECIMAL:
		return "guidde"; // numeric

	    case DATETIME:
		return "guiddt"; // datetime

	    case DATE:
		return "guiddt"; // datetime

	    case TIME:
		return "guiddt"; // datetime

	    case CHECKBOX:
		return "guidcb"; // bit

	    case GRID:
		return "guidgr"; // null

	    case GPSREADING:
		return "guidgp"; // null

	    case INFO:
		return "guidif"; // null

	    case SECTIONEXITSCREEN:
		return "guidse"; // null

	    default:
		return "unspecified"; // ERROR
	}
    }
}

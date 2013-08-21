
package org.questionnairemanager.engine.core;

public enum TypeNode {

    ST, // ST = study
    QG, // QG = Questionnaire Group
    QU, // QU = Questionnaire
    GR, // GR = Group
    CH, // CH = Checkpoint
    IN, // IN = Info
    Q,  // Q = Question
    EX; // EX = Expression

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {

	switch (this) {

	    case ST:
		return "st";	// Study

	    case QG:
		return "qg";	// Questionnaire Group

	    case QU:
		return "qu"; // Questionnaire

	    case GR:
		return "gr";	// Group

	    case CH:
		return "ch";	// CheckPoint

	    case IN:
		return "in";	// Info

	    case Q:
		return "q"; // Question

	    case EX:
		return "ex";	// Expression

	    default:
		return "unspecified";

	}
    }

}

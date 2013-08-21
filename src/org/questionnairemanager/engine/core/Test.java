/**
 * 
 */

package org.questionnairemanager.engine.core;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author ennercastillo
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {

	QuestionManager qm = new QuestionManager();
	ArrayList<Node> alStudies = new ArrayList<Node>();

	Node alQuestion = new Node();

	qm.SetListOfStudies(); // Almacena el listado de todos los nodos de DA

	// TODO: Verify list of studies
	alStudies = qm.GetListOfStudies(); // Devuelve el listado de todos los nodos

	Node nNodeStudy = new Node();

	for (Node node : alStudies) {
	    if (node.getsNodeguid().equalsIgnoreCase("GUIDSt")) {
		try {
		    // node.PrintNodeInformation();
		    ((Study) node).ShowInformation();
		    // node.ShowInformation();
		    nNodeStudy = (Study) node.clone();
		} catch (CloneNotSupportedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	}

	// Get Elements by GUID
	ArrayList<Node> alNodeInfo2 = qm.GetElementsOfStudyByGuid(nNodeStudy);
	Node nFirstElement = new Node();

	if (!(alNodeInfo2 == null) && !alNodeInfo2.isEmpty()) {

	    System.out.println("INFORMACION DE LOS HIJOS DE GUIDST ");
	    for (Node oData : alNodeInfo2) {

		// Node nTemporal = new Node();
		System.out.println("-------- inicio hijo \n");
		oData.PrintNodeInformation();
		System.out.println("-------- fin hijo \n");

		// if (node.getsNodeguid().equalsIgnoreCase("guidq5")) || guidqu {
		if (oData.getsNodeguid().equalsIgnoreCase("guidqu")) {

		    try {
			// nFirstElementQuestion = (Node) ((Node) oData).clone();
			nFirstElement = (Node) oData.clone();

		    } catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		}
	    }

	    System.out.println(nFirstElement.getTnTypeNode());

	    if (nFirstElement != null) {

		switch (nFirstElement.getTnTypeNode()) {
		    case QU:
			((Questionnaire) nFirstElement).ShowInformation();
			break;
		    case QG:
			((QuestionnaireGroup) nFirstElement).ShowInformation();
			break;

		    default:
			System.out.println("Error!");
			break;
		}

	    } else System.out.println("ERROR is null!!!");

	    System.out.println("end first element questionnaire!!!!!!!-----");

	    ArrayList<Node> alQuestions = new ArrayList<Node>();

	    alQuestions = qm.GetElementsOfQuestionnaireOrQuestionnaireGroup(nFirstElement);

	    if (alQuestions == null) System.out.println("ITS NULL!!!");
	    else {
		for (Iterator<Node> questionnaire = alQuestions.iterator(); questionnaire.hasNext();) {
		    Node node = (Node) questionnaire.next();

		    switch (node.getTnTypeNode()) {
			case QG:
			    System.out.println("Is a Questionnaire Group!!!!");
			    node.PrintNodeInformation();
			    break;
			case CH:
			    System.out.println("it is a questionnaire!!!!");
			    node.PrintNodeInformation();
			    break;
			case Q:
			    System.out.println("it is a question----");
			    node.PrintNodeInformation();
			    System.out.println("------- info question ------");
			    System.out.println();
			    ((Question) node).ShowInformation();
			    break;
			case IN:
			    System.out.println("it is an info----");
			    node.PrintNodeInformation();
			    break;
			default:
			    break;
		    }

		}
	    }

	}

	/*// Get the first node for the questionnaire
	// No se ha verificado si pertenece al tipo Q o QG
	alQuestion = qm.GetFirstChildQuestionnaire(nFirstElementQuestion);

	if (alQuestion == null) {
	System.out.println("no hay informacion de un hijo ");
	} else {
	alQuestion.PrintNodeInformation();
	Node nTemp = new Node();
	
	System.out.println("first!!!!! \n");		
	nTemp = qm.GetNextChildQuestionnaire(alQuestion);
	
	if (nTemp != null)
	    nTemp.PrintNodeInformation();
	else
	    System.out.println("its null first");
	
	System.out.println("second!!!! \n");
	nTemp = qm.GetNextChildQuestionnaire(nTemp);
	if (nTemp != null)
	    nTemp.PrintNodeInformation();
	else
	    System.out.println("its null second");
	
	System.out.println("third!!!! \n");
	nTemp = qm.GetNextChildQuestionnaire(nTemp);
	if (nTemp != null)
	    nTemp.PrintNodeInformation();
	else
	    System.out.println("its null third");
	
	
	System.out.println("fourth!!!! \n");
	nTemp = qm.GetNextChildQuestionnaire(nTemp);
	if (nTemp != null)
	    nTemp.PrintNodeInformation();
	else
	    System.out.println("its null fourth!");
	
	System.out.println("fifth!!!! \n"); //TODO: RETURN NULL ELEMENT
	nTemp = qm.GetNextChildQuestionnaire(nTemp);
	if (nTemp != null)
	    nTemp.PrintNodeInformation();
	else
	    System.out.println("its null fifth");
	}*/

	// Ac??? debe enviar el dato
	// Se debe validar de que tipo es (Q / QG)
	// Si es Q debe traer la primera pregunta
	// si es QG debe traer todos sus elementos

	// alQuestion = qm.GetElementsQuestionnaire("guidst");

	// } else System.out.println("No hay nodo");

	System.out.println("fin");
    }
}

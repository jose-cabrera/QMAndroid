/**
 * 
 */

package org.questionnairemanager.engine.core;

import java.util.HashMap;
import java.util.Locale;

/**
 * Dummy class for node. Node get all information to Question Manager
 * 
 * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>Jul, 25 2013</date>
 */
public class Node implements Cloneable {

    // PK
    private String sNodeguid;

    private String sParentGuid;
    private TypeNode tnTypeNode;
    private String sOrdinal;
    private Boolean bVisible;
    private String sNumber;
    private Boolean bHideNext;
    private Boolean bHideBack;
    private Boolean bConfirmNext;
    private Boolean bConfirmBack;
    private String sOnLoad;
    private String sOnUnload;
    private String sComment;

    private HashMap<String, String> hmDictionaryMainText() {

	return null;
    }

    private HashMap<String, String> hmDictionaryHelpText() {

	return null;
    }

    /**
     * @return the sNodeguid
     */
    public String getsNodeguid() {

	return sNodeguid;
    }

    /**
     * @return the sParentGuid
     */
    public String getsParentGuid() {

	return sParentGuid;
    }

    /**
     * @return the tnTypeNode
     */
    public TypeNode getTnTypeNode() {

	return tnTypeNode;
    }

    /**
     * @return the sOrdinal
     */
    public String getsOrdinal() {

	return sOrdinal;
    }

    /**
     * @return the bVisible
     */
    public Boolean getbVisible() {

	return bVisible;
    }

    /**
     * @return the sNumber
     */
    public String getsNumber() {

	return sNumber;
    }

    /**
     * @return the bHideNext
     */
    public Boolean getbHideNext() {

	return bHideNext;
    }

    /**
     * @return the bHideBack
     */
    public Boolean getbHideBack() {

	return bHideBack;
    }

    /**
     * @return the bConfirmNext
     */
    public Boolean getbConfirmNext() {

	return bConfirmNext;
    }

    /**
     * @return the bConfirmBack
     */
    public Boolean getbConfirmBack() {

	return bConfirmBack;
    }

    /**
     * @return the sOnLoad
     */
    public String getsOnLoad() {

	return sOnLoad;
    }

    /**
     * @return the sOnUnload
     */
    public String getsOnUnload() {

	return sOnUnload;
    }

    /**
     * @return the sComment
     */
    public String getsComment() {

	return sComment;
    }

    /**
     * Constructor class without data
     */
    public Node() {

	this.sNodeguid = "";
	this.sParentGuid = "";
	this.sOrdinal = "";
	this.bVisible = false;
	this.sNumber = "";
	this.bHideNext = false;
	this.bHideBack = false;
	this.bConfirmNext = false;
	this.bConfirmBack = false;
	this.sOnLoad = "";
	this.sOnUnload = "";
	this.sComment = "";
	this.tnTypeNode = null;
    }

    /**
     * Constructor class with data
     * 
     * @param sNodeguid, Guid of node
     * @param sParentGuid, Guid of parent node
     * @param sType, Type of node
     * @param sOrdinal, Orden for brothers
     * @param bVisible, it is visible
     * @param sNumber, number
     * @param bHideNext, is hide next
     * @param bHideBack, is hide back
     * @param bConfirmNext, is confirm next
     * @param bConfirmBack, is confirm back
     * @param sOnLoad, value of load
     * @param sOnUnload, value of unload
     * @param sComment, comment to node
     */
    public Node(String sNodeguid, String sParentGuid, TypeNode sTypeNode, String sOrdinal, Boolean bVisible, String sNumber, Boolean bHideNext,
	    Boolean bHideBack, Boolean bConfirmNext, Boolean bConfirmBack, String sOnLoad, String sOnUnload, String sComment) {

	this.tnTypeNode = sTypeNode;
	this.sNodeguid = sNodeguid;
	this.sParentGuid = sParentGuid;
	this.sOrdinal = sOrdinal;
	this.bVisible = bVisible;
	this.sNumber = sNumber;
	this.bHideNext = bHideNext;
	this.bHideBack = bHideBack;
	this.bConfirmNext = bConfirmNext;
	this.bConfirmBack = bConfirmBack;
	this.sOnLoad = sOnLoad;
	this.sOnUnload = sOnUnload;
	this.sComment = sComment;
    }

    public void PrintNodeInformation() {

	System.out.println("tipo nodo " + tnTypeNode);
	System.out.println("guid nodo " + sNodeguid);
	System.out.println("parent guid " + sParentGuid);
	System.out.println("ordinal # " + sOrdinal);
	System.out.println("is visible " + bVisible);
	System.out.println("number " + sNumber);
	System.out.println("hide next " + bHideNext);
	System.out.println("hide back " + bHideBack);
	System.out.println("conf next " + bConfirmNext);
	System.out.println("conf back " + bConfirmBack);
	System.out.println("on load " + sOnLoad);
	System.out.println("on unload " + sOnUnload);
	System.out.println("comment " + sComment);

    }

    /**
     * Get type node of string to compare.
     * 
     * @param sTypeNode, String to search
     * @return TypeNode, string with equivalent string inserted.
     */
    public TypeNode GetTypeNodeOfString(String sToCompare) {

	// Convert string to lower case
	sToCompare = sToCompare.toLowerCase(Locale.ENGLISH);

	// Get equivalent TypeNode

	// ST = Study
	if (sToCompare.equals(TypeNode.ST)) return TypeNode.ST;

	// QG = Questionnaire Group
	if (sToCompare.equals(TypeNode.QG)) return TypeNode.QG;

	// QU = Questionnaire
	if (sToCompare.equals(TypeNode.QU)) return TypeNode.QU;

	// GR = Group
	if (sToCompare.equals(TypeNode.GR)) return TypeNode.GR;

	// CH = Check point
	if (sToCompare.equals(TypeNode.CH)) return TypeNode.CH;

	// IN = Info
	if (sToCompare.equals(TypeNode.IN)) return TypeNode.IN;

	// Q = Question
	if (sToCompare.equals(TypeNode.Q)) return TypeNode.Q;

	// EX = Expression
	if (sToCompare.equals(TypeNode.EX)) return TypeNode.EX;

	return null;
    }

    /**
     * Constructor with information for Node
     * 
     * @param nData
     */
    public Node(Node nData) {

	this.tnTypeNode = nData.getTnTypeNode();
	this.sNodeguid = nData.getsNodeguid();
	this.sParentGuid = nData.getsParentGuid();
	this.sOrdinal = nData.getsOrdinal();
	this.bVisible = nData.getbVisible();
	this.sNumber = nData.getsNumber();
	this.bHideNext = nData.getbHideNext();
	this.bHideBack = nData.getbHideBack();
	this.bConfirmNext = nData.getbConfirmNext();
	this.bConfirmBack = nData.getbConfirmBack();
	this.sOnLoad = nData.getsOnLoad();
	this.sOnUnload = nData.getsOnUnload();
	this.sComment = nData.getsComment();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

	return super.clone();

    }

    /**
     * Add values to MainText
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>16/08/2013</date>
     * @param sLanguage, guid for language
     * @param sText, text for this language
     */
    public void setElementMainText(String sLanguage, String sText) {

	hmDictionaryMainText().put(sLanguage, sText);
    }

    /**
     * Add values to HelpText
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>16/08/2013</date>
     * @param sLanguage, guid for language
     * @param sText, text for this language
     */
    public void setElementHelpText(String sLanguage, String sText) {

	hmDictionaryHelpText().put(sLanguage, sText);
    }

    /**
     * Return value for this key in Main Text Dictionary
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>16/08/2013</date>
     * @param sGuidLanguage, guid to language to search
     * @return value for this hashmap or null if not exists
     */
    public String getElementMainText(String sGuidLanguage) {

	return hmDictionaryMainText().get(sGuidLanguage);

    }

    /**
     * Return value for this key in HelpText dictionary
     * 
     * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email> <date>16/08/2013</date>
     * @param sGuidLanguage, guid to language to search
     * @return value for this hashmap or null if not exists
     */
    public String getElementHelpText(String sGuidLanguage) {

	return hmDictionaryHelpText().get(sGuidLanguage);
    }

}

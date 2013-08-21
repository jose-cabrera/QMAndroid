package org.questionnairemanager.engine.core;

/**
 * Represents a single step of a Procedure
 * 
 * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
 *         <date>Jul, 21 2013</date>
 * 
 */
public class ProcedureStep {

	private Integer iProcedureId;
	private Integer iOrder;
	private String sMethodName;
	private String sMethodArguments;
	
	/**
	 * @return the iProcedureId
	 */
	public Integer getiProcedureId() {
		return iProcedureId;
	}
	/**
	 * @param iProcedureId the iProcedureId to set
	 */
	public void setiProcedureId(Integer iProcedureId) {
		this.iProcedureId = iProcedureId;
	}
	/**
	 * @return the iOrder
	 */
	public Integer getiOrder() {
		return iOrder;
	}
	/**
	 * @param iOrder the iOrder to set
	 */
	public void setiOrder(Integer iOrder) {
		this.iOrder = iOrder;
	}
	/**
	 * @return the sMethodName
	 */
	public String getsMethodName() {
		return sMethodName;
	}
	/**
	 * @param sMethodName the sMethodName to set
	 */
	public void setsMethodName(String sMethodName) {
		this.sMethodName = sMethodName;
	}
	/**
	 * @return the sMethodArguments
	 */
	public String getsMethodArguments() {
		return sMethodArguments;
	}
	/**
	 * @param sMethodArguments the sMethodArguments to set
	 */
	public void setsMethodArguments(String sMethodArguments) {
		this.sMethodArguments = sMethodArguments;
	}
/*
	
	public void Execute(){
		MethodName mnMethod = new MethodName();
		
	}
*/

}

/**
 * 
 */
package org.questionnairemanager.engine.core;

import java.util.ArrayList;

/**
 * Class that handels the information from the sites
 * 
 * @author Enner Castillo <email>eriec.42@gmail.com</email>
 *         <date>01/07/2013</date>
 * 
 */

public class Site {

	private Integer iSiteId;
	private String sNameSite;
	private String sCodeSite;

	/**
	 * Get site id
	 * 
	 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
	 *         <date>02/07/2013</date>
	 * @return the iSiteId
	 */
	public Integer getiSiteId() {
		return iSiteId;
	}

	/**
	 * Set the site id
	 * 
	 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
	 *         <date>02/07/2013</date>
	 * @param iSiteId
	 *            the iSiteId to set
	 */
	public void setiSiteId(Integer iSiteId) {
		this.iSiteId = iSiteId;
	}

	/**
	 * Get the name of site
	 * 
	 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
	 *         <date>02/07/2013</date>
	 * @return the sNameSite, Name of site
	 */
	public String getsNameSite() {
		return sNameSite;
	}

	/**
	 * Set the name of site
	 * 
	 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
	 *         <date>02/07/2013</date>
	 * @param sNameSite
	 *            the sNameSite to set
	 */
	public void setsNameSite(String sNameSite) {
		this.sNameSite = sNameSite;
	}

	/**
	 * Get the code of site
	 * 
	 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
	 *         <date>02/07/2013</date>
	 * @return the sCodeSite, Code of Site
	 */
	public String getsCodeSite() {
		return sCodeSite;
	}

	/**
	 * Set the code of site
	 * 
	 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
	 *         <date>02/07/2013</date>
	 * @param sCodeSite
	 *            the sCodeSite to set
	 */
	public void setsCodeSite(String sCodeSite) {
		this.sCodeSite = sCodeSite;
	}

	/**
	 * Constructor of class, id site
	 * 
	 * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
	 *         <date>01/07/2013</date>
	 * @param int siteId, If of site
	 */
	public Site(Integer siteId) {

		// DataRow row = sideId;

		// TODO: Add element connect with database DA.Site.GetSingle(siteId);

		super();
	}

	/**
	 * Get all elements of array sites.
	 * 
	 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
	 *         <date>02/07/2013</date>
	 * @return ArrayList listSites, List of sites
	 */
	public static ArrayList<String> GetAll() {

		ArrayList<String> listSites = new ArrayList<String>();

		// TODO: Method of class DA.Site.GetAll().Rows;
		// TODO: listSites = DA.Site.GetAll();

		return listSites;
	}

	/**
	 * Indicates if a site with the specified identifier exists.
	 * 
	 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
	 *         <date>02/07/2013</date>
	 * @param siteId
	 *            , site identifier
	 * @return boolean, TRUE exists, FALSE not exists.
	 */
	public static boolean Exists(Integer siteId) {

		// TODO: Method of class DA.Site.Exists(siteId);

		return true;
	}

	/**
	 * Verify if two sites are equals.
	 * 
	 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
	 *         <date>02/07/2013</date>
	 * @param Site pOperand1, Site to compare
	 * @param Site pOperand2, Site to compare
	 * @return boolean, TRUE are equals sites, FALSE not are equals sites.
	 */
	public boolean Equals(Site pOperand1, Site pOperand2) {

		if ((pOperand1 == null) || (pOperand2 == null))
			return false;

		return pOperand1.equals(pOperand2);
	}

	/**
	 * Verify if two site are not equals
	 * 
	 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
	 *         <date>02/07/2013</date>
	 * @param Site pOperand1, Site to compare
	 * @param Site pOperand2, Site to compare
	 * @return boolean, TRUE are not equals sites, FALSE are equals sites.
	 */
	public boolean NotEquals(Site pOperand1, Site pOperand2) {

		if ((pOperand1 == null) || (pOperand2 == null))
			return false;

		return pOperand1.NotEquals(this, pOperand2);

	}

	/**
	 * Constructor
	 * @param alData, DataRow with the site's information
	 */
	private Site(ArrayList<Object> alData) {
		PopulateProperties(alData);
	}

	/**
	 * Populate Properties, Set the properties values
	 * @author Enner Escobedo C. <email>enner.castillo@centrikal.com</email>
	 * <date>Jul, 21 2013</date>
	 * 
	 * @param alData, array list with the information
	 */
	private void PopulateProperties(ArrayList<Object> alData) {

		// Get the info in the array list
		for (Object sAlData : alData) {

			// Insert data to class
			this.iSiteId = ((Site) sAlData).getiSiteId();
			this.sNameSite = ((Site) sAlData).getsNameSite();
			this.sCodeSite = ((Site) sAlData).getsCodeSite();

		}

	}



}

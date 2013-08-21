/**
 * 
 */
package org.questionnairemanager.engine.core;

import java.util.ArrayList;

/**
 * Class with the information of a user
 * @author Enner Castillo <email>eriec.42@gmail.com</email>
 * <date>01/07/2013</date>
 *
 */
public class User {
    
    
    private String sPDAUserName;
    private String sNameUser;
    private String sRoleName;
    private Integer iDefaultSiteId; // C?mo usar nullable int
   
    private Site stDefaultSite;

    /**
     * Return name of PDA user
     * @return the sPDAUserName
     */
    public String getsPDAUserName() {
        return sPDAUserName;
    }

    /**
     * Return name of user
     * @return the sNameUser
     */
    public String getsNameUser() {
        return sNameUser;
    }

    /**
     * Return role name of user
     * @return the sRoleName
     */
    public String getsRoleName() {
        return sRoleName;
    }

    /**
     * Return default site identifier
     * @return the iDefaultSiteId
     */
    public Integer getiDefaultSiteId() {
        return iDefaultSiteId;
    }

    /**
     * Return default Site 
     * @return the stDefaultSite
     */
    public Site getStDefaultSite() {
    
        if (this.stDefaultSite != null)
            return this.stDefaultSite;
        
        if ((this.iDefaultSiteId != null) && stDefaultSite.Exists(this.iDefaultSiteId))
            this.stDefaultSite = new Site(this.iDefaultSiteId);
        
            
        return stDefaultSite;
    }
    
    /**
     * Get all of users
     * 
     * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
     * <date>Jul 2, 2013</date>
     * @return lstUser, List of users
     */
    public ArrayList<String> GetAll (){
        
        ArrayList<String> lstUser = null;
        
        //TODO: DA.Security.GetAll().Rows;
        
        return lstUser;
        
    }
    
    
    public User Login (String pPdaUserName, String pPdaPassword){
    
        //TODO: DA.Security.GetUser (pPdaUserName, pPdaPassword);
        User bIsUserPermitied = null;
        
        if (bIsUserPermitied != null)
                return bIsUserPermitied;
        else
            return null;
            
        
    }

    /**
     * Constructor of class User <email>eriec.42@gmail.com</email>
     * <date> Jul 2, 2013</date>
     * @param sPDAUserName, PDA User name 
     * @param sNameUser, User name
     * @param sRoleName, Role name of user
     * @param iDefaultSiteId, Default site identifier
     * @param stDefaultSite, Default site
     */
    public User(String sPDAUserName, String sNameUser, String sRoleName, Integer iDefaultSiteId,
            Site stDefaultSite) {
        this.sPDAUserName = sPDAUserName;
        this.sNameUser = sNameUser;
        this.sRoleName = sRoleName;
        //this.iDefaultSiteId = iDefaultSiteId;
        this.stDefaultSite = stDefaultSite;
        
        if (iDefaultSiteId == null)
            this.iDefaultSiteId = null;
        else
            this.iDefaultSiteId = iDefaultSiteId;
    }
    
    
    
    
    
    

}

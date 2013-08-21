/**
 * 
 */
package org.questionnairemanager.engine.core;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Represents a .Net Class and contains information to create
 * an instance of the class.
 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
 * <date>July 04, 2013</date>
 *
 */
public class DotNetClass {
    
    
    private Integer iDotNetClassId;
    private String sDotNetClassName;
    private Type tClasstype;
    
    
    /**
     * @return the iDotNetClassId
     */
    public Integer getiDotNetClassId() {
        return iDotNetClassId;
    }
    /**
     * @return the sDotNetClassName
     */
    public String getsDotNetClassName() {
        return sDotNetClassName;
    }
    
    /**
     * Get class type
     * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
     * <date>Jul 4, 2013</date>
     * @return Type, class type
     */
    public Type getClassType (){
        if (this.tClasstype != null){
            return this.tClasstype;
        }
        
        return null;
    }
    
    /**
     * @param iDotNetClassId
     */
    public DotNetClass(Integer iDotNetClassId) {
        
        //TODO: Get datarow of DA.DotNetClass.GetSingle (dotNetClassId)
        // if row is empty, return "The dotnetclass with id does not exists"
        // else populateproperties
        this.iDotNetClassId = iDotNetClassId;
    }
    
    /**
     * Constructor class DotNetClass
     * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
     * <date>July 04, 2013</date>
     * @param alData, array list of elements Dot Net class
     */
    public DotNetClass (ArrayList<DotNetClass> alData){
        PopulateProperties (alData);
    }
    
    /**
     * Fill with data information of DotNetClass
     * 
     * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
     * <date>Jul 4, 2013</date>
     * @param alDataToInsert, array list of object dot net class type
     */
    public void PopulateProperties (ArrayList<DotNetClass> alDataToInsert){
        //this.iDotNetClassId = alDataToInsert
        for (DotNetClass dotnetclass : alDataToInsert){
            this.iDotNetClassId = dotnetclass.getiDotNetClassId();
            this.sDotNetClassName = dotnetclass.getsDotNetClassName();
        }
    }
    
    
    
    

}

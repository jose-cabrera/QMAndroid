/**
 * 
 */
package org.questionnairemanager.engine.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


/**
 * Represents a Method that can be invoked
 * to performer actions in the different extensibility points
 * of a Questionnaire
 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
 * <date>July 03, 2013 </date>
 *
 */
public class MethodClass {
    
    private String sMethodName;
    private Integer iDotNetClassId;
    private String sDotNetMethodName;
    
    private DotNetClass dncDotNetClass;
    //TODO: add next method
    public Method mMethodInfo;
    
    
    
    /**
     * @return the iDotNetClassId
     */
    public Integer getiDotNetClassId() {
        return iDotNetClassId;
        
    }
    
    /**
     * @return the sDotNetMethodName
     */
    public String getsDotNetMethodName() {
        return sDotNetMethodName;
    }
    
    /**
     * @return the dncDotNetClass
     */
    public DotNetClass getDncDotNetClass() {
        if (this.dncDotNetClass == null)
                this.dncDotNetClass = new DotNetClass (this.iDotNetClassId);
        
        return dncDotNetClass;
    }
    
    /**
     * @return the miMethodInfo
     */
    public String getSMethodName() {
        return sMethodName;
    }
    
    /**
     * @param sMethodName
     */
    public MethodClass(String sMethodName) {
        // TODO: Add code of DATABASE
        this.sMethodName = sMethodName;
    }

    /**
     * Constructor class Method
     * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
     * <date>July 04, 2013 </date>
     * @param sMethodName
     * @param iDotNetClassId
     * @param sDotNetMethodName
     */
    public MethodClass(String sMethodName, Integer iDotNetClassId, String sDotNetMethodName) {
        this.sMethodName = sMethodName;
        this.iDotNetClassId = iDotNetClassId;
        this.sDotNetMethodName = sDotNetMethodName;

    }
    
    public Object Invoke (Object oParameters){
        Integer iProvidedParametersCount = 0;
        Integer iExpectedParametersCount = 0;
        Annotation[][] piMethodParameters = this.mMethodInfo.getParameterAnnotations();
        
//        if (oParameters != null)
//            iProvidedParametersCount = oParameters.getClass().length();
        
       
        
        return piMethodParameters;
        
    }
    
    
    
    
    
    
    
}

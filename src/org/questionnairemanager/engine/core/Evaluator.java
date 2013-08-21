/**
 * 
 */
package org.questionnairemanager.engine.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Performes evaluations of logical conditions (true/false)
 * @author Enner Escobedo C. <email>eriec.42@gmail.com</email>
 * <date>09/07/2013</date>
 *
 */
public class Evaluator {
    
    private HashMap hmClasses;
    
    @SuppressWarnings("null")
    public boolean EvaluateCondition (String sMethodName, Object oParameters){
        Method mMethod = null;
        
        try {
            Object oResult = null;
            mMethod.invoke(sMethodName, oParameters);
            return  true;
            
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    } 

    public boolean EvaluationCondition(){
        //TODO: add next method evaluatefunction
        return false;
    }
    
    
//    public Object EvaluateFunction (String sClassName, String sMethodName, Type tcOutputType, Object oParameters){
//        
//        Method mMethodInfo;
//        String sMethodParameters;
//        Integer iProvidedParametersCount = 0;
//        Integer iExpectedParameters = 0;
//        Type tType;
//        Object oResult;
//        
//        if (!this.hmClasses.containsKey(sClassName)){
//            
//            tType = (sClassName.get)
//            
//        }
//        
//        
//        return oParameters;
//        
//    }

}



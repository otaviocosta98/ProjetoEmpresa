package br.com.contmatic.empresa;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidatorAnnotations {
    
    private static Validator validator;
    
    public static boolean isValid(Object obj, String msg){
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate( obj );
        for(ConstraintViolation<Object> constraintViolation : constraintViolations) {
            if(msg.equals(constraintViolation.getMessage())){
                return false;
            }
        }
        return true;
        
    }

}

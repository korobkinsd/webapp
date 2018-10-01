package system.service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import system.model.Country;

public class LangValidator implements Validator{

    @Override
    public boolean supports(Class clazz) {
        //just validate the Customer instances
        return Country.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Country country = (Country)target;

         if("NONE".equals(country.getCountry())){
            errors.rejectValue("country", "required.country");
        }
    }


}

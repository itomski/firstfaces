package de.lubowiecki.firstfaces.validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.util.ResourceBundle;

@FacesValidator
public class NameValidator implements Validator<String> {

    ResourceBundle bundle = ResourceBundle.getBundle("de.lubowiecki.firstfaces.lang.messages");

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {

        if(value.contains("#")) {
            FacesMessage msg = new FacesMessage(bundle.getString("form.invalid.name"));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw  new ValidatorException(msg);
        }
    }
}

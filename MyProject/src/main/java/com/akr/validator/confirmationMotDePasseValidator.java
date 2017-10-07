package com.akr.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.springframework.stereotype.Component;

@FacesValidator(value = "confirmationMotDePasseValidator")
@Component("confirmationMotDePasseValidator")
public class confirmationMotDePasseValidator implements Validator {

	private static final String CHAMP_MOT_DE_PASSE = "composantMotDePasse";

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		UIInput composantMotDePasse = (UIInput) component.getAttributes().get(CHAMP_MOT_DE_PASSE);
		String motDePasse = (String) composantMotDePasse.getValue();

		String confirmation = (String) value;

		if (confirmation != null && !confirmation.equals(motDePasse)) {
			throw new ValidatorException(new FacesMessage("Le mot de passe et la confirmation doivent être identiques !!! "));
		}

	}
}
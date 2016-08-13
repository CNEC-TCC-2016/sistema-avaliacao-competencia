package br.com.project.checkskills.utils.validators;

import static br.com.project.checkskills.utils.validators.IsNullUtil.isNullOrEmpty;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public final class EmailValidator {
	
	private static final String VIRGULA = ",";

	private static final String EMAIL_PATTERN = 
			"\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
	
	private EmailValidator() {
		throw new IllegalStateException("Class Not Instantiable");
	}
	
	public static boolean isValid(final String email) {
		if (isNullOrEmpty(email)){		
			return false;
		}

		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}
	
	/**
	 * 
	 * <p> Valida um conjunto de emails. </p>
	 * 
	 * @param emails - conjunto de emails a serem validados 
	 * @return true - se todos os emails forem validos.
	 */
	public static boolean isValid(final String... emails) {
		for (final String email : emails) {
			if(!isValid(email)) {
				return Boolean.FALSE;
			}
		}
		
		return Boolean.TRUE;
	}
	
	/**
	 * 
	 * <p> Valida uma {@link String} com um conjunto de emails separados por <b>VIRGULA</b>. </p>
	 * 
	 * @param emails, separados por virgula a serem validados
	 * @return true, caso todos os emails forem validos
	 */
	public static boolean isMultiplosEmailsSeparadosPorVirgulaValidos(final String emails) {
		return isMultipleEmailsValid(emails, VIRGULA);		
	}

	/**
	 * 
	 * <p> Valida uma {@link String} com um conjunto de emails separados pelo <b>separator</b> informado. </p>
	 * 
	 * @param emails, separados pelo separador informado a serem validados
	 * @return true, caso todos os emails forem validos
	 */
	public static boolean isMultipleEmailsValid(final String emails, final String separator) {
		final String[] emailsPosSplit = StringUtils.split(emails, separator);
		return isValid(emailsPosSplit);
	}
	
}

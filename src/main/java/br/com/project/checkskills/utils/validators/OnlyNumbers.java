package br.com.project.checkskills.utils.validators;

public class OnlyNumbers {
	
	private OnlyNumbers() {
		throw new IllegalStateException("Class Not Instantiable");
	}

	public static String getNumbers(String value) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < value.length(); i++) {
			if (Character.isDigit(value.charAt(i))) {
				result.append(value.charAt(i));
			}
		}
		return result.toString();
	}

	public static boolean isOnlyNumbers(String value) {
		boolean result = true;
		char[] aux = value.toCharArray();
		for (char c : aux) {
			if (!Character.isDigit(c)) {
				result = false;
				break;
			}
		}
		return result;
	}
}

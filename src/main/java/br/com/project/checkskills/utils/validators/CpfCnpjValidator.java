package br.com.project.checkskills.utils.validators;

import static br.com.project.checkskills.utils.validators.IsNullUtil.isNullOrEmpty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodolfo Cruz - rodolfo.cruz@itsstecnologia.com.br
 * 
 * <p>Algoritmo copiado na Internet</p>
 * */
public class CpfCnpjValidator {
	
	private static int LENGTH_CPF_SEM_MASCARA = 11;
	private static int LENGTH_CNPJ_SEM_MASCARA = 14;
	
	private static final int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static final int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static List<String> cpfNotValid = new ArrayList<String>();
	
	private CpfCnpjValidator() {
		throw new IllegalStateException("Class Not Instantiable");
	}

	 static {
		populate();
	}

	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	public static boolean isValidCPF(String cpf) {
		if ((cpf == null) || (cpf.length() != LENGTH_CPF_SEM_MASCARA))
			return false;

		if (cpfNotValid.contains(cpf))
			return false;

		Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
		Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
		return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
	}

	public static boolean isValidCNPJ(String cnpj) {
		if ((cnpj == null) || (cnpj.length() != LENGTH_CNPJ_SEM_MASCARA))
			return false;

		Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
		Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
		return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
	}
	
	/**
	 * Informa se a string informada possui o tamanho correto de um CPF, 11 digitos<br>
	 * 12784613291 - Valido<br>
	 * 1278461329 -  Invalido<br>
	 * */
	public static boolean isLengthCpfSemMascara(String cpf){
		boolean result = false;
		if (!isNullOrEmpty(cpf)){
			result = (cpf.length() == LENGTH_CPF_SEM_MASCARA); 
		}		
		return result;
	}
	
	/**
	 * Informa se a string informada possui o tamanho correto de um CNPJ, 14 digitos<br>
	 * 50892996000165 - Valido<br>
	 * 5089299600016 -  Invalido<br>
	 * */
	public static boolean isLengthCnpjSemMascara(String cnpj){
		boolean result = false;
		if (!isNullOrEmpty(cnpj)){
			result = (cnpj.length() == LENGTH_CNPJ_SEM_MASCARA);
		}	
		return result;
	}

	private static void populate() {
		cpfNotValid.add("00000000000");
		cpfNotValid.add("11111111111");
		cpfNotValid.add("22222222222");
		cpfNotValid.add("33333333333");
		cpfNotValid.add("44444444444");
		cpfNotValid.add("55555555555");
		cpfNotValid.add("66666666666");
		cpfNotValid.add("77777777777");
		cpfNotValid.add("88888888888");
		cpfNotValid.add("99999999999");
	}
}

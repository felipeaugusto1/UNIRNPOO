package br.com.unirn.poo.util;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.unirn.poo.singleton.ListasSingleton;

/**
 * Classe que contém alguns métodos comuns ao projeto.
 * 
 * @author felipe
 *
 */
public class SistemaAcademicoUtils {

	/**
	 * Espera alguns segundos antes de executar próxima ação.
	 */
	public static void esperarSegundos() {
		try {
			Thread.sleep(2000); /* 2 segundos */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void sairAplicacao() {
		
		ListasSingleton.getInstance().salvarObjetos();
		System.out.println("Volte sempre!");
		System.exit(0);
	}
	
	public static <T> void clonarListaGeneric(List<T> origem, List<T> destino){
		if (destino != null){
			for (T t : destino) {
				origem.add(t);
			}
		}
	}
	
	public static int lerInteiro(Scanner scanner){
		try {
			int retorno = scanner.nextInt();
			return retorno;
		} catch (InputMismatchException e) {
			scanner = new Scanner(System.in);
			System.out.println("Número inválido, digite outra uma opção válida.");
			return lerInteiro(scanner);
		} 
	}

}

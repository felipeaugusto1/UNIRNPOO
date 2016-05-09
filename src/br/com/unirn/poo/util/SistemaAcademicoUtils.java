package br.com.unirn.poo.util;

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

}

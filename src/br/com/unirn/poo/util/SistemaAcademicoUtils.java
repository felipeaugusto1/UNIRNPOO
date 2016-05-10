package br.com.unirn.poo.util;

import java.io.IOException;

import br.com.unirn.poo.arquivo.Arquivo;

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
		try {
			Arquivo.salvarObjetos();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Volte sempre!");
		System.exit(0);
	}

}

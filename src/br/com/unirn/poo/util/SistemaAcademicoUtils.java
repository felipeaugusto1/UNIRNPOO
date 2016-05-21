package br.com.unirn.poo.util;

import java.io.IOException;

import br.com.unirn.poo.dao.DAO;
import br.com.unirn.poo.modelo.Usuario;
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

}

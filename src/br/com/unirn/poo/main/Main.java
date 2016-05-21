package br.com.unirn.poo.main;

import br.com.unirn.poo.menu.Menu;
import br.com.unirn.poo.singleton.ListasSingleton;

/**
 * 
 * @author felipe
 *
 */
public class Main {

	public static void main(String[] args) {
		
		ListasSingleton.getInstance().recupearObjetos();
		new Menu();

	}

}

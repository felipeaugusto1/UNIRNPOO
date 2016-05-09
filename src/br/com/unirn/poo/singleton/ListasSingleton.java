package br.com.unirn.poo.singleton;

import java.util.ArrayList;
import java.util.List;

import br.com.unirn.poo.modelo.Usuario;

/**
 * Classe que utiliza padrão Singleton, para no final de todo o processamento,
 * recuperar todas as listas cadastradas dos outros processadores, e gravar em
 * um arquivo.
 * 
 * @author felipe
 *
 */
public class ListasSingleton {

	private List<Usuario> listaUsuario = new ArrayList<Usuario>();

	private static ListasSingleton listasSingleton = null;

	public static ListasSingleton getInstance() {
		if (listasSingleton == null)
			listasSingleton = new ListasSingleton();
		return listasSingleton;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

}

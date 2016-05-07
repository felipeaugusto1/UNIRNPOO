package br.com.unirn.poo.singleton;

/**
 * Classe que utiliza padrão Singleton, para no final de todo o processamento,
 * recuperar todas as listas cadastradas dos outros processadores, e gravar em
 * um arquivo.
 *
 */
public final class Processador {

	private static final Processador processador = new Processador();

	public static Processador getInstance() {
		return processador;
	}
	
	// implementar o resto

}

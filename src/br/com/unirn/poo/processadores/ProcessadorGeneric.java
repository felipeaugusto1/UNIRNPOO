package br.com.unirn.poo.processadores;

import java.util.Collection;

/**
 * Interface processador de qual todas as classes processadores devem implementar.
 * 
 * @author allan
 *
 * @param <T>
 */
public  interface ProcessadorGeneric<T> {
	
	public abstract void cadastrar (T obj, Collection<T> listaDeObjetos);
	
	public abstract boolean validate(T obj) throws Exception;
	
}

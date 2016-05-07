package br.com.unirn.poo.processadores;

import java.util.Collection;

/**
 * Porcessador de qual todas as classes processadores devem exxtender.
 * 
 * @author allan
 *
 * @param <T>
 */
public  abstract class ProcessadorGeneric<T> {
	
	public abstract void cadastrar (T obj, Collection<T> listaDeObjetos);
	
	public abstract  boolean validate(T obj);
	
}

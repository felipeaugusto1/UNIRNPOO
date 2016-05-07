package br.com.unirn.poo.processadores;

import java.util.Collection;

import br.com.unirn.poo.modelo.Usuario;

public class ProcessadorUsuario extends ProcessadorGeneric<Usuario> {

	public ProcessadorUsuario() {}

	@Override
	public void cadastrar(Usuario obj, Collection<Usuario> listaDeObjetos) {
		listaDeObjetos.add(obj);
	}

	@Override
	public boolean validate(Usuario obj) {
		// TODO Auto-generated method stub
		return false;
	}

}

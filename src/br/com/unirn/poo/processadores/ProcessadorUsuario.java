package br.com.unirn.poo.processadores;

import java.util.Collection;

import br.com.unirn.poo.excecoes.CPFInvalidoException;
import br.com.unirn.poo.modelo.Usuario;
import br.com.unirn.poo.singleton.ListasSingleton;
import br.com.unirn.poo.util.ValidadorCPF;

public class ProcessadorUsuario implements ProcessadorGeneric<Usuario> {

	@Override
	public void cadastrar(Usuario obj, Collection<Usuario> listaDeObjetos) {
		listaDeObjetos.add(obj);
	}
	
	@Override
	public boolean validate(Usuario obj) throws CPFInvalidoException {
		if (!ValidadorCPF.isCPF(obj.getCpf()))
			throw new CPFInvalidoException("CPF inválido, tente novamente.");
		
		return (!obj.getCpf().isEmpty() && !obj.getLogin().isEmpty() && !obj.getLogin().isEmpty()
				&& !obj.getNome().isEmpty() && !obj.getSenha().isEmpty() && !obj.getTelefone().isEmpty());
	}

}

package br.com.unirn.poo.processadores;

import java.util.Collection;

import br.com.unirn.poo.modelo.Professor;

public class ProcessadorProfessor extends ProcessadorGeneric<Professor> {

	@Override
	public void cadastrar(Professor obj, Collection<Professor> listaDeObjetos) {
		listaDeObjetos.add(obj);
	}

	@Override
	public boolean validate(Professor obj) {
		return (!obj.getCpf().isEmpty() && !obj.getMatricula().isEmpty() && !obj.getNome().isEmpty()
				&& !obj.getTelefone().isEmpty());
	}

}

package br.com.unirn.poo.processadores;

import java.util.Collection;

import br.com.unirn.poo.modelo.Aluno;

public class ProcessadorAluno extends ProcessadorGeneric<Aluno> {

	@Override
	public void cadastrar(Aluno obj, Collection<Aluno> listaDeObjetos) {
		listaDeObjetos.add(obj);
	}

	@Override
	public boolean validate(Aluno obj) {
		return (!obj.getCpf().isEmpty() && !obj.getMatricula().isEmpty() && !obj.getNome().isEmpty()
				&& !obj.getTelefone().isEmpty() && !obj.getCurso().isEmpty());
	}

}

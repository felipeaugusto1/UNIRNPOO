package br.com.unirn.poo.processadores;

import java.util.Collection;

import br.com.unirn.poo.modelo.Turma;

public class ProcessadorTurma implements ProcessadorGeneric<Turma>{

	@Override
	public void cadastrar(Turma obj, Collection<Turma> listaDeObjetos) {
		listaDeObjetos.add(obj);
		
	}

	@Override
	public boolean validate(Turma obj) throws Exception {
		return (obj.getCodigo() > 0 && obj.getDisciplina() != null && obj.getProfessores() != null
				&& !obj.getProfessores().isEmpty() && obj.getAlunos() != null && !obj.getAlunos().isEmpty());
	}
	
	

}

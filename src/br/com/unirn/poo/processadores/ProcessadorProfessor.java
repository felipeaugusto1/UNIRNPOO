package br.com.unirn.poo.processadores;

import java.util.Collection;

import br.com.unirn.poo.expcetions.CPFInvalidoException;
import br.com.unirn.poo.modelo.Professor;
import br.com.unirn.poo.util.ValidadorCPF;

public class ProcessadorProfessor extends ProcessadorGeneric<Professor> {

	@Override
	public void cadastrar(Professor obj, Collection<Professor> listaDeObjetos) {
		listaDeObjetos.add(obj);
	}

	@Override
	public boolean validate(Professor obj) throws CPFInvalidoException {
		if (!ValidadorCPF.isCPF(obj.getCpf()))
			throw new CPFInvalidoException("CPF inválido, tente novamente.");
		
		return (!obj.getCpf().isEmpty() && !obj.getMatricula().isEmpty() && !obj.getNome().isEmpty()
				&& !obj.getTelefone().isEmpty());
	}

}

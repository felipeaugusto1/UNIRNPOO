package br.com.unirn.poo.processadores;

import java.util.Collection;

import br.com.unirn.poo.expcetions.CPFInvalidoException;
import br.com.unirn.poo.modelo.Aluno;
import br.com.unirn.poo.util.ValidadorCPF;

public class ProcessadorAluno extends ProcessadorGeneric<Aluno> {

	@Override
	public void cadastrar(Aluno obj, Collection<Aluno> listaDeObjetos) {
		listaDeObjetos.add(obj);
	}

	@Override
	public boolean validate(Aluno obj) throws CPFInvalidoException {
		if (!ValidadorCPF.isCPF(obj.getCpf()))
			throw new CPFInvalidoException("CPF inválido, tente novamente.");
		
		return (!obj.getCpf().isEmpty() && !obj.getMatricula().isEmpty() && !obj.getNome().isEmpty()
				&& !obj.getTelefone().isEmpty() && !obj.getCurso().isEmpty());
	}

}

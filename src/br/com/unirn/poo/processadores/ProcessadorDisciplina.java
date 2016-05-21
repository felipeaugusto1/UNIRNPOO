package br.com.unirn.poo.processadores;

import java.util.Collection;

import br.com.unirn.poo.excecoes.CPFInvalidoException;
import br.com.unirn.poo.modelo.Disciplina;

public class ProcessadorDisciplina implements ProcessadorGeneric<Disciplina> {

	@Override
	public void cadastrar(Disciplina obj, Collection<Disciplina> listaDeObjetos) {
		listaDeObjetos.add(obj);
	}

	@Override
	public boolean validate(Disciplina obj) throws CPFInvalidoException {
		return (!obj.getNome().isEmpty() && !obj.getSigla().isEmpty());
	}

}

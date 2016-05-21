package br.com.unirn.poo.processadores;

import java.util.Collection;

import br.com.unirn.poo.excecoes.CPFInvalidoException;
import br.com.unirn.poo.modelo.Projetor;

public class ProcessadorProjetor implements ProcessadorGeneric<Projetor> {

	@Override
	public void cadastrar(Projetor obj, Collection<Projetor> listaDeObjetos) {
		listaDeObjetos.add(obj);
	}

	@Override
	public boolean validate(Projetor obj) throws CPFInvalidoException {
		return (!obj.getMarca().isEmpty() && !obj.getModelo().isEmpty() && !obj.getTombo().isEmpty());
	}

}

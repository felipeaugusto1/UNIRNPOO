package br.com.unirn.poo.processadores;

import java.util.Collection;

import br.com.unirn.poo.modelo.Aplicativo;
import br.com.unirn.poo.singleton.ListasSingleton;

public class ProcessadorAplicativo implements  ProcessadorGeneric<Aplicativo>{

	@Override
	public void cadastrar(Aplicativo obj, Collection<Aplicativo> listaDeObjetos) {
		listaDeObjetos.add(obj);
	}

	@Override
	public boolean validate(Aplicativo obj) {
		return ListasSingleton.getInstance().getListaAplicativo().stream().filter(
				func -> func.getNome().equals(obj.getNome())
				).count() == 0;
	}

}

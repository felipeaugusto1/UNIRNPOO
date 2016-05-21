package br.com.unirn.poo.processadores;

import java.util.Collection;

import br.com.unirn.poo.modelo.Aplicativo;

public class ProcessadorAplicativo implements  ProcessadorGeneric<Aplicativo>{

	@Override
	public void cadastrar(Aplicativo obj, Collection<Aplicativo> listaDeObjetos) {
		listaDeObjetos.add(obj);
	}

	@Override
	public boolean validate(Aplicativo obj) {
		// TODO Auto-generated method stub
		return true;
	}

}

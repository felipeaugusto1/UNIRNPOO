package br.com.unirn.poo.processadores;

import java.util.Collection;

import br.com.unirn.poo.modelo.Reserva;

public class ProcessadorReserva implements ProcessadorGeneric<Reserva> {

	@Override
	public void cadastrar(Reserva obj, Collection<Reserva> listaDeObjetos) {
		listaDeObjetos.add(obj);
		
	}

	@Override
	public boolean validate(Reserva obj) throws Exception {
		return (obj.getLocalAula() != null || obj.getTurma() != null);
	}

}

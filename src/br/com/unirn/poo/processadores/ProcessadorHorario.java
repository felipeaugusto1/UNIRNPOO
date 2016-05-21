package br.com.unirn.poo.processadores;

import java.util.Collection;

import br.com.unirn.poo.modelo.Horario;

public class ProcessadorHorario implements ProcessadorGeneric<Horario> {

	@Override
	public void cadastrar(Horario obj, Collection<Horario> listaDeObjetos) {
		listaDeObjetos.add(obj);
	}

	@Override
	public boolean validate(Horario obj) throws Exception {
		return (!obj.getHoraInicio().isEmpty() && !obj.getHoraFim().isEmpty());
	}

}

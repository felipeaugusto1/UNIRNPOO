package br.com.unirn.poo.processadores;

import java.util.Calendar;
import java.util.Collection;

import br.com.unirn.poo.excecoes.HorarioInvalidoException;
import br.com.unirn.poo.modelo.Horario;

public class ProcessadorHorario implements ProcessadorGeneric<Horario> {

	private final int HORA_INICIO_MIN = 00;
	private final int HORA_INICIO_MAX = 23;
	private final int MIN_INICIO_MIN = 00;
	private final int MIN_INICIO_MAX = 59;
	
	@Override
	public void cadastrar(Horario obj, Collection<Horario> listaDeObjetos) {
		listaDeObjetos.add(obj);
	}

	@Override
	public boolean validate(Horario obj) throws HorarioInvalidoException, NumberFormatException {
		int horaHoraInicioInicio = Integer.parseInt(obj.getHoraInicio().substring(0, 2));
		String delimitadorHorarioInicio = obj.getHoraInicio().substring(2, 3);
		int minutoHoraFimInicio = Integer.parseInt(obj.getHoraInicio().substring(3, 5));
		
		int horaHoraInicioFim = Integer.parseInt(obj.getHoraFim().substring(0, 2));
		String delimitadorHorarioFim = obj.getHoraFim().substring(2, 3);
		int minutoHoraFimFim = Integer.parseInt(obj.getHoraFim().substring(3, 5));
		
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.AM_PM, 0);
		c1.set(Calendar.HOUR, horaHoraInicioInicio);
		c1.set(Calendar.MINUTE, minutoHoraFimInicio);
		
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.AM_PM, 0);
		c2.set(Calendar.HOUR, horaHoraInicioFim);
		c2.set(Calendar.MINUTE, minutoHoraFimFim);
		
		if (horaHoraInicioInicio > HORA_INICIO_MAX || horaHoraInicioInicio < HORA_INICIO_MIN || 
				horaHoraInicioFim > HORA_INICIO_MAX || horaHoraInicioFim < HORA_INICIO_MIN) {
			throw new HorarioInvalidoException("Horário inválido! Horas permitidas apenas: 00 a 23.");
		} else if (minutoHoraFimInicio > MIN_INICIO_MAX || minutoHoraFimInicio < MIN_INICIO_MIN || 
				minutoHoraFimFim > MIN_INICIO_MAX || minutoHoraFimFim < MIN_INICIO_MIN) {
			throw new HorarioInvalidoException("Horário inválido! Minutos permitidos apenas: de 00 a 59.");
		} else if (c1.getTime() .after(c2.getTime())) {
			throw new HorarioInvalidoException("Horário inválida! Hora inicial é posterior que hora final.");
		} else if (obj.getHoraInicio().length() == 5 && obj.getHoraFim().length() == 5 && delimitadorHorarioInicio.equals(":") && delimitadorHorarioFim.equals(":")) {
			return true;
		} else {
			throw new HorarioInvalidoException("Horário inválido! Por favor, tente novamente. Formato: hh:mm");
		}
			
		
	}

}

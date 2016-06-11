package br.com.unirn.poo.modelo;

import java.io.Serializable;

public class Horario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4731334340337773085L;
	private Turno turno;
	private String horaInicio;
	private String horaFim;
	private DiaSemana diaSemana;

	public Horario(Turno turno, String horaInicio, String horaFim, DiaSemana diaSemana) {
		super();
		this.turno = turno;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.diaSemana = diaSemana;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaSemana == null) ? 0 : diaSemana.hashCode());
		result = prime * result + ((horaFim == null) ? 0 : horaFim.hashCode());
		result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
		result = prime * result + ((turno == null) ? 0 : turno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horario other = (Horario) obj;
		if (diaSemana != other.diaSemana)
			return false;
		if (horaFim == null) {
			if (other.horaFim != null)
				return false;
		} else if (!horaFim.equals(other.horaFim))
			return false;
		if (horaInicio == null) {
			if (other.horaInicio != null)
				return false;
		} else if (!horaInicio.equals(other.horaInicio))
			return false;
		if (turno != other.turno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Horario [turno=" + turno + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim + ", diaSemana="
				+ diaSemana + "]";
	}

}

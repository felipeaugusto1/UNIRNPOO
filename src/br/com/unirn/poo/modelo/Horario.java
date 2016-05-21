package br.com.unirn.poo.modelo;

import java.io.Serializable;

public class Horario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4731334340337773085L;
	private Turma turma;
	private Turno turno;
	private String horaInicio;
	private String horaFim;
	private DiaSemana diaSemana;

	public Horario(Turma turma, Turno turno, String horaInicio, String horaFim, DiaSemana diaSemana) {
		super();
		this.turma = turma;
		this.turno = turno;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.diaSemana = diaSemana;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
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

}

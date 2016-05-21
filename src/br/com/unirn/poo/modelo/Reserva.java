package br.com.unirn.poo.modelo;

import java.io.Serializable;
import java.util.Date;

public class Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8592930016275445789L;
	private boolean usaProjetor;
	private boolean ativo;
	private Date data;
	private Turma turma;
	private LocalAula localAula;

	public boolean isUsaProjetor() {
		return usaProjetor;
	}

	public void setUsaProjetor(boolean usaProjetor) {
		this.usaProjetor = usaProjetor;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public LocalAula getLocalAula() {
		return localAula;
	}

	public void setLocalAula(LocalAula localAula) {
		this.localAula = localAula;
	}

}

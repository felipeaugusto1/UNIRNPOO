package br.com.unirn.poo.modelo;

import java.io.Serializable;

public class LocalAula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2857158367981949918L;
	private String bloco;
	private int capacidadeAlunos;

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public int getCapacidadeAlunos() {
		return capacidadeAlunos;
	}

	public void setCapacidadeAlunos(int capacidadeAlunos) {
		this.capacidadeAlunos = capacidadeAlunos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bloco == null) ? 0 : bloco.hashCode());
		result = prime * result + capacidadeAlunos;
		if (this instanceof Sala) {
			result += prime * result + (((Sala) this) == null ? 0 : ((Sala) this).getNumero());
		}
		if (this instanceof Laboratorio) {
			result += prime * result + (((Laboratorio) this) == null ? 0 : ((Laboratorio) this).getNome().hashCode());
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LocalAula))
			return false;
		LocalAula other = (LocalAula) obj;
		if (bloco == null) {
			if (other.bloco != null)
				return false;
		} else if (!bloco.equals(other.bloco))
			return false;
		if (capacidadeAlunos != other.capacidadeAlunos)
			return false;
		if (this instanceof Sala) {
			if (!(obj instanceof Sala))
				return false;
			else {
				return ((Sala) this).getNumero() == ((Sala) obj).getNumero();
			}
		}
		if (this instanceof Laboratorio) {
			if (!(obj instanceof Laboratorio))
				return false;
			else {
				return ((Laboratorio) this).getNome().equals(((Laboratorio) obj).getNome());
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "LocalAula [bloco=" + bloco + ", capacidadeAlunos=" + capacidadeAlunos + "]";
	}

}

package br.com.unirn.poo.modelo;

import java.io.Serializable;

public class Projetor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3313072518388367758L;
	private String marca;
	private String modelo;
	private String tombo;

	public Projetor(String marca, String modelo, String tombo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.tombo = tombo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTombo() {
		return tombo;
	}

	public void setTombo(String tombo) {
		this.tombo = tombo;
	}

}

package br.com.unirn.poo.modelo;

import java.io.Serializable;

public class Usuario extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5025987618864563678L;
	private String login;
	private String senha;
	private TipoUsuario tipoUsuario;

	public Usuario() {

	}

	public Usuario(String nome, String cpf, String telefone, String login, String senha, TipoUsuario tipoUsuario) {
		super(nome, cpf, telefone);
		this.login = login;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", tipoUsuario=" + tipoUsuario + "]";
	}

}

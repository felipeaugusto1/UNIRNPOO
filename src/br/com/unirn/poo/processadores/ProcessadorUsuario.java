package br.com.unirn.poo.processadores;

import java.util.ArrayList;
import java.util.List;

import br.com.unirn.poo.modelo.Usuario;

public class ProcessadorUsuario {

	private List<Usuario> listaUsuarios;

	public ProcessadorUsuario() {
		this.listaUsuarios = new ArrayList<>();
	}

	public Usuario cadastrarUsuario(Usuario usuario) {
		if (this.listaUsuarios.add(usuario))
			return usuario;
		return null;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

}

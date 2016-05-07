package br.com.unirn.poo.processadores;

import java.util.List;

import br.com.unirn.poo.modelo.Usuario;

public class ProcessadorUsuario {
	
	private List<Usuario> listaUsuarios;
	
	private Usuario cadastrarUsuario(Usuario usuario) {
		if (this.listaUsuarios.add(usuario))
			return usuario;
		return null;
	}

}

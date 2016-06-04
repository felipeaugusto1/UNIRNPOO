package br.com.unirn.poo.singleton;

import br.com.unirn.poo.modelo.Usuario;

/**
 * 
 * @author felipe
 *
 */
public class UsuarioSingleton {

	private static UsuarioSingleton usuarioSingleton = null;

	private Usuario usuario = null;

	public static UsuarioSingleton getInstance() {
		if (usuarioSingleton == null)
			usuarioSingleton = new UsuarioSingleton();
		return usuarioSingleton;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}

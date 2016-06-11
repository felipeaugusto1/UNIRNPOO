package br.com.unirn.poo.menu;

import java.util.Scanner;

import br.com.unirn.poo.modelo.Usuario;
import br.com.unirn.poo.processadores.ProcessadorUsuario;
import br.com.unirn.poo.singleton.ListasSingleton;
import br.com.unirn.poo.singleton.UsuarioSingleton;
import br.com.unirn.poo.util.SistemaAcademicoUtils;

/**
 * 
 * @author felipe
 *
 */
public class MenuLogin extends MenuGeneric<Usuario> {

	private String usuario;
	private String senha;

	public MenuLogin() {
		super();
		processador = new ProcessadorUsuario();

		if (ListasSingleton.getInstance().getListaUsuario().isEmpty()) {
			new MenuUsuario();
		} else if (UsuarioSingleton.getInstance().getUsuario() != null) {
			new Menu();
		} else {
			System.out.println("**** OBS ****");
			System.out.println(
					"Se não souber o(s) usuário(s) cadastrado(s) apagar o conteúdo do arquivo Usuario.txt em base_de_objetos, e reexecutar o projeto.");
			montarMenu();
		}
	}

	@Override
	public void montarMenu() {
		System.out.println("-------------------");
		System.out.println("-------Login-------");
		System.out.println("-------------------");

		System.out.println("Informe o usuario: ");
		usuario = scanner.nextLine();

		System.out.println("Informe a senha: ");
		senha = scanner.nextLine();

		Usuario u = new Usuario();
		u.setLogin(usuario);
		u.setSenha(senha);

		Usuario usuario = buscarLogin(u);

		if (usuario != null) {
			UsuarioSingleton.getInstance().setUsuario(usuario);
			new Menu();
		} else {
			opcaoInvalida();
		}
	}

	public Usuario buscarLogin(Usuario usuario) {
		for (Usuario u : ListasSingleton.getInstance().getListaUsuario()) {
			if (u.getLogin().equals(usuario.getLogin()) && u.getSenha().equals(usuario.getSenha()))
				return u;
		}

		return null;
	}

	@Override
	public void opcaoInvalida() {
		System.out.println("\n Usuário não encontrado. Tente novamente. \n");
		SistemaAcademicoUtils.esperarSegundos();
		scanner = new Scanner(System.in);

		montarMenu();
	}

}

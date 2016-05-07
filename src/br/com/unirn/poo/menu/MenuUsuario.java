package br.com.unirn.poo.menu;

import java.util.Scanner;

import br.com.unirn.poo.modelo.TipoUsuario;
import br.com.unirn.poo.modelo.Usuario;
import br.com.unirn.poo.processadores.ProcessadorUsuario;

public class MenuUsuario extends MenuGeneric {

	private ProcessadorUsuario processadorUsuario;

	private String nome;
	private String cpf;
	private String telefone;
	private String login;
	private String senha;
	private TipoUsuario tipoUsuario;

	public MenuUsuario() {
		super();
		processadorUsuario = new ProcessadorUsuario();
		
		montarMenu();
	}

	public void montarMenu() {
		System.out.println("-------------------");

		System.out.println("Informe o nome do usuario: ");
		nome = scanner.nextLine();

		System.out.println("Informe o CPF do usuario: ");
		cpf = scanner.nextLine();

		System.out.println("Informe o telefone do usuario: ");
		telefone = scanner.nextLine();

		System.out.println("Informe o login do usuario: ");
		login = scanner.nextLine();

		System.out.println("Informe a senha do usuario: ");
		senha = scanner.nextLine();

		montarMenuTipoUsuario();

		Usuario usuario = new Usuario(nome, cpf, telefone, login, senha, tipoUsuario);

		Usuario usuarioTemp = processadorUsuario.cadastrarUsuario(usuario);

		if (usuarioTemp != null)
			System.out.println("Usuário cadastrado com sucesso!");
		else
			System.out.println("Ocorreu algum erro ao realizar o cadastro.");
	}

	private void montarMenuTipoUsuario() {
		int tipoUsuarioInformado;

		System.out.println("Tipo do Usuario: ");
		System.out.println("1 - Administrador");
		System.out.println("2 - Coordenador");
		System.out.println("3 - Secretário");

		tipoUsuarioInformado = scanner.nextInt();

		switch (tipoUsuarioInformado) {
		case 1:
			tipoUsuario = TipoUsuario.ADMINISTRADOR;
			break;
		case 2:
			tipoUsuario = TipoUsuario.COORDENADOR;
			break;
		case 3:
			tipoUsuario = TipoUsuario.SECRETARIO;
			break;

		}
	}

}

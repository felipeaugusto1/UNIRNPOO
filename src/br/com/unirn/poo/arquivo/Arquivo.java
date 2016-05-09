package br.com.unirn.poo.arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

import br.com.unirn.poo.modelo.Usuario;
import br.com.unirn.poo.singleton.ListasSingleton;

/**
 * Classe para manipular arquivos que aramazenarão os dados gerado no sistema.
 *
 * @author allan
 *
 */
public class Arquivo {
	
	private static final String  localArquivo = "objetos.txt";
	
	public static void salvarObjetos() throws IOException{
		FileOutputStream file = new FileOutputStream(localArquivo);
		ObjectOutputStream stream = new ObjectOutputStream(file);
		
		for (Usuario user : ListasSingleton.getInstance().getListaUsuario()){
			stream.writeObject(user);
		}
		
		stream.close();
	}
	
	public static void restaurarArquivo(){
		
	}
}

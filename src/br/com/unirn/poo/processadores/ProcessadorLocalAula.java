package br.com.unirn.poo.processadores;

import java.util.Collection;

import br.com.unirn.poo.modelo.Laboratorio;
import br.com.unirn.poo.modelo.LocalAula;
import br.com.unirn.poo.modelo.Sala;

public class ProcessadorLocalAula implements ProcessadorGeneric<LocalAula> {

	@Override
	public void cadastrar(LocalAula obj, Collection<LocalAula> listaDeObjetos) {

		listaDeObjetos.add(obj);
		
	}

	@Override
	public boolean validate(LocalAula obj) throws Exception {

		if (obj instanceof Sala)
			return ((Sala)obj).getNumero() > 0;
		if (obj instanceof Laboratorio)
			return !((Laboratorio) obj).getNome().isEmpty()
					&& (((Laboratorio) obj).getProjetor() != null || (((Laboratorio) obj).getAplicativos() != null
																		&& !((Laboratorio) obj).getAplicativos().isEmpty())) 
					&& !((Laboratorio) obj).getNome().isEmpty();	
		return (!obj.getBloco().isEmpty() && obj.getCapacidadeAlunos() > 0);
		
	}
	
	

}

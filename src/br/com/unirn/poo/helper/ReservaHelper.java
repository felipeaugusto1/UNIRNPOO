package br.com.unirn.poo.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.com.unirn.poo.modelo.Laboratorio;
import br.com.unirn.poo.modelo.LocalAula;
import br.com.unirn.poo.modelo.Reserva;
import br.com.unirn.poo.modelo.Sala;
import br.com.unirn.poo.modelo.Turma;
import br.com.unirn.poo.singleton.ListasSingleton;

public class ReservaHelper {
	
	public static Collection<Turma> getTurmasSemReserva (Collection<Turma> turmas, Collection<Reserva> reservas){
		Map<Integer, Turma> mapaTurmasReservadas = new HashMap<>();
		
		for (Reserva r : reservas){
			mapaTurmasReservadas.put(r.getTurma().getCodigo(), r.getTurma());
		}
		
		Iterator<Turma> iturma = turmas.iterator();
		while (iturma.hasNext()){
			if (mapaTurmasReservadas.containsKey(iturma.next().getCodigo())){
				iturma.remove();
			}
		}
		return turmas;
	}
	
	public static void listarTurmas(Collection<Turma> turmas){
		int i = 1;
		for (Turma t : turmas){
			System.out.println(i + " : " + t.getCodigo() + " - "  + t.getDisciplina().getNome());
			i++;
		}
	}
	
	public static List<LocalAula> getLaboratoriosSemReserva (Turma turma){
		List<LocalAula> locais = new ArrayList<LocalAula>();
		for (LocalAula lc : ListasSingleton.getInstance().getListaLocalAula()){
			if (lc instanceof Laboratorio){
				locais.add(lc);
			}
		}
		
		List<LocalAula> locaisNaoPermitidos = new ArrayList<LocalAula>();
		for (Reserva r : ListasSingleton.getInstance().getListaReserva()){
			if (r.getTurma().getHorario().equals(turma.getHorario()))
				locaisNaoPermitidos.add(r.getLocalAula());
		}
		
		
		return locais;
	}
	
	public static List<LocalAula> getSalas (){
		List<LocalAula> locais = new ArrayList<LocalAula>();
		for (LocalAula lc : ListasSingleton.getInstance().getListaLocalAula()){
			if (lc instanceof Sala){
				locais.add(lc);
			}
		}
		return locais;
	}
	
	public static void listarLocais (Collection<LocalAula> locais){
		int i = 1;
		for (LocalAula l : locais){
			if (l instanceof Laboratorio){
				System.out.println(i + " : " + ((Laboratorio) l).getNome());
			} else {
				System.out.println(i + " :  Sala " + ((Sala) l).getNumero());
			}
		}
	}
	
	public static List<LocalAula> getLocaisDisponiveis (Collection<Reserva> reservasSalvas){
		
		
		return null;
	}
}

package br.com.unirn.poo.helper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import br.com.unirn.poo.modelo.Reserva;
import br.com.unirn.poo.modelo.Turma;

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
}

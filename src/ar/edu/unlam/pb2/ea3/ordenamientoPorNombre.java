package ar.edu.unlam.pb2.ea3;

import java.util.Comparator;

public class ordenamientoPorNombre implements Comparator<Jugador>{

	@Override
	public int compare(Jugador o1, Jugador o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareTo(o2.getNombre());
	}

}

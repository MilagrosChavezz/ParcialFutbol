package ar.edu.unlam.pb2.ea3;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class EquipoDeFutbol {

	private String nombre;
	private Set<Jugador> jugadores;
	private static final Integer CAPACIDAD_MAXIMA_EQUIPO = 23;

	public EquipoDeFutbol(String nombre) {
		super();
		this.nombre = nombre;
		this.jugadores = new HashSet<>();
	}

	/*
	 * La capacidad m�xima de un equipo es 23. Cualquier intento de agregar m�s
	 * jugadores generar� una excepci�n (CapacidadMaximaException). Adem�s, no
	 * deber� permitir duplicar Jugadores (JugadorDuplicadoException).
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public static Integer getCapacidadMaximaEquipo() {
		return CAPACIDAD_MAXIMA_EQUIPO;
	}

	public Boolean noExcedeCantidadMaxima() throws CapacidadMaximaException {
		if (CAPACIDAD_MAXIMA_EQUIPO > jugadores.size()) {
			return true;
		}
		throw new CapacidadMaximaException();
	}

	public Boolean seAgregaJugador(Jugador jugador) throws JugadorDuplicadoException {
		if (jugadores.add(jugador)) {
			return true;
		}
		throw new JugadorDuplicadoException();
	}

	public void agregarJugador(Jugador jugador) throws CapacidadMaximaException, JugadorDuplicadoException {

		if (noExcedeCantidadMaxima()) {
			seAgregaJugador(jugador);
		}
		;

	}

	/*
	 * Permite cambiar cualquier jugador. Un intento de cambiar un jugador no
	 * presente en el equipo generar� una excepci�n (JugadoreInexistenteException).
	 */

	public Boolean jugadorExistente(Jugador saliente) throws JugadoreInexistenteException {
		if (jugadores.contains(saliente)) {
			return true;
		}
		throw new JugadoreInexistenteException();
	}

	public Boolean cambiarJugador(Jugador saliente, Jugador entrante) throws JugadoreInexistenteException {

		if (jugadorExistente(saliente) && jugadorExistente(entrante)) {
			return true;
		}
		return false;
	}

	public TreeSet<Jugador> devolverPlanteOrdenadoPorNombreDeJugador() {

		TreeSet<Jugador> plantelOrdenadoPorNombre = new TreeSet<>(new ordenamientoPorNombre());

		plantelOrdenadoPorNombre.addAll(jugadores);
		return plantelOrdenadoPorNombre;
	}

	public TreeSet<Jugador> devolverPlanteOrdenadoPorPrecioDeCompraDeJugador() {
		TreeSet<Jugador> plantelOrdenadoPorPrecioDeCompra = new TreeSet<>(new ordenamientoPorCompra());

		plantelOrdenadoPorPrecioDeCompra.addAll(jugadores);
		return plantelOrdenadoPorPrecioDeCompra;
	}

	public TreeSet<Jugador> devolverPlanteOrdenadoPorNumeroDeCamisetaDeJugador() {
		TreeSet<Jugador> plantelOrdenadoPorNroCamiseta = new TreeSet<>(new ordenamientoPorNroCamiseta());

		plantelOrdenadoPorNroCamiseta.addAll(jugadores);
		
		return plantelOrdenadoPorNroCamiseta;
	}

}

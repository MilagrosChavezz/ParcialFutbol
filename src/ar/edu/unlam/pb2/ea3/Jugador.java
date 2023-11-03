package ar.edu.unlam.pb2.ea3;

import java.util.Objects;

public class Jugador {
	
	private Integer numCamiseta;
	private String nombre;
	private Integer valorJugador;
	
	
	public Jugador(Integer numCamiseta, String nombre, Integer valorJugador) {
		super();
		this.numCamiseta = numCamiseta;
		this.nombre = nombre;
		this.valorJugador = valorJugador;
	}



	public Integer getNumCamiseta() {
		return numCamiseta;
	}


	public void setNumCamiseta(Integer numCamiseta) {
		this.numCamiseta = numCamiseta;
	}



	public Integer getValorJugador() {
		return valorJugador;
	}


	public void setValorJugador(Integer valorJugador) {
		this.valorJugador = valorJugador;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(nombre, other.nombre);
	}


	
	

}

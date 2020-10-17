package juegoTP;

import java.util.ArrayList;

public abstract class Carta{
	
	

	private String nombre;
	private int puntajeFuerza;
	private String descEfecto;

	public Carta(String nombre, int puntajeFuerza, String descEfecto) {
		this.nombre = nombre;
		this.puntajeFuerza = puntajeFuerza;
		this.descEfecto = descEfecto;
	}
	

	public int compararCarta(Carta c2) {		///Compara los puntajes de las cartas y retorna un numero entero indicando quien es el mayor
		 return this.getPuntajeFuerza() - c2.getPuntajeFuerza();
		
    }
	
	public abstract boolean activarEfecto(Jugador jugador, ArrayList<Jugador> listaJugadores, Descarte d, Mazo m);

	public int getPuntajeFuerza() {
		return puntajeFuerza;
	}


	@Override
	public String toString() {
		return "\nCarta " + nombre + "\nPuntajeFuerza = " + puntajeFuerza + "\nDescripcion Efecto = " + descEfecto;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + puntajeFuerza;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		if (puntajeFuerza != other.puntajeFuerza)
			return false;
		return true;
	}
	
	
}

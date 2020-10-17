package juegoTP;

import java.util.ArrayList;

public class Princesa extends Carta{

	public Princesa() {
		super("Princesa", 8, "Si un jugador juega o descarta esta carta por cualquier motivo, ese jugador es eliminado de la ronda");
	}

	@Override
	public boolean activarEfecto(Jugador jugador, ArrayList<Jugador> listaJugadores, Descarte d, Mazo m) {
		jugador.setEstado("Fuera de Ronda");
		
		return true;
	}
	
}

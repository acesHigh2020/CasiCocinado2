package juegoTP;

import java.util.ArrayList;

public class Condesa extends Carta{

	public Condesa() {	
		super("Condesa",7,"Si un jugador tiene esta carta y el Rey o el Príncipe, esta carta debe ser jugada inmediatamente");
	}

	@Override
	public boolean activarEfecto(Jugador jugador, ArrayList<Jugador> listaJugadores, Descarte d, Mazo m) {
		///ESTE EFECTO NO SE ACTIVA NUNCA PORQUE YA ESTA PREDEFINIDO EN LA CLASE JUGADOR
		return false;
	}

}

package juegoTP;

import java.util.ArrayList;

public class Ronda extends Observable{
	private ArrayList<Jugador> jugadoresActivos;
	private int turnoDeJugador;
	private Mazo mazo;
	private Descarte descarte;
	
	/*
	 * Inicializa la ronda con la lista de jugadores proveniente del partido,
	 * el jugador que empieza la ronda y una instancia de Mazo.
	 */
	public Ronda(ArrayList<Jugador> jugadores) {
		this.jugadoresActivos = new ArrayList<Jugador>(jugadores); 
		turnoDeJugador = 0;
		mazo = new Mazo();
		descarte = new Descarte();
	}
	
	
	public void registrar(Partida partida) {
		registrar(partida);
	}
	
	public void registrar(Jugador jugador) {
		registrar(jugador);
	}
	
	/*
	 * Elimina de la lista de jugadores activos al perdedor
	 */
	public boolean eliminarJugador(Jugador jugador) {
		return jugadoresActivos.remove(jugador);
	}
	
	/*
	 * Se actualiza la ronda, es decir, esta jugando una nueva persona.
	 * El jugador realiza la jugada dentro del actualizar
	 * Si la partida solo tiene un jugador o se termino el mazo, se determina al ganador.
	 */	
	public void actualizar() {
		
		int index = 0;
		
		if (jugadoresActivos.size() > 1 && mazo.getCantidadCartas() > 0) {
			for (Jugador jugador : jugadoresActivos) {
				if(turnoDeJugador == index) {
					
					///si se aprico un efecto y quedo fuera un jugador se lo elimina aca
					if (jugador.getEstado() == "Fuera de Ronda") {
						eliminarJugador(jugador);
					}
					else {
						//deja de ser inmune cuando dio toda la vuelta
						if (jugador.getEstado() == "Inmune")
							jugador.setEstado("Jugando");
						
						jugador.jugada(mazo, jugadoresActivos, descarte);
					}
						
					if (turnoDeJugador < jugadoresActivos.size())
						turnoDeJugador++;
					else
						turnoDeJugador = 0;
				}
				
				index++;
			}
		}
		else {
			if (jugadoresActivos.size() > 1)
				determinarGanador();
			notificar();
		}
	}
	
	/*
	 * Elimina a los jugadores que no cumplan con la mayor cantidad de cartas tiradas, 
	 * solo quedando dentro del array el jugador ganador. 
	 * Luego notifica al observador que hubo un cambio en ronda
	 */
	public void determinarGanador() {
		int mayor = 0;
		//Determino si hay solo una persona con mayor fuerza de carta
		for (Jugador jugador : jugadoresActivos) {
			if (mayor < (jugador.getCartaMano().getPuntajeFuerza()))
				mayor = jugador.getCartaMano().getPuntajeFuerza();
		}
		
		//Elimino a los que no tienen esa carta de mayor fuerza
		for (Jugador jugador : jugadoresActivos) {
			if (mayor != (jugador.getCartaMano().getPuntajeFuerza()))
				eliminarJugador(jugador);
		}
		
		//Pregunto si tengo que desempatar todavia y sino busco por las cartas tiradas
		if (jugadoresActivos.size() > 1)
		{
			mayor = 0;
			for (Jugador jugador : jugadoresActivos) {
				
				if (mayor < jugador.getCartasTiradas())
					mayor = jugador.getCartasTiradas();			
			}
			
			for (Jugador jugador : jugadoresActivos) {
				if (mayor != jugador.getCartasTiradas())
					eliminarJugador(jugador);
			}
		}
	}
	
}
package juegoTP;

import java.util.LinkedList;

public class Observable {
	
	private LinkedList<Observador> observadores = 
			new LinkedList<Observador>();
	
	public void registrar(Observador o) {
		observadores.add(o);
	}
	
	protected void notificar() {
		for (Observador observador : observadores) {
			observador.notificarse();
		}
	}
	
	protected void notificar(Jugador jugador) {
		for (Observador observador : observadores) {
			observador.notificarseJugador(jugador);
		}
	}
}

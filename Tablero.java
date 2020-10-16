package juegoTP;

public class Tablero {
	
	private Mazo mazo;
	private Descarte descarte;
	
	
	public Tablero() {
		mazo = new Mazo();
		descarte = new Descarte();
	}
	
	public void cartaJugada() {///Muestra la ultima carta que se jugo
		descarte.ultimaCartaJugada();
	}
	
	public Mazo getMazo() {
		return this.mazo;
	}
	
	public Descarte getDescarte() {
		return this.descarte;
	}
	
}

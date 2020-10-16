package juegoTP;

import java.util.ArrayList;

public class Descarte {
	
	private ArrayList<Carta> descarte;
	
	
	public Descarte() {
		descarte = new ArrayList<Carta>();
	}
	
	public void mostrarCartas() {
		for(Carta carta : this.descarte) {
			System.out.println(carta);
		}
	}
	
	public void ultimaCartaJugada() {
		System.out.println(this.descarte.get(descarte.size()-1));
	}
	
	public void agregarCarta(Carta carta) {
		descarte.add(carta);
	}
	
}

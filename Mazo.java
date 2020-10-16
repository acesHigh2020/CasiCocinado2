package juegoTP;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
	
	private ArrayList<Carta> mazo; 
	private int cantidadCartas = 16;
	
	
	public Mazo() {
        mazo= new ArrayList<Carta>();//Instancio el array de cartas (mi mazo)

        							// Creamos cada carta y la agregamos al array de cartas (mazo)
        mazo.add(new Guardia());
        mazo.add(new Guardia());
        mazo.add(new Guardia());
        mazo.add(new Guardia());
        mazo.add(new Guardia());

        mazo.add(new Sacerdote());
        mazo.add(new Sacerdote());

        mazo.add(new Baron());
        mazo.add(new Baron());

        mazo.add(new Mucama());
        mazo.add(new Mucama());

        mazo.add(new Principe());
        mazo.add(new Principe());

        mazo.add(new Rey());
        mazo.add(new Condesa());
        mazo.add(new Princesa());

 
        Collections.shuffle(mazo);
    }
	
	public Carta asignarCarta() {
		Carta cartaAsignadaJugador = mazo.get(16-cantidadCartas);
		cantidadCartas--;
		return cartaAsignadaJugador;
	}

	public int getCantidadCartas() {
		return cantidadCartas;
	}

	public void setCantidadCartas(int cantidadCartas) {
		this.cantidadCartas = cantidadCartas;
	}
	
	public void mezclarMazo() {
		Collections.shuffle(mazo);
	}
	
	
	public void repartir(ArrayList<Jugador> jugadores) {
		cantidadCartas--;
		for(Jugador j: jugadores) 
			if(j.getEstado().compareTo("Jugando")==0)
				j.asignarCarta(this.asignarCarta());
		
	}
	
	
	

}

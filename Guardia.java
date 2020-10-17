package juegoTP;

import java.util.ArrayList;
import java.util.Scanner;

public class Guardia extends Carta {

	public Guardia() {
		super("Guardia", 1, "El jugador elige otro jugador oponente y nombra un tipo de carta (excepto \"Guardia\"). Si el oponente tiene en su mano una carta de ese tipo, el oponente es eliminado de la ronda");
	}

	@Override
	public boolean activarEfecto (Jugador jugador, ArrayList<Jugador> listaJugadores, Descarte d, Mazo m) {
		boolean valor = false;
		int i=1, numeroJugador=-1, cartaSeleccionada=0;
		Scanner ingresoTeclado = new Scanner(System.in);
		
		System.out.println("\nLos Jugadores a elegir son:");
		
		for (Jugador jug : listaJugadores) {	///METE EN UN VECTOR A LOS JUGADORES SELECCIONABLES
			
			if(jugador!=jug && jug.getEstado().compareTo("Jugando")==0) 
				System.out.println("Jugador " + i + " : " + jug.getNombre());
				i++;
				
		}

//		do {
//			System.out.println("Ingrese numero de jugador a seleccionar");
//			numeroJugador = ingresoTeclado.nextInt()-1;
//		}while((numeroJugador < 0 || numeroJugador >= listaJugadores.size()) && listaJugadores.get(numeroJugador)!=jugador);		///HASTA ELEGIR UN JUGADOR VALIDO DEL VECTOR
		
		while(numeroJugador == -1) {
			 System.out.println("\n-------Ingrese numero de jugador a seleccionar:");
				numeroJugador = ingresoTeclado.nextInt()-1;
				if(numeroJugador <0 || numeroJugador>=listaJugadores.size())
					numeroJugador=-1;
				else 
					if(listaJugadores.get(numeroJugador)==jugador || listaJugadores.get(numeroJugador).getEstado().compareTo("Fuera De Ronda")==0)
						numeroJugador = -1;	
		 }
		
		do {
			System.out.println("2: Sacerdote");
			System.out.println("3: Baron");
			System.out.println("4: Mucama");
			System.out.println("5: Principe");
			System.out.println("6: Rey");
			System.out.println("7: Condesa");
			System.out.println("8: Princesa");
			System.out.println("\n-------Elija la carta que creas que tiene tu oponente:");
			cartaSeleccionada = ingresoTeclado.nextInt();
		}while(cartaSeleccionada < 2 || cartaSeleccionada > 8);		///HASTA ELEGIR UN NUMERO DE CARTA VALIDA
		
		
		Jugador jugadorSeleccionado = listaJugadores.get(numeroJugador);
		if(jugadorSeleccionado.getEstado().compareTo("Jugando")==0) {
		if(jugadorSeleccionado.getReferenciaCarta()!=null && cartaSeleccionada== jugadorSeleccionado.getFuerzaCarta()) {	
			jugadorSeleccionado.setEstado("Fuera de Ronda");
			valor = true;
			System.out.println("Jugador" + listaJugadores.get(numeroJugador).getNombre() + "Quedo eliminado");
			///SI EL NUMERO DE CARTA SELECCIONADA QUE ELIGIO ES IGUAL A LA FUERZA ENTONCES EL JUGADOR SELECCIONADO QUEDA FUERA DE RONDA
		}
		else System.out.println("El jugador no posee esa carta");
		}
		else System.out.println("No se le pudo aplicar el efecto al jugador!!!");
	
		return valor;
	}

}

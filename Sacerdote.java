package juegoTP;

import java.util.ArrayList;
import java.util.Scanner;

public class Sacerdote extends Carta {

	public Sacerdote() {
		super("Sacerdote", 2, "El jugador elige otro jugador para ver la cartas en su mano");
	}

	public boolean activarEfecto (Jugador jugador, ArrayList<Jugador> listaJugadores, Descarte des, Mazo m) {
			
		int i=1, numeroJugador=-1;
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
//		}while( (numeroJugador < 0 || numeroJugador >= listaJugadores.size()) && listaJugadores.get(numeroJugador) !=jugador && 
//				listaJugadores.get(numeroJugador).getEstado()=="Fuera de Ronda");	
		
		while(numeroJugador == -1) {
			 System.out.println("\n-------Ingrese numero de jugador a seleccionar:");
				numeroJugador = ingresoTeclado.nextInt()-1;
				if(numeroJugador <0 || numeroJugador>=listaJugadores.size())
					numeroJugador=-1;
				else 
					if(listaJugadores.get(numeroJugador)==jugador || listaJugadores.get(numeroJugador).getEstado().compareTo("Fuera de Ronda")==0)
						numeroJugador = -1;	
		 }
		///HASTA ELEGIR UN JUGADOR VALIDO DEL ARRAY
		Jugador jugElegido = listaJugadores.get(numeroJugador);
		if(jugElegido.getEstado().compareTo("Jugando")==0) {
		System.out.println("CARTA DEL JUGADOR:" + jugElegido.getNombre());
		System.out.println(jugElegido.getReferenciaCarta());
		System.out.println("*******************************");
		//System.out.println("Carta:"+jugElegido.getInfoCarta());	///IMPRIME LA CARTA DEL OPONENTE
		///METODO A ARREGLAR PARA QUE SOLO SE LO MUESTRE AL JUGADOR QUE TIRA LA CARTA
		}
		else System.out.println("No se le pudo aplicar el efecto al jugador!!!");
		return false;
	}
	
	
	
}

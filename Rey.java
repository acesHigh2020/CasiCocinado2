package juegoTP;

import java.util.ArrayList;
import java.util.Scanner;

public class Rey extends Carta{

	public Rey() {
		super("Rey", 6, "El jugador elige otro jugador e intercambian sus manos");
	}

	@Override
	public boolean activarEfecto(Jugador jugador, ArrayList<Jugador> listaJugadores, Descarte d, Mazo m) {
		

		int i=1, numeroJugador=-1;
		Scanner ingresoTeclado = new Scanner(System.in);
		Carta cartaAuxiliar;
		Jugador jugadorElegido = null;
		
		System.out.println("\nLos Jugadores a elegir son:");
		 for (Jugador jug : listaJugadores) {    ///METE EN UN VECTOR A LOS JUGADORES SELECCIONABLES

	            if(jug.getEstado()=="Jugando" && jug!=jugador) {
	                System.out.println("Jugador" + i + ":" + jug.getNombre());
	            }
	            i++;
	        }
		 
		 while(numeroJugador == -1) {
			 System.out.println("\nl-------Ingrese numero de jugador a seleccionar");
				numeroJugador = ingresoTeclado.nextInt()-1;
				if(numeroJugador <0 || numeroJugador>=listaJugadores.size())
					numeroJugador=-1;
				else 
					if(listaJugadores.get(numeroJugador)==jugador)
						numeroJugador = -1;	
		 }
			
		if(listaJugadores.get(numeroJugador).getEstado().compareTo("Jugando")==0) {
		jugadorElegido = listaJugadores.get(numeroJugador);
		cartaAuxiliar = jugador.getCartaMano();	//SE PRODUCE EL INTERCAMBIO DE CARTAS ENTRE JUGADORES
		jugador.setCarta(jugadorElegido.getCartaMano());
		jugadorElegido.setCarta(cartaAuxiliar);
		System.out.println("La nueva mano de cartas es:");
		System.out.println(jugador.getReferenciaCarta());
		}
		else System.out.println("No se le pudo aplicar el efecto al jugador!!!");
		return false;
	}
}
package juegoTP;

import java.util.ArrayList;
import java.util.Scanner;

public class Baron extends Carta{

	public Baron() {
		super("Baron", 3, "El jugador elige otro jugador y se revelan las cartas de forma privada. El jugador que posee la carta con menos fuerza es eliminado de la ronda");
	}

	@Override
	public void activarEfecto(Jugador jugador, ArrayList<Jugador> listaJugadores, Descarte d, Mazo m) {
		
		int i=1, numeroJugador=-1, resultadoComparacion;
		Jugador jugadorElegido = null;
		Scanner ingresoTeclado = new Scanner(System.in);
		
		for (Jugador jug : listaJugadores) {	///METE EN UN VECTOR A LOS JUGADORES SELECCIONABLES
			
			if(jugador!=jug && jug.getEstado().compareTo("Jugando")==0) 
				System.out.println("Jugador" + i + ":" + jug.getNombre());
				i++;
				
		}

//		do {
//			System.out.println("Ingrese numero de jugador a seleccionar");
//			numeroJugador = ingresoTeclado.nextInt()-1;
//		}while( (numeroJugador < 0 || numeroJugador >= listaJugadores.size()) && (listaJugadores.get(numeroJugador) ==jugador) &&
//				listaJugadores.get(numeroJugador).getEstado()=="Fuera de Ronda");		///HASTA ELEGIR UN JUGADOR VALIDO DEL VECTOR
		while(numeroJugador == -1) {
			 System.out.println("Ingrese numero de jugador a seleccionar");
				numeroJugador = ingresoTeclado.nextInt()-1;
				if(numeroJugador <0 || numeroJugador>=listaJugadores.size())
					numeroJugador=-1;
				else 
					if(listaJugadores.get(numeroJugador)==jugador || listaJugadores.get(numeroJugador).getEstado().compareTo("Fuera de Ronda")==0)
						numeroJugador = -1;	
		 }
		
		Jugador jugElegido = listaJugadores.get(numeroJugador);
		
		if(jugElegido.getEstado().compareTo("Jugando")==0) {
		System.out.println("Muestro carta del rival" + jugElegido.getNombre());
		Carta cartaJugador = jugador.getReferenciaCarta(), cartaJugadorElijo = jugElegido.getReferenciaCarta();
		System.out.println(cartaJugadorElijo);
	
		
		System.out.println("Comparo cartas:");
		resultadoComparacion = cartaJugador.compararCarta(cartaJugadorElijo);//RETORNA QUE CARTA ES MAYOR
		
		if(resultadoComparacion > 0) {			///EL JUGADOR QUE TENGA MENOR NUMERO DE CARTA ES DECLARADO FUERA DE LA RONDA
			
			jugadorElegido.setEstado("Fuera de Ronda");
			System.out.println("Jugador" + jugadorElegido.getNombre()+ "Quedo eliminado");
		}		
		else if(resultadoComparacion < 0) {
			jugador.setEstado("Fuera de Ronda");
			System.out.println("Jugador" + jugador.getNombre() + "quedo eliminado");
		}
		else {
			System.out.println("Empate de Fuerza de Cartas");
		}
		}
	else System.out.println("No se le pudo aplicar el efecto al jugador!!!");
	}
	
}

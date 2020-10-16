package juegoTP;

import java.util.ArrayList;
import java.util.Scanner;

public class Principe extends Carta{

	public Principe() {
		super("Principe", 5, "El jugador elige otro jugador (incluso a sí mismo) para descartar su mano y robar una carta nueva. Si la Princesa es descartada de esta manera, el jugador que la descartó es eliminado de la ronda");
	}

	@Override
	public void activarEfecto(Jugador jugador, ArrayList<Jugador> listaJugadores, Descarte desc, Mazo mazo) {
		
		int i=1, numeroJugador=-1;
		Scanner ingresoTeclado = new Scanner(System.in);
		
			
		for (Jugador jug : listaJugadores) {	///METE EN UN VECTOR A LOS JUGADORES SELECCIONABLES
			
			if(jugador!=jug && jug.getEstado().compareTo("Jugando")==0) 
				System.out.println("Jugador" + i + ":" + jug.getNombre());
				i++;
				
		}
		

//		do {
//			System.out.println("Ingrese numero de jugador a seleccionar");
//			numeroJugador = ingresoTeclado.nextInt()-1;
//		}while( (numeroJugador < 0 || numeroJugador >= listaJugadores.size()) && listaJugadores.get(numeroJugador).getEstado()=="Fuera de Ronda");		///HASTA ELEGIR UN JUGADOR VALIDO DEL VECTOR
		while(numeroJugador == -1) {
			 System.out.println("Ingrese numero de jugador a seleccionar");
				numeroJugador = ingresoTeclado.nextInt()-1;
				if(numeroJugador <0 || numeroJugador>=listaJugadores.size())
					numeroJugador=-1;
				else 
					if(listaJugadores.get(numeroJugador).getEstado().compareTo("Fuera de Ronda")==0)
						numeroJugador = -1;	
		 }
		
		///NECESITAMOS LOS METODOS IMPLEMENTADOS DE MANO Y MAZO PARA PODER AGARRAR 1 CARTA DEL MAZO
		if(listaJugadores.get(numeroJugador).getEstado().compareTo("Jugando")==0)
		listaJugadores.get(numeroJugador).descarto(desc, mazo);
		else System.out.println("No se le pudo aplicar el efecto al jugador!!!");
		//System.out.println(listaJugadores.get(numeroJugador).getCartaMano());
		
	}

}

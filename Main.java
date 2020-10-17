package juegoTP;

public class Main {

	public static void main(String[] args) {
			
		Jugador j1 = new Jugador("Maxi");
		Partida pp = j1.crearPartida();
		
		Jugador j2 = new Jugador("Renata");
		j2.unirsePartida(pp);
		
//		Jugador j3 = new Jugador("Nestor");
//		j3.unirsePartida(pp);
//		
//		Jugador j4 = new Jugador("Lopez");
//		j4.unirsePartida(pp);
		
		
		j1.iniciarPartida(pp);
		
	}
}

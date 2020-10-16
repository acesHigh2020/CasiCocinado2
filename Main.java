package juegoTP;

public class Main {

	public static void main(String[] args) {
			
		Jugador j1 = new Jugador("Maxi");
		Partida pp = j1.crearPartida();
		
		Jugador j2 = new Jugador("Renata");
		j2.unirsePartida(pp);
		
		j1.iniciarPartida(pp);
		
	}
}

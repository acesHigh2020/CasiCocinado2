package juegoTP;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CondesaTest {

	@Test
	void test() {
		
		Carta conde = new Condesa();
		Mazo mazo = new Mazo();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		Descarte descarte = new Descarte();
		Jugador j1 = new Jugador("aladin222");
		
		j1.setEstado("Jugando");
		j1.asignarCarta(conde);
		j1.asignarCarta(new Principe());
		
		assertTrue(j1.getManoDeCartas().estaCarta(conde));
		j1.jugada(mazo, jugadores, descarte);
		
		assertTrue(!j1.getManoDeCartas().estaCarta(conde));
		
	}

}

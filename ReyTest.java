package juegoTP;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ReyTest {

	@Test
	void test() {
		Jugador j1 = new Jugador("aladin222");
		Jugador j2 = new Jugador("BlackChain");
		Mazo mazo = new Mazo();
		Descarte descarte = new Descarte();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		j1.setEstado("Jugando");
		j2.setEstado("Jugando");
		jugadores.add(j1);
		jugadores.add(j2);
		
		Carta rey = new Rey();
		
		Carta c1 = new Principe();
		j1.asignarCarta(c1);

		
		Carta c3 = new Mucama();
		j2.asignarCarta(c3);
		
		rey.activarEfecto(j1, jugadores, descarte, mazo);
		
		assertTrue(j1.getManoDeCartas().estaCarta(c3));
		
		assertTrue(j2.getManoDeCartas().estaCarta(c1));
		
		
	}

}

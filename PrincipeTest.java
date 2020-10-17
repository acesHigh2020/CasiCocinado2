package juegoTP;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PrincipeTest {

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
		
		
		Carta c1 = new Principe();
		Carta c2 = new Princesa();
		j1.asignarCarta(c1);
		j1.asignarCarta(c2);
		
		Carta c3 = new Mucama();
		Carta c4 = new Guardia();
		j2.asignarCarta(c3);
		j2.asignarCarta(c4);

		
		c1.activarEfecto(j1, jugadores, descarte, mazo);
		assertEquals(1,j2.getCartasTiradas());
		
		c1.activarEfecto(j1, jugadores, descarte, mazo);
		assertEquals(1,j1.getCartasTiradas());
		
	}

}

package juegoTP;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MazoTest {

	@Test
	void test() {
		Mazo mazo = new Mazo();
		assertEquals(16, mazo.getCantidadCartas()); // vamos bien!
		
		Jugador j1 = new Jugador("Aladin222");
		j1.setEstado("Jugando");
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(j1);
		
		mazo.repartir(jugadores);
		
		Mano mano = jugadores.get(0).getManoDeCartas();
		
		System.out.println(mano.getMano());
		assertEquals(14, mazo.getCantidadCartas());
		
		
	}

}

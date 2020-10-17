package juegoTP;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MucamaTest {

	@Test
	void test() {
		Jugador j1 = new Jugador("aladin");
		j1.asignarCarta(new Mucama());
		
		assertTrue(j1.getManoDeCartas().estaCarta(new Mucama()));
		
		j1.getCartaMano().activarEfecto(j1, null, null, null);
		
		assertEquals("Inmune", j1.getEstado());
	}

}

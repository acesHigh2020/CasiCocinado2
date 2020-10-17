package juegoTP;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrincesaTest {

	@Test
	void test() {
		Jugador j1 = new Jugador("aladin");
		j1.asignarCarta(new Princesa());
		
		assertTrue(j1.getManoDeCartas().estaCarta(new Princesa()));
		
		j1.getCartaMano().activarEfecto(j1, null, null, null);
		
		assertEquals("Fuera de Ronda", j1.getEstado());
	}

}

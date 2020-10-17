package juegoTP;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ManoTest {

	@Test
	void test() {
		
		Mano mano = new Mano();
		Carta c1 = new Condesa();
		Carta c2 = new Baron();
		Carta c3 = new Guardia();
		
		mano.agarrarCarta(c1);
		mano.agarrarCarta(c2);
		assertTrue(mano.estaCarta(c1));
		assertTrue(mano.estaCarta(c2));
		
		mano.sacarCondesa();
		assertTrue(!mano.estaCarta(c1));
		
		c3 = mano.getReferencia();
		assertEquals(c2,c3);
	}

}

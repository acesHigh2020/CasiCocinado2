package juegoTP;

import java.util.ArrayList;

public class Mano {
	private ArrayList<Carta> mano;

	public Mano() {
		mano = new ArrayList<Carta>();
	}
	public ArrayList<Carta> getMano() {
		return mano;
	}

	public void agarrarCarta(Carta c) {
		mano.add(c);
	}
	
	public Carta sacarCarta(int pos) {
		return mano.remove(pos);
	}
	
	public Carta getCartaEn(int n) {
		return mano.get(n);
	}
	public Carta getReferencia() {
		if(mano.get(0)!=null)
		return mano.get(0);
		else return mano.get(1);
	}
	
	public boolean estaCarta(Carta c) {
		return mano.contains(c);
	}
	
	public Carta sacarCondesa() {
		if(estaCarta(new Condesa()))
			return sacarCarta(mano.indexOf(new Condesa()));
		return null;
	}
	
	@Override
	public String toString() {
		String nue = mano.get(0).toString();
		if(mano.get(1)!=null)
			nue+=("\n"+mano.get(1).toString());
		return nue;
	}
}

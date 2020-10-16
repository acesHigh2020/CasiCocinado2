package juegoTP;

import java.util.ArrayList;
import java.util.Scanner;

public class Partida extends Observador{
	private  ArrayList<Jugador> jugadores;
	//private ArrayList<Ronda> rondas;
	private int simbolosParaGanar, orden, primerJugador;
	private Tablero tablero;
	
	
	/*
	 * Constructor de la clase partido
	 */
	public Partida(int victoriasNecesarias, Jugador jugadorCreador) {
		jugadores = new ArrayList<Jugador>();
		//rondas = new ArrayList<Ronda>();
		simbolosParaGanar = victoriasNecesarias;
		jugadores.add(jugadorCreador);
		orden = orden=0;
		///0 PARA SENTIDO HORARIO
		///1 PARA SENTIDO ANTIHORARIO
	}
	
	public void eliminarJugador(Jugador j) {
		if(this.jugadores.contains(j)) 
			this.jugadores.remove(jugadores.indexOf(j));	
		
	}
	
	public void setPrimerJugador(int n) {
		this.primerJugador = n-1;
	}
	
	public void setOrden(int orden) {
		this.orden = orden;
	}
	
	
	/*
	 * El metodo de observador
	 */
//	@Override
//	public void notificarse() {
//		
//		if (hayGanador() != null)
//			finalizarPartida(hayGanador());
//		else
//			agregarRonda();
//	}
	
//	@Override
//	public void notificarseJugador(Jugador jugador) {
//		// TODO Auto-generated method stub
//	}
	
	/*
	 * Hay que ver este metodo, porque lo hice en base a los puntajes del jugador,
	 * pero si tenes un array de rondas que solo van a tener al ganador, no necesitaria ir hasta el jugador para
	 * incrementar una variable "puntaje" que haga lo mismo.
	 */
	
	public Jugador hayGanador() {
		
		for (Jugador jugador : jugadores) {
			if (jugador.getPuntaje() == simbolosParaGanar)
				return jugador;
		}
		return null;
	}
	
	/*
	 * Agrega una ronda a la partida y 
	 * se pasa la lista de jugadores que apareceran en la ronda 
	 */
//	public boolean agregarRonda() {
//		Ronda ronda = new Ronda(jugadores);
//		ronda.registrar(this);
//		for (Jugador jugador : jugadores) {
//			ronda.registrar(jugador);
//		}
//		return rondas.add(ronda);
//		
//	}
	
	/*
	 * Agrega un jugador a la partida
	 */
	public boolean agregarJugador(Jugador jugador) {
		
		if(jugadores.size()<4)
			jugadores.add(jugador);
		else {
			System.out.println("Se alcanzo la capacida maxima de jugadores");
			return false;
		}
		
		return true;
	}
	
	/*
	 * Metodo que finalizara la partida
	 */
	public void finalizarPartida(Jugador jugador) {
		System.out.println("Es el ganador el jugador: " + jugador.getNombre());
	}
	
	public int getCantJugadores() {
		return jugadores.size();
	}
	
	public void jugarPartida() {
		
		Tablero tableroPartida = new Tablero();
		Mazo m = tableroPartida.getMazo();
		Descarte d = tableroPartida.getDescarte();
		boolean ganador = false;
		Jugador ganadorJug = null;
		int jugadoresEstables = this.jugadores.size();
				
		while(!ganador) {
			m.setCantidadCartas(16);
			m.mezclarMazo();
			m.repartir(jugadores);
			
			for(int i = 0; i < jugadores.size() && m.getCantidadCartas()>0 && jugadoresEstables>1; i++)
				if(jugadores.get(i).getEstado()=="Jugando") {
					System.out.println("Turno del jugador: "+jugadores.get(i).getNombre());
					jugadores.get(i).jugada(m,jugadores,d);///Verifica que el jugador pueda jugar///para que le toque el turno
				System.out.println("*************************************");	
				}
			for(Jugador j: this.jugadores) {
				if(j.getPuntaje()==this.simbolosParaGanar) {
					ganador=true;
					ganadorJug = j;
				}
				d.ultimaCartaJugada();
			}
			
			
			for(Jugador j: this.jugadores) ///Al final de cada ronda, se comienza poniendo los jugadres en 
											///estado "Jugando"
				j.setEstado("Jugando");
				
		}
		
		
		System.out.println("El ganador fue" + ganadorJug.getNombre());
	
		
		
	}

	@Override
	public void notificarse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificarseJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}
}
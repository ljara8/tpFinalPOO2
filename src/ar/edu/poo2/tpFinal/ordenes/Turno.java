package ar.edu.poo2.tpFinal.ordenes;

import java.time.LocalDateTime;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;
import ar.edu.poo2.tpFinal.clientes.Cliente;

public class Turno {
	private Orden orden;
	private int cantidadHorasMargenAtraso;
	private int cantidadHorasPreviasDeLlegada;
	
	public Turno(Orden orden, int cantidadHorasMargenAtraso, int cantidadHorasPreviasDeLlegada) {
		this.orden = orden;
		this.cantidadHorasMargenAtraso = cantidadHorasMargenAtraso;
		this.cantidadHorasPreviasDeLlegada = cantidadHorasPreviasDeLlegada;
	}

	public final LocalDateTime getFechaRecepcion() {
		LocalDateTime fechaLlegada = orden.getFechaLlegadaADestino();
		LocalDateTime fechaDeEntrega = fechaLlegada.minusHours(cantidadHorasPreviasDeLlegada);
		return fechaDeEntrega;
	}

	public Cliente getCliente() {
		return orden.getCliente();
	}

	public Viaje getViaje() {
		return orden.getViajeActual();
	}

	public Chofer getChofer() {
		return orden.getChofer();
	}

	public Camion getCamion() {
		return orden.getCamion();
	}

	public Orden getOrden() {
		return orden;
	}
	
	public final boolean estaAHorario(LocalDateTime horaDeRecepcion) {
		return horaDeRecepcion.isBefore(getFechaConHorarioLimite());
	}
		
	public final LocalDateTime getFechaConHorarioLimite() {
		return getFechaRecepcion().plusHours(cantidadHorasMargenAtraso);
	}

}
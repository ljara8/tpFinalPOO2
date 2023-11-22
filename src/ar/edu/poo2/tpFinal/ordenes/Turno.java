package ar.edu.poo2.tpFinal.ordenes;

import java.time.LocalDateTime;
import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;
import ar.edu.poo2.tpFinal.clientes.Cliente;

public class Turno {
	private OrdenExportacion orden;

	public Turno(OrdenExportacion orden) {
		this.orden = orden;
	}

	public LocalDateTime getFechaRecepcion() {
		LocalDateTime fechaLlegada = orden.getFechaLlegadaADestino();
		LocalDateTime fechaDeEntrega = fechaLlegada.minusHours(12);
		return fechaDeEntrega;
	}

	public Cliente getShipper() {
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

	public OrdenExportacion getOrdenExportacion() {
		return orden;
	}

}
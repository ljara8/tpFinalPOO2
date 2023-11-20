package ar.edu.poo2.tpFinal.ordenes;

import java.sql.Date;
import java.time.LocalDate;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.Cliente;
import ar.edu.poo2.tpFinal.Viaje;

public class Turno {
	private OrdenExportacion orden;
	private Date fechaRecepcion;

	Turno(OrdenExportacion orden, Date fecha) {
		this.orden = orden;
		this.fechaRecepcion = fecha;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
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

package ar.edu.poo2.tpFinal.ordenes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import ar.edu.poo2.tpFinal.contyserv.Servicio;

public class Desglose {

	private Orden orden;

	Desglose(Orden ord) {
		this.orden = ord;
	}

	public Orden getOrden() {
		return orden;

	}

	public double getMontoTotal(Orden orden) throws Exception {
		return orden.getFactura().getMontoTotalFacturado(orden);

	}

	public List<Servicio> getServicios(Orden orden) {
		return orden.getServiciosContratados();

	}

	public Date getFecha() {
		return Date.valueOf(LocalDate.now());
	}

}
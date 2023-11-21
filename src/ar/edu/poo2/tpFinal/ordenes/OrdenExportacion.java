package ar.edu.poo2.tpFinal.ordenes;

import ar.edu.poo2.tpFinal.Camion;


import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.Clientes.*;
import ar.edu.poo2.tpFinal.CircuitosNaviera.*; 
import ar.edu.poo2.tpFinal.contyserv.Container;

public class OrdenExportacion extends Orden {
	private FacturaSimple factura;

	OrdenExportacion(Shipper client, Container cont, Camion cam, Chofer chofer, Viaje viaje, FacturaSimple fact) {
		super(client, cont, cam, chofer, viaje);
		this.factura = fact;
	}

	@Override
	public Factura getFactura() {
		return factura;
	}

	public TerminalPortuaria getTerminalDestino() {
		return this.getViajeActual().getDestino();
	}

}
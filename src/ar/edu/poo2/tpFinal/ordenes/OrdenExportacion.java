package ar.edu.poo2.tpFinal.ordenes;

import ar.edu.poo2.tpFinal.Camion;

import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.CircuitosNaviera.*;
import ar.edu.poo2.tpFinal.clientes.Shipper;
import ar.edu.poo2.tpFinal.contyserv.Container;

public class OrdenExportacion extends Orden {
	private FacturaSimple factura;

	public OrdenExportacion(Shipper client, Container cont, Camion cam, Chofer chofer, Viaje viaje, FacturaSimple fact) {
		super(client, cont, cam, chofer, viaje, viaje.getOrigen());
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
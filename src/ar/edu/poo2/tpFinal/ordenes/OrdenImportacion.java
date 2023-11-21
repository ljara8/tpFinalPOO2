package ar.edu.poo2.tpFinal.ordenes;

import ar.edu.poo2.tpFinal.Camion;	

import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.Clientes.*;
import ar.edu.poo2.tpFinal.CircuitosNaviera.*;
import ar.edu.poo2.tpFinal.contyserv.Container;

public class OrdenImportacion extends Orden {
	private FacturaResponsableViaje factura;

	OrdenImportacion(Consignee client, Container cont, Camion cam, Chofer chofer, Viaje viaje,
			FacturaResponsableViaje fact) {
		super(client, cont, cam, chofer, viaje);
		this.factura = fact;
	}

	@Override
	public Factura getFactura() {
		return factura;
	}

}
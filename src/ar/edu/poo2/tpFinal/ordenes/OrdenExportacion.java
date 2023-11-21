package ar.edu.poo2.tpFinal.ordenes;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.Cliente;
import ar.edu.poo2.tpFinal.Factura;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;
import ar.edu.poo2.tpFinal.contyserv.Container;

public class OrdenExportacion extends Orden{

	OrdenExportacion(Cliente client, Container cont, Camion cam, Chofer chofer, Viaje viaje) {
		super(client, cont, cam, chofer, viaje);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Factura getFactura() {
		// TODO Auto-generated method stub
		return null;
	}

	public TerminalPortuaria getTerminalDestino() {
		// TODO Auto-generated method stub
		return null;
	}

}

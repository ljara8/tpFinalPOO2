package ar.edu.poo2.tpFinal.clientes;

import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

public class Consignee implements Cliente {
	private String email;
	private String nombre;
	private OrdenImportacion ordenImp;

	Consignee(String email, String nomb, OrdenImportacion orden) {
		this.email = email;
		this.nombre = nomb;
		this.ordenImp = orden;

	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String nombreCompleto() {
		return nombre;
	}

	@Override
	public double abonarFacturacion(OrdenExportacion ordenExp) throws Exception {
		throw new Exception("El cliente no posee orden de exportacion");
	}

	@Override
	public double abonarFacturacion(OrdenImportacion orden) throws Exception {
		return orden.getFactura().getMontoTotalFacturado(orden);
	}

	public OrdenImportacion getOrdenImp() {
		return ordenImp;
	}

	@Override
	public void cobrarMonto(double monto) {
		// Método dummy
	}

}
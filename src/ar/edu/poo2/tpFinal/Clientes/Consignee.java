package ar.edu.poo2.tpFinal.Clientes;

import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

public class Consignee implements Cliente {
	private OrdenImportacion ordenImp;

	Consignee(OrdenImportacion orden) {
		this.ordenImp = orden;

	}

	@Override
	public double abonarFacturacion(OrdenExportacion ordenExp) throws Exception {
		throw new Exception("El cliente no posee orden de exportacion");
	}

	@Override
	public double abonarFacturacion(OrdenImportacion orden) throws Exception {
		return orden.getFactura().getDesglose(orden).getMontoTotal(orden);
	}

	public OrdenImportacion getOrdenImp() {
		return ordenImp;
	}

}

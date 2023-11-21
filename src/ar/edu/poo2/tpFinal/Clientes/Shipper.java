package ar.edu.poo2.tpFinal.Clientes;

import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

public class Shipper implements Cliente {
	private OrdenExportacion ordenExp;

	Shipper(OrdenExportacion orden) {
		this.ordenExp = orden;
	}

	@Override
	public double abonarFacturacion(OrdenExportacion orden) throws Exception {
		return orden.getFactura().getDesglose(orden).getMontoTotal(orden);

	}

	@Override
	public double abonarFacturacion(OrdenImportacion orden) throws Exception {
		throw new Exception("El cliente no posee orden de importacion");
	}

	public OrdenExportacion getOrdenExp() {
		return ordenExp;
	}

}

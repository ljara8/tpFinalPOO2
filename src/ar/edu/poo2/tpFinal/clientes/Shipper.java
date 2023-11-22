package ar.edu.poo2.tpFinal.clientes;

import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

public class Shipper implements Cliente{
	private String email;
	private String nombre;
	private OrdenExportacion ordenExp;

	Shipper(String email, String nomb, OrdenExportacion orden) {
		this.email = email;
		this.nombre = nomb;
		this.ordenExp = orden;

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
	public double abonarFacturacion(OrdenExportacion orden) throws Exception {
		return orden.getFactura().getMontoTotalFacturado(orden);

	}

	@Override
	public double abonarFacturacion(OrdenImportacion orden) throws Exception {
		throw new Exception("El cliente no posee orden de importacion");
	}

	public OrdenExportacion getOrdenExp() {
		return ordenExp;
	}
}

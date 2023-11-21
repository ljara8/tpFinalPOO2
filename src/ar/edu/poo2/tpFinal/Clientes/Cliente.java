package ar.edu.poo2.tpFinal.Clientes;

import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

public interface Cliente {

	public double abonarFacturacion(OrdenExportacion orden) throws Exception;

	public double abonarFacturacion(OrdenImportacion orden) throws Exception;
}

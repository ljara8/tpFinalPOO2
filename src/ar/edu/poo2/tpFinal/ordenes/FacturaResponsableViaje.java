package ar.edu.poo2.tpFinal.ordenes;

public class FacturaResponsableViaje extends FacturaSimple {
	private OrdenImportacion orden;

	FacturaResponsableViaje(Orden orden) {
		super(orden);

	}

	public OrdenImportacion getOrden() {
		return orden;
	}

	@Override
	public double getMontoTotalFacturado(Orden orden) {
		return orden.getServiciosContratados().stream().mapToDouble(s -> s.montoTotal(orden)).sum()
				+ orden.getViajeActual().getCircuito().getPrecioTotalRecorrido();
	}

}
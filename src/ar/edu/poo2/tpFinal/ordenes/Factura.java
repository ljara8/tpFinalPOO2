package ar.edu.poo2.tpFinal.ordenes;

public interface Factura {

	public Desglose getDesglose(Orden orden);

	public double getMontoTotalFacturado(Orden orden) throws Exception ;

}
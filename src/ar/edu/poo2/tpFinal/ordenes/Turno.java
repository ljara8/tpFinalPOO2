package ar.edu.poo2.tpFinal.ordenes;

import java.time.LocalDateTime;
import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.EntregaTerrestre;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;
import ar.edu.poo2.tpFinal.clientes.Cliente;

public class Turno {
	private Orden orden;
	private int cantidadHorasMargenAtraso;
	private int cantidadHorasPreviasDeLlegada;

	public Turno(Orden orden, int cantidadHorasMargenAtraso, int cantidadHorasPreviasDeLlegada) {
		this.orden = orden;
		this.cantidadHorasMargenAtraso = cantidadHorasMargenAtraso;
		this.cantidadHorasPreviasDeLlegada = cantidadHorasPreviasDeLlegada;
	}

	public LocalDateTime getFechaRecepcion() {
		LocalDateTime fechaLlegada = orden.getFechaLlegadaADestino();
		LocalDateTime fechaDeEntrega = fechaLlegada.minusHours(12);
		return fechaDeEntrega;
	}

	public Cliente getShipper() {
		return orden.getCliente();
	}

	public Viaje getViaje() {
		return orden.getViajeActual();
	}

	public Chofer getChofer() {
		return orden.getChofer();
	}
	
	public Orden getOrden() {
		return orden;
	}

	public Camion getCamion() {
		return orden.getCamion();
	}
	
	public Cliente getCliente() {
		return orden.getCliente();
	}
	
	public final boolean estaAHorario(LocalDateTime horaDeRecepcion) {
		return horaDeRecepcion.isBefore(getFechaConHorarioLimite());
	}

	public final LocalDateTime getFechaConHorarioLimite() {
		return getFechaRecepcion().plusHours(cantidadHorasMargenAtraso);
	}

	public void proseguirImportacionConEntrega(EntregaTerrestre et, OrdenesImportacionManager ordenesImportacionManager) {
		getCliente().cobrarMonto(getOrden().getFactura().getMontoTotalFacturado(getOrden()));
		ordenesImportacionManager.importacionRealizada(et.getTurno(), et.getTurno().getOrden());
	}
	
	public void proseguirExportacionConEntrega(EntregaTerrestre et, OrdenesExportacionManager ordenesExportacionManager) {
		getCliente().cobrarMonto(getOrden().getFactura().getMontoTotalFacturado(getOrden()));
		ordenesExportacionManager.exportacionRealizada(et.getTurno(), et.getTurno().getOrden());
	}

	public boolean esTurnoValidoParaEntregaTerrestre(EntregaTerrestre entregaTerrestre) {
		return getCamion().equals(entregaTerrestre.getCamion()) 
				&& getChofer() == entregaTerrestre.getChofer() 
				&& estaAHorario(entregaTerrestre.getHorarioArribo())
				&& entregaTerrestre.getTurno().equals(this);
	}

}
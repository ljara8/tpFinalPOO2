package ar.edu.poo2.tpFinal.ordenes;

import java.util.HashSet;
import java.util.List;

import ar.edu.poo2.tpFinal.EntregaTerrestre;

public class OrdenesExportacionManager {
	private HashSet<Orden> ordenExportacionesRetiradas = new HashSet<Orden>();
	private HashSet<Turno> turnosExportaciones = new HashSet<>();
	private HashSet<OrdenExportacion> ordenExportaciones = new HashSet<OrdenExportacion>();
	
	public Turno encontrarTurnoPorEntregaTerrestre(EntregaTerrestre entregaTerrestre) throws IllegalAccessException {
		return turnosExportaciones.stream()
				.filter( turno -> turno.esTurnoValidoParaEntregaTerrestre(entregaTerrestre))
			.findFirst()
			.orElseThrow(() -> new IllegalAccessException("Su entrega no es válida. No cumple los parámetros de seguridad."));
	}
	
	public boolean tieneTurnoQueCoincidaConEntregaTerrestre(EntregaTerrestre entregaTerrestre) {
		return !turnosExportaciones.stream()
				.filter(turno -> turno.esTurnoValidoParaEntregaTerrestre(entregaTerrestre))
				.toList().isEmpty();
	}

	public void exportacionRealizada(Turno turno, Orden orden) {
		turnosExportaciones.remove(turno);
		ordenExportaciones.remove(orden);
		ordenExportacionesRetiradas.add(orden);
	}
	
	public List<Orden> ordenExportacionesRetiradas() {
		return ordenExportacionesRetiradas.stream().toList();
	}
	
	public List<Turno> turnosExportaciones() {
		return turnosExportaciones.stream().toList();
	}
	
	public List<OrdenExportacion> ordenExportaciones() {
		return ordenExportaciones.stream().toList();
	}
	
	public void agregarOrdenExportacion(OrdenExportacion ordenExportacion) {
		ordenExportaciones.add(ordenExportacion);
	}
	
	public void agregarTurnoExportacion(Turno turno) {
		turnosExportaciones.add(turno);
	}
	
}


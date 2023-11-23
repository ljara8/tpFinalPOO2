package ar.edu.poo2.tpFinal.ordenes;

import java.util.HashSet;
import java.util.List;

import ar.edu.poo2.tpFinal.EntregaTerrestre;

public class OrdenesImportacionManager {
	private HashSet<Orden> ordenImportacionesRetiradas = new HashSet<Orden>();
	private HashSet<Turno> turnosImportaciones = new HashSet<>();
	private HashSet<OrdenImportacion> ordenImportaciones = new HashSet<OrdenImportacion>();
	
	public Turno encontrarTurnoPorEntregaTerrestre(EntregaTerrestre entregaTerrestre) throws IllegalAccessException {
		return turnosImportaciones.stream()
				.filter( turno -> 
				turno.getCamion().equals(entregaTerrestre.getCamion()) 
				&& turno.getChofer() == entregaTerrestre.getChofer() 
				&& turno.estaAHorario(entregaTerrestre.getHorarioArribo())
				&& turno.equals(entregaTerrestre.getTurno())
			)
			.findFirst()
			.orElseThrow(() -> new IllegalAccessException("Su entrega no es válida. No cumple los parámetros de seguridad."));
	}
	
	public boolean tieneTurnoQueCoincidaConEntregaTerrestre(EntregaTerrestre entregaTerrestre) {
		return !turnosImportaciones.stream()
				.filter( turno -> 
				turno.getCamion().equals(entregaTerrestre.getCamion()) 
				&& turno.getChofer() == entregaTerrestre.getChofer() 
				&& turno.estaAHorario(entregaTerrestre.getHorarioArribo())
				&& turno.equals(entregaTerrestre.getTurno())
			).toList().isEmpty();
	}

	public void importacionRealizada(Turno turno, Orden orden) {
		turnosImportaciones.remove(turno);
		ordenImportaciones.remove(orden);
		ordenImportacionesRetiradas.add(orden);
	}
	
	public List<Orden> ordenImportacionesRetiradas() {
		return ordenImportacionesRetiradas.stream().toList();
	}
	
	public List<Turno> turnosImportaciones() {
		return turnosImportaciones.stream().toList();
	}
	
	public List<OrdenImportacion> ordenImportaciones() {
		return ordenImportaciones.stream().toList();
	}
	
	public void agregarOrdenImportacion(OrdenImportacion ordenImportacion) {
		ordenImportaciones.add(ordenImportacion);
	}
	
	public void agregarTurnoImportacion(Turno turno) {
		turnosImportaciones.add(turno);
	}
	
}

package ar.edu.poo2.tpFinal.ordenes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.EntregaTerrestre;

public class OrdenesImportacionManagerTest {
	private OrdenesImportacionManager ordenesImportacionManager;
	private EntregaTerrestre entregaTerrestre;
	private OrdenImportacion ordenImportacion;
	private Turno turno;
	private Camion camion;
	private Chofer chofer;
	
	@Before
	public void setup() {
		ordenesImportacionManager = new OrdenesImportacionManager();
		entregaTerrestre = mock(EntregaTerrestre.class);
		camion = mock(Camion.class);
		chofer = mock(Chofer.class);
		turno = mock(Turno.class);
		ordenImportacion = mock(OrdenImportacion.class);
	}
	
	@Test
	public void testNoTieneTurnoYTiraError() {
		when(entregaTerrestre.getTurno()).thenReturn(turno);
		assertThrows(IllegalAccessException.class, () -> ordenesImportacionManager.encontrarTurnoPorEntregaTerrestre(entregaTerrestre));
	}
	
	@Test
	public void testTieneTurnoCorrectoYLoEncuentra() {
		when(entregaTerrestre.getTurno()).thenReturn(turno);
		when(entregaTerrestre.getChofer()).thenReturn(chofer);
		when(entregaTerrestre.getCamion()).thenReturn(camion);
		when(turno.esTurnoValidoParaEntregaTerrestre(entregaTerrestre)).thenCallRealMethod();
		when(turno.getCamion()).thenReturn(camion);
		when(turno.getChofer()).thenReturn(chofer);
		when(turno.estaAHorario(any())).thenReturn(true);
		ordenesImportacionManager.agregarTurnoImportacion(turno);
		assertDoesNotThrow(() -> ordenesImportacionManager.encontrarTurnoPorEntregaTerrestre(entregaTerrestre));
	}
	
	@Test
	public void testTieneTurnoCorrecto() {
		when(entregaTerrestre.getTurno()).thenReturn(turno);
		when(entregaTerrestre.getChofer()).thenReturn(chofer);
		when(entregaTerrestre.getCamion()).thenReturn(camion);
		when(turno.esTurnoValidoParaEntregaTerrestre(entregaTerrestre)).thenCallRealMethod();
		when(turno.getCamion()).thenReturn(camion);
		when(turno.getChofer()).thenReturn(chofer);
		when(turno.estaAHorario(any())).thenReturn(true);
		ordenesImportacionManager.agregarTurnoImportacion(turno);
		assertDoesNotThrow(() -> ordenesImportacionManager.tieneTurnoQueCoincidaConEntregaTerrestre(entregaTerrestre));
	}
	
	@Test
	public void testCambiaOrdenExportacionARelizada() {
		ordenesImportacionManager.agregarOrdenImportacion(ordenImportacion);
		ordenesImportacionManager.agregarTurnoImportacion(turno);
		
		assertTrue(ordenesImportacionManager.ordenImportaciones().contains(ordenImportacion));
		assertTrue(ordenesImportacionManager.turnosImportaciones().contains(turno));
		
		ordenesImportacionManager.importacionRealizada(turno, ordenImportacion);
		
		assertFalse(ordenesImportacionManager.ordenImportaciones().contains(ordenImportacion));
		assertFalse(ordenesImportacionManager.turnosImportaciones().contains(turno));
		assertTrue(ordenesImportacionManager.ordenImportacionesRetiradas().contains(ordenImportacion));
	}
	
}

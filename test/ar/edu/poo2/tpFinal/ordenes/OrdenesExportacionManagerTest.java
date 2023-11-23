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

public class OrdenesExportacionManagerTest {
	private OrdenesExportacionManager ordenesExportacionManager;
	private EntregaTerrestre entregaTerrestre;
	private OrdenExportacion ordenExportacion;
	private Turno turno;
	private Camion camion;
	private Chofer chofer;
	
	@Before
	public void setup() {
		ordenesExportacionManager = new OrdenesExportacionManager();
		entregaTerrestre = mock(EntregaTerrestre.class);
		camion = mock(Camion.class);
		chofer = mock(Chofer.class);
		turno = mock(Turno.class);
		ordenExportacion = mock(OrdenExportacion.class);
	}
	
	@Test
	public void testNoTieneTurnoYTiraError() {
		when(entregaTerrestre.getTurno()).thenReturn(turno);
		assertThrows(IllegalAccessException.class, () -> ordenesExportacionManager.encontrarTurnoPorEntregaTerrestre(entregaTerrestre));
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
		ordenesExportacionManager.agregarTurnoExportacion(turno);
		assertDoesNotThrow(() -> ordenesExportacionManager.encontrarTurnoPorEntregaTerrestre(entregaTerrestre));
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
		ordenesExportacionManager.agregarTurnoExportacion(turno);
		assertDoesNotThrow(() -> ordenesExportacionManager.tieneTurnoQueCoincidaConEntregaTerrestre(entregaTerrestre));
	}
	
	@Test
	public void testCambiaOrdenExportacionARelizada() {
		ordenesExportacionManager.agregarOrdenExportacion(ordenExportacion);
		ordenesExportacionManager.agregarTurnoExportacion(turno);
		
		assertTrue(ordenesExportacionManager.ordenExportaciones().contains(ordenExportacion));
		assertTrue(ordenesExportacionManager.turnosExportaciones().contains(turno));
		
		ordenesExportacionManager.exportacionRealizada(turno, ordenExportacion);
		
		assertFalse(ordenesExportacionManager.ordenExportaciones().contains(ordenExportacion));
		assertFalse(ordenesExportacionManager.turnosExportaciones().contains(turno));
		assertTrue(ordenesExportacionManager.ordenExportacionesRetiradas().contains(ordenExportacion));
	}
	
}

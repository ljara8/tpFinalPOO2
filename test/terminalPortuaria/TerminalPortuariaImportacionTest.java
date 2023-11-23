package terminalPortuaria;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.EntregaTerrestre;
import ar.edu.poo2.tpFinal.MailManager;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.clientes.Cliente;
import ar.edu.poo2.tpFinal.ordenes.Factura;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;
import ar.edu.poo2.tpFinal.ordenes.Turno;
import ar.edu.poo2.tpFinal.seleccionadorCircuito.SeleccionadorCircuito;

public class TerminalPortuariaImportacionTest {

	private TerminalPortuaria terminalPortuaria;
	private EntregaTerrestre entregaTerrestre;
	private Chofer chofer;
	private Camion camion;
	private Factura factura;
	private Turno turno;
	private OrdenImportacion ordenImportacion;
	
	@BeforeEach
	void setUp() {
		terminalPortuaria = new TerminalPortuaria(mock(MailManager.class), mock(SeleccionadorCircuito.class));
		entregaTerrestre = mock(EntregaTerrestre.class);
		chofer = mock(Chofer.class);
		camion = mock(Camion.class);
		factura = mock(Factura.class);
		turno = mock(Turno.class);
		ordenImportacion = mock(OrdenImportacion.class);
	}

	@Test
	void testSeQuiereExportarConTurnoQueNoExisteYTiraError() {
		when(entregaTerrestre.getCamion()).thenReturn(camion);
		when(entregaTerrestre.getTurno()).thenReturn(turno);
		when(entregaTerrestre.getChofer()).thenReturn(chofer);
		
		assertThrows(IllegalAccessException.class, () -> terminalPortuaria.exportar(entregaTerrestre));
	}
	
	@Test
	void testSeQuiereExportarPeroNoCoincideCamionero() {
		when(factura.getMontoTotalFacturado(any())).thenReturn(0d);
		when(ordenImportacion.getCamion()).thenReturn(camion);
		when(ordenImportacion.getChofer()).thenReturn(chofer);
		when(ordenImportacion.getFactura()).thenReturn(factura);
		when(ordenImportacion.getCliente()).thenReturn(mock(Cliente.class));
		
		when(entregaTerrestre.getCamion()).thenReturn(mock(Camion.class));
		when(entregaTerrestre.getChofer()).thenReturn(chofer);
		
		Turno turnoDeExportacion = terminalPortuaria.registrarOrdenImportacion(ordenImportacion);
		LocalDateTime fechaDeArribo = mock(LocalDateTime.class);
		
		when(fechaDeArribo.minusHours(anyLong())).thenReturn(fechaDeArribo);
		when(fechaDeArribo.plusHours(anyLong())).thenReturn(fechaDeArribo);
		when(entregaTerrestre.getTurno()).thenReturn(turnoDeExportacion);
		when(ordenImportacion.getFechaLlegadaADestino()).thenReturn(fechaDeArribo);
		when(entregaTerrestre.getHorarioArribo()).thenReturn(fechaDeArribo);
		when(fechaDeArribo.isBefore(any())).thenReturn(true);
		
		assertThrows(IllegalAccessException.class, () -> terminalPortuaria.importar(entregaTerrestre));
	}
	
	@Test
	void testSeQuiereExportarConTurnoCorrecto() {
		when(factura.getMontoTotalFacturado(any())).thenReturn(0d);
		when(ordenImportacion.getCamion()).thenReturn(camion);
		when(ordenImportacion.getChofer()).thenReturn(chofer);
		when(ordenImportacion.getFactura()).thenReturn(factura);
		when(ordenImportacion.getCliente()).thenReturn(mock(Cliente.class));
		
		when(entregaTerrestre.getCamion()).thenReturn(camion);
		when(entregaTerrestre.getChofer()).thenReturn(chofer);
		
		Turno turnoDeExportacion = terminalPortuaria.registrarOrdenImportacion(ordenImportacion);
		LocalDateTime fechaDeArribo = mock(LocalDateTime.class);
		
		when(fechaDeArribo.minusHours(anyLong())).thenReturn(fechaDeArribo);
		when(fechaDeArribo.plusHours(anyLong())).thenReturn(fechaDeArribo);
		when(entregaTerrestre.getTurno()).thenReturn(turnoDeExportacion);
		when(ordenImportacion.getFechaLlegadaADestino()).thenReturn(fechaDeArribo);
		when(entregaTerrestre.getHorarioArribo()).thenReturn(fechaDeArribo);
		when(fechaDeArribo.isBefore(any())).thenReturn(true);
		
		assertDoesNotThrow(() -> terminalPortuaria.importar(entregaTerrestre));
	}
	
	@Test
	void testSeQuiereExportarPeroSeLlegaTarde() {
		when(factura.getMontoTotalFacturado(any())).thenReturn(0d);
		when(ordenImportacion.getCamion()).thenReturn(camion);
		when(ordenImportacion.getChofer()).thenReturn(chofer);
		when(ordenImportacion.getFactura()).thenReturn(factura);
		when(ordenImportacion.getCliente()).thenReturn(mock(Cliente.class));
		
		when(entregaTerrestre.getCamion()).thenReturn(camion);
		when(entregaTerrestre.getChofer()).thenReturn(chofer);
		
		Turno turnoDeExportacion = terminalPortuaria.registrarOrdenImportacion(ordenImportacion);
		LocalDateTime fechaDeArribo = mock(LocalDateTime.class);
		
		when(fechaDeArribo.minusHours(anyLong())).thenReturn(fechaDeArribo);
		when(fechaDeArribo.plusHours(anyLong())).thenReturn(fechaDeArribo);
		when(entregaTerrestre.getTurno()).thenReturn(turnoDeExportacion);
		when(ordenImportacion.getFechaLlegadaADestino()).thenReturn(fechaDeArribo);
		when(entregaTerrestre.getHorarioArribo()).thenReturn(fechaDeArribo);
		when(fechaDeArribo.isBefore(any())).thenReturn(false);
		
		assertThrows(IllegalAccessException.class, () -> terminalPortuaria.importar(entregaTerrestre));
	}
	
}

package terminalPortuaria;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.EmpresaTransportista;
import ar.edu.poo2.tpFinal.MailManager;
import ar.edu.poo2.tpFinal.CircuitosNaviera.CircuitoMaritimo;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Naviera;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.seleccionadorCircuito.SeleccionadorCircuito;

class TerminalPortuariaRegistrosTest {
	
	private TerminalPortuaria terminal;
	private Naviera naviera;
	private Camion camion;
	private Chofer chofer;
	private CircuitoMaritimo circuito;
	private EmpresaTransportista empresa;
	
	@BeforeEach
	void setUp() {
		terminal = new TerminalPortuaria(mock(MailManager.class), mock(SeleccionadorCircuito.class));
		naviera = mock(Naviera.class);
		camion = mock(Camion.class);
		chofer = mock(Chofer.class);
		circuito = mock(CircuitoMaritimo.class);
		empresa = mock(EmpresaTransportista.class);
		terminal.registrarEmpresasTransportistas(empresa);
	}
	
	@Test
	void testRegistrarNaviera() {
		when(naviera.tieneCircuitoConTerminal(terminal)).thenReturn(true);
		terminal.registrarNaviera(naviera);
		
		verify(naviera,times(1)).tieneCircuitoConTerminal(terminal);
	}
	
	@Test
	void testNoRegistraNaviera() {
		when(naviera.tieneCircuitoConTerminal(terminal)).thenReturn(false);
		
		assertThrowsExactly(NoSuchElementException.class, () -> terminal.registrarNaviera(naviera));
	}
	
	@Test
	void testRegistrarCircuito() {
		when(circuito.tieneTerminalEnTrayecto(terminal)).thenReturn(true);
		terminal.registrarCircuitoMaritimo(circuito);
		
		verify(circuito,times(1)).tieneTerminalEnTrayecto(terminal);
	}
	
	@Test
	void testNoRegistraCircuito() {
		when(circuito.tieneTerminalEnTrayecto(terminal)).thenReturn(false);
	
		assertThrowsExactly(NoSuchElementException.class, () -> terminal.registrarCircuitoMaritimo(circuito));
	}
	
	@Test
	void testRegistrarCamion() {
		when(empresa.estaCamionEnEmpresa(camion)).thenReturn(true);
		terminal.registrarCamion(camion);
		
		verify(empresa,times(1)).estaCamionEnEmpresa(camion);
	}
	
	@Test
	void testNoRegistraCamion() {
		when(empresa.estaCamionEnEmpresa(camion)).thenReturn(false);
		
		assertThrowsExactly(NoSuchElementException.class, () -> terminal.registrarCamion(camion));
	}
	
	@Test
	void testRegistrarChofer() {
		when(empresa.estaChoferEnEmpresa(chofer)).thenReturn(true);
		terminal.registrarChofer(chofer);
		
		verify(empresa,times(1)).estaChoferEnEmpresa(chofer);
	}
	
	@Test
	void testNoRegitraChofer() {
		when(empresa.estaChoferEnEmpresa(chofer)).thenReturn(false);
		
		assertThrowsExactly(NoSuchElementException.class, () -> terminal.registrarChofer(chofer));
	}
}
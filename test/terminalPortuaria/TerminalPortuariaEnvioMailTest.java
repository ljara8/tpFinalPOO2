package terminalPortuaria;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.poo2.tpFinal.Buque;
import ar.edu.poo2.tpFinal.Mail;
import ar.edu.poo2.tpFinal.MailManager;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;
import ar.edu.poo2.tpFinal.ordenes.Orden;
import ar.edu.poo2.tpFinal.seleccionadorCircuito.SeleccionadorCircuito;

public class TerminalPortuariaEnvioMailTest {
	private TerminalPortuaria terminalPortuaria;
	private MailManager mailManager;
	private Buque buque;
	private Viaje viajeUno;
	private Viaje viajeDos;
	private Orden ordenUno;
	private Orden ordenDos;
	
	@Before
	public void setup() {
		ordenUno = mock(Orden.class);
		ordenDos = mock(Orden.class);
		viajeUno = mock(Viaje.class);
		viajeDos = mock(Viaje.class);
		mailManager = mock(MailManager.class);
		terminalPortuaria = new TerminalPortuaria(mailManager, mock(SeleccionadorCircuito.class));
	}
	
	@Test
	public void testSeEnviaMail() {
		List<Orden> ordenes = new ArrayList<>();
		ordenes.add(ordenUno);
		ordenes.add(ordenDos);
		
		when(ordenUno.getViajeActual()).thenReturn(viajeUno);
		when(ordenDos.getViajeActual()).thenReturn(viajeDos);
		
		terminalPortuaria.notificarPorEmail(buque, ordenes, cliente -> mock(Mail.class));
		
		verify(mailManager, times(2)).enviarMailConFactura(any(), any());;
	}	
	
	@Test
	public void testNoSeEnviaMail() {
		List<Orden> ordenes = new ArrayList<>();

		terminalPortuaria.notificarPorEmail(buque, ordenes, cliente -> mock(Mail.class));
		
		verify(mailManager, never()).enviarMailConFactura(any(), any());;
	}
	
}
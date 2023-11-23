package terminalPortuaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.poo2.tpFinal.MailManager;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Naviera;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;
import ar.edu.poo2.tpFinal.busquedaMaritima.*;
import ar.edu.poo2.tpFinal.seleccionadorCircuito.SeleccionadorCircuito;

public class TerminalPortuariaBusquedaMaritimaTest {
	private TerminalPortuaria terminal;
	private Viaje viaje1;
	private Viaje viaje2;
	private Viaje viaje3;
	private Viaje viaje4;
	private Naviera naviera1;
	private Naviera naviera2;
	private Naviera naviera3;
	
	@Before
	public void setup() {
		viaje1 = mock(Viaje.class);
		viaje2 = mock(Viaje.class);
		viaje3 = mock(Viaje.class);
		viaje4 = mock(Viaje.class);
		naviera1 = mock(Naviera.class);
		naviera2 = mock(Naviera.class);
		naviera3 = mock(Naviera.class);
		terminal = new TerminalPortuaria(mock(MailManager.class), mock(SeleccionadorCircuito.class));
	}
	
	@Test
	public void testViajesCoinciden() {
		
		// Mockeo para que siempre agregue a terminal
		when(naviera1.tieneCircuitoConTerminal(any())).thenReturn(true);
		when(naviera2.tieneCircuitoConTerminal(any())).thenReturn(true);
		when(naviera3.tieneCircuitoConTerminal(any())).thenReturn(true);
		
		HashSet<Viaje> viajesNaviera1 = new HashSet<>();
		
		// No filtra por destino
		viajesNaviera1.add(viaje1);
		when(viaje1.getDestino()).thenReturn(mock(TerminalPortuaria.class));
		when(viaje1.getFechaLlegada()).thenReturn(LocalDateTime.of(2023, 10, 11, 0 , 0));

		// Filtra por ambos
		viajesNaviera1.add(viaje2);		
		when(viaje2.getDestino()).thenReturn(terminal);
		when(viaje2.getFechaLlegada()).thenReturn(LocalDateTime.of(2021, 10, 11, 0 , 0));
		
		when(naviera1.getViajes()).thenReturn(viajesNaviera1);
		
		HashSet<Viaje> viajesNaviera2 = new HashSet<>();
		
		// No filtra por fecha
		viajesNaviera2.add(viaje3);
		when(viaje3.getDestino()).thenReturn(terminal);
		when(viaje3.getFechaLlegada()).thenReturn(LocalDateTime.of(2024, 10, 11, 0 , 0));
		
		when(naviera2.getViajes()).thenReturn(viajesNaviera2);
		
		HashSet<Viaje> viajesNaviera3 = new HashSet<>();
		
		// Filtra por ambos
		viajesNaviera3.add(viaje4);
		when(viaje4.getDestino()).thenReturn(terminal);
		when(viaje4.getFechaLlegada()).thenReturn(LocalDateTime.of(2019, 3, 1, 0 , 0));
		
		when(naviera3.getViajes()).thenReturn(viajesNaviera3);
		
		LocalDateTime fechaLimite = LocalDateTime.of(2023, 11, 13, 0, 0); 
		
		BusquedaMaritima busqueda = new And(new FechaLlegada(fecha -> fecha.isBefore(fechaLimite)), new PuertoDestino(terminal));
				
		// Agrego navieras a terminal
		terminal.registrarNaviera(naviera1);
		terminal.registrarNaviera(naviera2);
		terminal.registrarNaviera(naviera3);
		
		List<Viaje> viajesCoincidentes = terminal.viajesQueCoincidenConBusqueda(busqueda);
		
		assertEquals(2, viajesCoincidentes.size());
		assertTrue(viajesCoincidentes.contains(viaje2));
		assertTrue(viajesCoincidentes.contains(viaje4));
		
	}
	
	@Test
	public void sinViajesEntoncesDevuelveListaVacia() {
		LocalDateTime fechaLimite = LocalDateTime.of(2023, 11, 13, 0, 0); 
		BusquedaMaritima busqueda = new And(new FechaLlegada(fecha -> fecha.isBefore(fechaLimite)), new PuertoDestino(terminal));
		
		List<Viaje> viajesCoincidentes = terminal.viajesQueCoincidenConBusqueda(busqueda);
		assertTrue(viajesCoincidentes.isEmpty());
	}
	
	@Test
	public void tieneViajesPeroNoCoinciden() {
		when(naviera1.tieneCircuitoConTerminal(any())).thenReturn(true);
		
		HashSet<Viaje> viajesNaviera1 = new HashSet<>();
		
		// No filtra por destino
		viajesNaviera1.add(viaje1);
		when(viaje1.getDestino()).thenReturn(mock(TerminalPortuaria.class));
		when(viaje1.getFechaLlegada()).thenReturn(LocalDateTime.of(2023, 10, 11, 0 , 0));

		// No filtra por fecha
		viajesNaviera1.add(viaje2);		
		when(viaje2.getDestino()).thenReturn(terminal);
		when(viaje2.getFechaLlegada()).thenReturn(LocalDateTime.of(2025, 10, 11, 0 , 0));
		
		when(naviera1.getViajes()).thenReturn(viajesNaviera1);
		
		terminal.registrarNaviera(naviera1);
		
		LocalDateTime fechaLimite = LocalDateTime.of(2023, 11, 13, 0, 0); 
		BusquedaMaritima busqueda = new And(new FechaLlegada(fecha -> fecha.isBefore(fechaLimite)), new PuertoDestino(terminal));
		
		List<Viaje> viajesCoincidentes = terminal.viajesQueCoincidenConBusqueda(busqueda);
		assertTrue(viajesCoincidentes.isEmpty());
	}
	
}
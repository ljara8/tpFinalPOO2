package ar.edu.poo2.tpFinal.clientes;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;
import ar.edu.poo2.tpFinal.clientes.*;
import ar.edu.poo2.tpFinal.contyserv.Container;
import ar.edu.poo2.tpFinal.ordenes.FacturaResponsableViaje;
import ar.edu.poo2.tpFinal.ordenes.FacturaSimple;
import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

class testShipper {
	private Shipper shipper;
	private OrdenExportacion orden;
	private OrdenImportacion orden2;
	private Exception excepcion = new Exception("No puede abonar una orden de importacion");
	private String nombre = "Lucio Jara";
	private String nombre2 = "Lucio Jara Messi";
	private String email = "luciojara@gmail.com";
	private String email2 = "luciojara@hotmail.com";
	private Container cont;
	private Camion cam;
	private Chofer chofer;
	private Viaje viaje;
	private FacturaSimple fact;

	@BeforeEach
	void setUp() throws Exception {
		shipper = new Shipper(email, nombre, orden);
		viaje = mock(Viaje.class);
		when(viaje.getOrigen()).thenReturn(mock(TerminalPortuaria.class));
		orden = new OrdenExportacion(shipper, cont, cam, chofer, viaje, fact);
		cont = mock(Container.class);
		cam = mock(Camion.class);
		chofer = mock(Chofer.class);
		viaje = mock(Viaje.class);
		fact = mock(FacturaSimple.class);
	}

	@Test
	void testExcepcionAbonar() throws Exception {

		assertThrowsExactly(Exception.class, () -> shipper.abonarFacturacion(orden2));

	}

	@Test
	void testGetOrdenFalse() throws Exception {

		assertNotEquals(shipper.getOrdenExp(), orden);
	}

	@Test
	void testGetNombreFalse() {

		assertNotEquals(nombre2, shipper.nombreCompleto());
	}

	@Test
	void testGetNombre() {

		assertEquals(nombre, shipper.nombreCompleto());
	}

	@Test
	void testGetEmail() {

		assertEquals(email, shipper.getEmail());
	}

	@Test
	void testGetEmailFalse() {

		assertNotEquals(email2, shipper.getEmail());
	}

}
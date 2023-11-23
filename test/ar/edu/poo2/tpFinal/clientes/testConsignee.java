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
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;
import ar.edu.poo2.tpFinal.clientes.Consignee;
import ar.edu.poo2.tpFinal.contyserv.Container;
import ar.edu.poo2.tpFinal.ordenes.FacturaResponsableViaje;
import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

class testConsignee {
	private Consignee consignee;
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
	private FacturaResponsableViaje fact;

	@BeforeEach
	void setUp() throws Exception {
		consignee = new Consignee(email, nombre, orden2);
		cont = mock(Container.class);
		cam = mock(Camion.class);
		chofer = mock(Chofer.class);
		viaje = mock(Viaje.class);
		fact = mock(FacturaResponsableViaje.class);

		orden2 = new OrdenImportacion(consignee, cont, cam, chofer, viaje, fact);
	}

	@Test
	void testAbonar() throws Exception {

		assertEquals(consignee.abonarFacturacion(orden2), 0);
	}

	@Test
	void testExcepcionAbonar() throws Exception {

		assertThrowsExactly(Exception.class, () -> consignee.abonarFacturacion(orden));

	}


	@Test
	void testGetNombreFalse() {

		assertNotEquals(nombre2, consignee.nombreCompleto());
	}

	@Test
	void testGetNombre() {

		assertEquals(nombre, consignee.nombreCompleto());
	}

	@Test
	void testGetEmail() {

		assertEquals(email, consignee.getEmail());
	}

	@Test
	void testGetEmailFalse() {

		assertNotEquals(email2, consignee.getEmail());
	}

}
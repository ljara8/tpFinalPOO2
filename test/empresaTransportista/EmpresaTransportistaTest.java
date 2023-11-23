package empresaTransportista;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.EmpresaTransportista;

class EmpresaTransportistaTest {
	
	private Camion camion1;
	private Camion camion2;
	private Camion camion3;
	private Chofer chofer1;
	private Chofer chofer2;
	private Chofer chofer3;
	private EmpresaTransportista empresa;
	
	@BeforeEach
	void setUp() {
		camion1 = mock(Camion.class);
		camion2 = mock(Camion.class);
		camion3 = mock(Camion.class);
		chofer1 = mock(Chofer.class);
		chofer2 = mock(Chofer.class);
		chofer3 = mock(Chofer.class);
		empresa = new EmpresaTransportista();
		empresa.agregarCamion(camion1);
		empresa.agregarCamion(camion2);
		empresa.agregarChofer(chofer1);
		empresa.agregarChofer(chofer2);
	}
	
	@Test
	void testCamionesQueTiene() {
		HashSet<Camion> camionesEsperados = new HashSet<>();
		camionesEsperados.add(camion1);
		camionesEsperados.add(camion2);
		
		assertEquals(camionesEsperados, empresa.getCamiones());
	}
	
	@Test
	void testChoferesQueTiene() {
		HashSet<Chofer> choferesEsperados = new HashSet<>();
		choferesEsperados.add(chofer1);
		choferesEsperados.add(chofer2);
		
		assertEquals(choferesEsperados, empresa.getChoferes());
	}
	
	@Test
	void TestTieneChofer() {
		
		assertTrue(empresa.estaChoferEnEmpresa(chofer1));
	}
	
	@Test
	void TestNoTieneChofer() {
		
		assertFalse(empresa.estaChoferEnEmpresa(chofer3));
	}
	
	@Test
	void TestTieneCamion() {
		
		assertTrue(empresa.estaCamionEnEmpresa(camion1));;
	}
	
	@Test
	void TestNoTieneCamion() {
		
		assertFalse(empresa.estaCamionEnEmpresa(camion3));;
	}
}
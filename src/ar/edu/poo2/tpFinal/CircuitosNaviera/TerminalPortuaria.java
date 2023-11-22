package ar.edu.poo2.tpFinal.CircuitosNaviera;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

import ar.edu.poo2.tpFinal.busquedaMaritima.BusquedaMaritima;
import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.Consignee;
import ar.edu.poo2.tpFinal.EmpresaTransportista;
import ar.edu.poo2.tpFinal.EntregaTerrestre;
import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;
import ar.edu.poo2.tpFinal.seleccionadorCircuito.SeleccionadorCircuito;
import ar.edu.poo2.tpFinal.Shipper;

public class TerminalPortuaria {

	private BusquedaMaritima criterio;
	private SeleccionadorCircuito seleccion;
	private HashSet<Naviera> navieras = new HashSet<Naviera>();
	private List<Shipper> shippers = new ArrayList<Shipper>();
	private List<Consignee> consignees = new ArrayList<Consignee>();
	private List<EmpresaTransportista> empresasTransportistas = new ArrayList<EmpresaTransportista>();
	private List<Camion> camiones = new ArrayList<Camion>();
	private List<Chofer> choferes = new ArrayList<Chofer>();
	private HashSet<CircuitoMaritimo> circuitos = new HashSet<CircuitoMaritimo>();
	private List<OrdenExportacion> ordenExportaciones = new ArrayList<OrdenExportacion>();
	private List<OrdenImportacion> ordenImportaciones = new ArrayList<OrdenImportacion>();

	public void registrarNaviera(Naviera n) {
		verificarSiEsNavieraCorrecta(n);
		navieras.add(n);
	}

	private void verificarSiEsNavieraCorrecta(Naviera n) {
		if(!n.tieneCircuitoConTerminal(this)) {
			throw new NoSuchElementException("Terminal no registrada en la naviera");
		}
	}

	public void registrarShipper(Shipper s) {
		shippers.add(s);
	}

	public void registrarConsignee(Consignee c) {
		consignees.add(c);
	}

	public void registrarEmpresasTransportistas(EmpresaTransportista et) {
		empresasTransportistas.add(et);
	}

	public void registrarCamion(Camion c) {
		camiones.add(c);
	}

	public void registrarChofer(Chofer c) {
		choferes.add(c);
	}

	public void registrarCircuitoMaritimo(CircuitoMaritimo cm) {
		verificarSiEsCircuitoCorrecto(cm);
		circuitos.add(cm);
	}

	private void verificarSiEsCircuitoCorrecto(CircuitoMaritimo cm) {
		if(!cm.tieneTerminalEnTrayecto(this)) {
			throw new NoSuchElementException("Terminal no registrada en el circuito");
		}
	}

	public void setSeleccionadorCircuito(SeleccionadorCircuito s) {
		this.seleccion = s;
	}

	public HashSet<CircuitoMaritimo> mejorCircuitoHaciaTerminal(TerminalPortuaria terminal) {
		return terminal.getCircuitos(); // recorrer lista de circuitos maritimos y retornar la que sea segun el criterio
										// de busqueda maritima
	}

	private HashSet<CircuitoMaritimo> getCircuitos() {
		return circuitos;
	}
	
	public LocalDateTime proximaFechaDePartidaHaciaDestino(TerminalPortuaria destino) {
		return this.navieras.stream()
				.filter(n->n.tieneCircuitoConTrayecto(destino, destino))
				.map(n->n.proximaFechaDePartidaADestino(this, destino))
				.min(LocalDateTime::compareTo)
				.orElseThrow(()-> new NoSuchElementException("No hay trayecto entre estas terminales"));
	}

	public int cuantoTardaEnLlegarNavieraADestino(Naviera n, TerminalPortuaria destino) throws Exception {
		return n.cuantoTardaEnLlegarNaviera(this, destino);
	}

	public void exportar(EntregaTerrestre et) {

	}

	public void importar(EntregaTerrestre et) {

	}

	public void registrarOrdenExportacion(OrdenExportacion orden) {
		// aca retorna un valor Turno, no un void.Y se calculan a partir de los datos de
		// la orden
	}

	public void registrarOrdenImportacion(OrdenImportacion orden) {

	}

	public List<OrdenExportacion> getOrdenExportaciones() {
		return ordenExportaciones;
	}

	public List<OrdenImportacion> getOrdenImportaciones() {
		return ordenImportaciones;
	}

}

package ar.edu.poo2.tpFinal;

import java.util.ArrayList;
import java.util.List;

import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

public class TerminalPortuaria {

	private BusquedaMaritima criterio;
	private SeleccionadorCircuito seleccion;
	private List<Naviera> navieras = new ArrayList<Naviera>();
	private List<Shipper> shippers = new ArrayList<Shipper>();
	private List<Consignee> consignees = new ArrayList<Consignee>();
	private List<EmpresaTransportista> empresasTransportistas = new ArrayList<EmpresaTransportista>();
	private List<Camion> camiones = new ArrayList<Camion>();
	private List<Chofer> choferes = new ArrayList<Chofer>();
	private List<CircuitoMaritimo> circuitos = new ArrayList<CircuitoMaritimo>();
	private List<OrdenExportacion> ordenExportaciones = new ArrayList<OrdenExportacion>();
	private List<OrdenImportacion> ordenImportaciones = new ArrayList<OrdenImportacion>();

	public void registrarNaviera(Naviera n) {
		navieras.add(n);
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
		circuitos.add(cm);
	}

	public void setSeleccionadorCircuito(SeleccionadorCircuito s) {
		this.seleccion = s;
	}

	public List<CircuitoMaritimo> mejorCircuitoHaciaTerminal(TerminalPortuaria terminal) {
		return terminal.getCircuitos(); // recorrer lista de circuitos maritimos y retornar la que sea segun el criterio
										// de busqueda maritima
	}

	private List<CircuitoMaritimo> getCircuitos() {
		return circuitos;
	}

	public int cuantoTardaEnLlegarNavieraADestino(Naviera n, TerminalPortuaria destino) {
		return 0; // recorrido sobre circuitos de la naviera dada y retornar la que menor tiempo
					// tarda en la suma de los tramos
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

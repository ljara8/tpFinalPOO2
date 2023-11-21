package ar.edu.poo2.tpFinal.CircuitosNaviera;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import ar.edu.poo2.tpFinal.busquedaMaritima.BusquedaMaritima;
import ar.edu.poo2.tpFinal.Buque;
import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.EmpresaTransportista;
import ar.edu.poo2.tpFinal.EntregaTerrestre;
import ar.edu.poo2.tpFinal.Mail;
import ar.edu.poo2.tpFinal.MailManager;
import ar.edu.poo2.tpFinal.ordenes.Orden;
import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;
import ar.edu.poo2.tpFinal.seleccionadorCircuito.SeleccionadorCircuito;
import ar.edu.poo2.tpFinal.Clientes.Cliente;
import ar.edu.poo2.tpFinal.Clientes.Consignee;
import ar.edu.poo2.tpFinal.Clientes.Shipper;

public class TerminalPortuaria {

	private MailManager mailManager;
	private BusquedaMaritima busquedaMaritima;
	private SeleccionadorCircuito seleccionadorCircuito;
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

	public void setSeleccionadorCircuito(SeleccionadorCircuito seleccionadorCircuito) {
		this.seleccionadorCircuito = seleccionadorCircuito;
	}
	
	public void setBusquedaMaritima(BusquedaMaritima busquedaMaritima) {
		this.busquedaMaritima = busquedaMaritima;
	}
	
	public List<Viaje> viajesQueCoincidenConBusqueda(BusquedaMaritima busquedaMaritima) {
		List<Viaje> todosLosViajes = navieras.stream().flatMap(naviera -> naviera.getViajes().stream()).toList();
		return todosLosViajes.stream().filter(viaje -> busquedaMaritima.evaluar(viaje)).toList();
	}
	
	public CircuitoMaritimo mejorCircuitoHaciaTerminal(TerminalPortuaria terminal) {
		List<CircuitoMaritimo> circuitosQueHacenElRecorrido = navieras.stream()
				.flatMap(naviera -> naviera.circuitosQuePasanPorTerminales(this, terminal).stream())
				.toList();
		return seleccionadorCircuito.mejorCircuitoEntre(circuitosQueHacenElRecorrido);
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

	public void notificarSobreLlegadaInminente(Buque buque) {
		notificarPorEmail(buque, ordenImportaciones, this::enviarMailLlegadaInminenteACliente);
	}
	
	public void notificarDesembarque(Buque buque) {
		notificarPorEmail(buque, ordenExportaciones, this::enviarMailDesembarco);
	}
	
	public void notificarPorEmail(Buque buque, List<? extends Orden> ordenes, Function<Cliente, Mail> mapperDeEmail) {
		ordenes.stream()
		.filter(orden -> {
			Viaje viaje = orden.getViajeActual();
			return viaje.getBuque() == buque;
		})
		.map(orden -> orden.getCliente())
		.map(cliente -> mapperDeEmail.apply(cliente))
		.forEach(mail -> mailManager.enviarMail(mail));
	}

	private Mail enviarMailLlegadaInminenteACliente(Cliente cliente) {
		return new Mail(
						"Tu pedido está llegando a la terminal", 
						cliente.getEmail(), 
						"Tu pedido se encuentra a menos de 50km de la terminal. Acércate en breves para reclamarlo"
					);
	}
	
	private Mail enviarMailDesembarco(Cliente cliente) {
		return new Mail(
						"Tu pedido ha salido de la terminal", 
						cliente.getEmail(), 
						"Tu pedido ha zarpado de la terminal y se encuentra a más de un kilómetro de distancia. Mantente al tanto sobre el estado del viaje"
					);
	}

}

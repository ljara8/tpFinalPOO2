package ar.edu.poo2.tpFinal.CircuitosNaviera;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import ar.edu.poo2.tpFinal.busquedaMaritima.BusquedaMaritima;
import ar.edu.poo2.tpFinal.clientes.Cliente;
import ar.edu.poo2.tpFinal.clientes.Consignee;
import ar.edu.poo2.tpFinal.clientes.Shipper;
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
import ar.edu.poo2.tpFinal.ordenes.Turno;
import ar.edu.poo2.tpFinal.seleccionadorCircuito.SeleccionadorCircuito;

public class TerminalPortuaria {

	private MailManager mailManager;
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
	private List<Orden> ordenExportacionesRetiradas = new ArrayList<Orden>();
	private List<Orden> ordenImportacionesRetiradas = new ArrayList<Orden>();
	private List<Turno> turnosImportaciones = new ArrayList<>();
	private List<Turno> turnosExportaciones = new ArrayList<>();

	public TerminalPortuaria(MailManager mailManager, SeleccionadorCircuito seleccionadorCircuito) {
		this.mailManager = mailManager;
		this.seleccionadorCircuito = seleccionadorCircuito;
	}

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

	public List<Viaje> viajesQueCoincidenConBusqueda(BusquedaMaritima busquedaMaritima) {
		List<Viaje> todosLosViajes = navieras.stream().flatMap(naviera -> naviera.getViajes().stream()).toList();
		return todosLosViajes.stream().filter(viaje -> busquedaMaritima.evaluar(viaje)).toList();
	}

	public CircuitoMaritimo mejorCircuitoHaciaTerminal(TerminalPortuaria terminal) {
		List<CircuitoMaritimo> circuitosQueHacenElRecorrido = navieras.stream()
				.flatMap(naviera -> naviera.circuitosQuePasanPorTerminales(this, terminal).stream()).toList();
		return seleccionadorCircuito.mejorCircuitoEntre(circuitosQueHacenElRecorrido);
	}

	private List<CircuitoMaritimo> getCircuitos() {
		return circuitos;
	}

	public int cuantoTardaEnLlegarNavieraADestino(Naviera n, TerminalPortuaria destino) {
		return 0; // recorrido sobre circuitos de la naviera dada y retornar la que menor tiempo
					// tarda en la suma de los tramos
	}

	public void exportar(EntregaTerrestre et) throws IllegalAccessException {
		Turno turnoDeExportador = 
				turnosExportaciones.stream()
					.filter( turno -> 
						turno.getCamion().equals(et.getCamion()) 
						&& turno.getChofer() == et.getChofer() 
						&& turno.estaAHorario(et.getHorarioArribo())
						&& turno.equals(et.getTurno())
					)
					.findFirst()
					.orElseThrow(() -> new IllegalAccessException("Su entrega no es válida. No cumple los parámetros de seguridad."));
		turnoDeExportador.getCliente().cobrarMonto(turnoDeExportador.getOrden().getFactura().getMontoTotalFacturado(turnoDeExportador.getOrden()));
		turnosExportaciones.remove(turnoDeExportador);
		ordenExportaciones.remove(turnoDeExportador.getOrden());
		ordenExportacionesRetiradas.add(turnoDeExportador.getOrden());
	}

	public void importar(EntregaTerrestre et) throws IllegalAccessException {
		Turno turnoDeImportador = 
				turnosImportaciones.stream()
					.filter( turno -> 
						turno.getCamion().equals(et.getCamion()) 
						&& turno.getChofer() == et.getChofer() 
						&& turno.estaAHorario(et.getHorarioArribo())
						&& turno.equals(et.getTurno())
					)
					.findFirst()
					.orElseThrow(() -> new IllegalAccessException("Su entrega no es válida. No cumple los parámetros de seguridad."));
		turnoDeImportador.getCliente().cobrarMonto(turnoDeImportador.getOrden().getFactura().getMontoTotalFacturado(turnoDeImportador.getOrden()));
		turnosExportaciones.remove(turnoDeImportador);
		ordenExportaciones.remove(turnoDeImportador.getOrden());
		ordenImportacionesRetiradas.add(turnoDeImportador.getOrden());
	}

	public Turno registrarOrdenExportacion(OrdenExportacion orden) {
		Turno turno = new Turno(orden, 12, 3);
		this.getOrdenExportaciones().add(orden);
		turnosExportaciones.add(turno);
		return turno;
	}

	public Turno registrarOrdenImportacion(OrdenImportacion orden) {
		Turno turno = new Turno(orden, 24, 0);
		this.getOrdenImportaciones().add(orden);
		turnosImportaciones.add(turno);
		return turno;
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
		ordenes.stream().filter(orden -> {
			Viaje viaje = orden.getViajeActual();
			return viaje.getBuque() == buque;
		}).map(orden -> orden.getCliente()).map(cliente -> mapperDeEmail.apply(cliente))
				.forEach(mail -> mailManager.enviarMail(mail));
	}

	private Mail enviarMailLlegadaInminenteACliente(Cliente cliente) {
		return new Mail("Tu pedido está llegando a la terminal", cliente.getEmail(),
				"Tu pedido se encuentra a menos de 50km de la terminal. Acércate en breves para reclamarlo");
	}

	private Mail enviarMailDesembarco(Cliente cliente) {
		return new Mail("Tu pedido ha salido de la terminal", cliente.getEmail(),
				"Tu pedido ha zarpado de la terminal y se encuentra a más de un kilómetro de distancia. Mantente al tanto sobre el estado del viaje");
	}

}

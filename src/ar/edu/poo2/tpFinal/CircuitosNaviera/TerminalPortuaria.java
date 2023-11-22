package ar.edu.poo2.tpFinal.CircuitosNaviera;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
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
	private BusquedaMaritima busquedaMaritima;
	private SeleccionadorCircuito seleccionadorCircuito;

	private HashSet<Naviera> navieras = new HashSet<Naviera>();
	private HashSet<Shipper> shippers = new HashSet<Shipper>();
	private HashSet<Consignee> consignees = new HashSet<Consignee>();
	private HashSet<EmpresaTransportista> empresasTransportistas = new HashSet<EmpresaTransportista>();
	private HashSet<Camion> camiones = new HashSet<Camion>();
	private HashSet<Chofer> choferes = new HashSet<Chofer>();
	private HashSet<CircuitoMaritimo> circuitos = new HashSet<CircuitoMaritimo>();
	private HashSet<OrdenExportacion> ordenExportaciones = new HashSet<OrdenExportacion>();
	private HashSet<OrdenImportacion> ordenImportaciones = new HashSet<OrdenImportacion>();


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
				.flatMap(naviera -> naviera.circuitosQuePasanPorTerminales(this, terminal).stream()).toList();
		return seleccionadorCircuito.mejorCircuitoEntre(circuitosQueHacenElRecorrido);
	}

	private HashSet<CircuitoMaritimo> getCircuitos() {
		return circuitos;
	}

	public int cuantoTardaEnLlegarNavieraADestino(Naviera n, TerminalPortuaria destino) throws Exception {
		return n.cuantoTardaEnLlegarNaviera(this, destino);
	}
	
	public LocalDateTime proximaFechaDePartidaHaciaDestino(TerminalPortuaria destino) {
		return this.navieras.stream()
				.filter(n->n.tieneCircuitoConTrayecto(destino, destino))
				.map(n->n.proximaFechaDePartidaADestino(this, destino))
				.min(LocalDateTime::compareTo)
				.orElseThrow(()-> new NoSuchElementException("No hay trayecto entre estas terminales"));
	}

//TEMPLATE METHOD
	public void exportar(EntregaTerrestre et) {
		// camion llega carga a Terminal
		// verificar Horario, camion, chofer informado por Shipper
		// agregar carga a terminal

	}

	public void importar(EntregaTerrestre et) {
		// verificar Horario (cobrar excedente si pasa del permitido)
		// verificar camion, chofer informado por Consignee
		// retirar carga de terminal

	}

	public Turno registrarOrdenExportacion(OrdenExportacion orden) {
		Turno turno = new Turno(orden);
		// registrar orden
		this.getOrdenExportaciones().add(orden);
		// asignar turno shipper
		return turno;
	}

	public void registrarOrdenImportacion(OrdenImportacion orden) {
		// registrar orden
		this.getOrdenImportaciones().add(orden);

	}

	public HashSet<OrdenExportacion> getOrdenExportaciones() {
		return ordenExportaciones;
	}

	public HashSet<OrdenImportacion> getOrdenImportaciones() {
		return ordenImportaciones;
	}

	public void notificarSobreLlegadaInminente(Buque buque) {
		notificarPorEmail(buque, ordenImportaciones, this::enviarMailLlegadaInminenteACliente);
	}

	public void notificarDesembarque(Buque buque) {
		notificarPorEmail(buque, ordenExportaciones, this::enviarMailDesembarco);
	}

	public void notificarPorEmail(Buque buque, HashSet<? extends Orden> ordenes, Function<Cliente, Mail> mapperDeEmail) {
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

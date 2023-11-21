package ar.edu.poo2.tpFinal.ordenes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.Cliente;
import ar.edu.poo2.tpFinal.Consignee;
import ar.edu.poo2.tpFinal.Shipper;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;
import ar.edu.poo2.tpFinal.contyserv.Container;
import ar.edu.poo2.tpFinal.contyserv.Refeer;
import ar.edu.poo2.tpFinal.contyserv.Servicio;

public abstract class Orden {
	private Cliente cliente;
	private Container cont;
	private Camion camion;
	private Chofer chofer;
	private Viaje viajeActual;
	private List<Servicio> serviciosContratados = new ArrayList<Servicio>();
	private Desglose desglose;
	private TerminalPortuaria terminal;
	private int horasDeDemora;

	Orden(Cliente client, Container cont, Camion cam, Chofer chofer, Viaje viaje, Desglose desg, TerminalPortuaria term,
			int horas) {
		this.cliente = client;
		this.cont = cont;
		this.camion = cam;
		this.chofer = chofer;
		this.viajeActual = viaje;
		this.desglose = desg;
		this.terminal = term;
		this.horasDeDemora = horas;
	}

	public Orden(Shipper client, Container cont2, Camion cam, Chofer chofer2, Viaje viaje) {
	}

	public Orden(Consignee client, Container cont2, Camion cam, Chofer chofer2, Viaje viaje) {
	}

	public double getTiempoConexion(Refeer refri) {
		// consultar compas
		return 0;
	}

	public Desglose getDesglose() {
		return desglose;
	}

	public int getHorasDeDemora() {
		return horasDeDemora;

	}

	public abstract Factura getFactura();

	public Container getContainer() {
		return cont;
	}

	public List<Servicio> getServiciosContratados() {
		return serviciosContratados;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Camion getCamion() {
		return camion;
	}

	public Viaje getViajeActual() {
		return viajeActual;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public LocalDate getFechaLlegadaADestino() {
		return this.getViajeActual().getFechaLlegada();
	}

	public LocalDate getFechaSalidaADestino() {
		return this.getViajeActual().getFechaSalida();
	}

}
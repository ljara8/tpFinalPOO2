package ar.edu.poo2.tpFinal.ordenes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;
import ar.edu.poo2.tpFinal.clientes.Cliente;
import ar.edu.poo2.tpFinal.clientes.Consignee;
import ar.edu.poo2.tpFinal.clientes.Shipper;
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
	private TerminalPortuaria terminal;

	Orden(Cliente client, Container cont, Camion cam, Chofer chofer, Viaje viaje, TerminalPortuaria term) {
		this.cliente = client;
		this.cont = cont;
		this.camion = cam;
		this.chofer = chofer;
		this.viajeActual = viaje;
		this.terminal = term;
	}

	public double getTiempoConexion(Refeer refri) {
		// consultar compas
		return 0;
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

	public LocalDateTime getFechaLlegadaADestino() {
		return this.getViajeActual().getFechaLlegada();
	}

	public LocalDateTime getFechaSalidaADestino() {
		return this.getViajeActual().getFechaSalida();
	}

	public int getHorasDeDemora() {
		return 0;
	}

}
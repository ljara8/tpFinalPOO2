package ar.edu.poo2.tpFinal.ordenes;

import java.util.ArrayList;
import java.util.List;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.Cliente;
import ar.edu.poo2.tpFinal.Factura;
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
	private int horasDeDemora;

	Orden(Cliente client, Container cont, Camion cam, Chofer chofer, Viaje viaje) {
		this.cliente = client;
		this.cont = cont;
		this.camion = cam;
		this.chofer = chofer;
		this.viajeActual = viaje;
	}

	public double getTiempoConexion(Refeer refri) {
		return 0;
	}

	public int getHorasDeDemora() {
		return horasDeDemora;

	}

	public abstract Factura getFactura();

	public Object getContainer() {
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

}

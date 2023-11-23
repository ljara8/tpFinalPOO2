package ar.edu.poo2.tpFinal;

import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.GPS.Localizable;
import ar.edu.poo2.tpFinal.buqueState.BuqueState;
import ar.edu.poo2.tpFinal.buqueState.Outbound;
import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;

public class Buque implements Localizable {

	private BuqueState buqueState;
	private OrdenExportacion ordenExportacion;

	public Buque(OrdenExportacion ordenExportacion) {
		this.ordenExportacion = ordenExportacion;
		this.buqueState = new Outbound();
	}

	public BuqueState getBuqueState() {
		return buqueState;
	}

	public void setBuqueState(BuqueState state) {
		this.buqueState = state;
	}

	public void notificarSobreLlegadaInminente() {
		TerminalPortuaria destino = ordenExportacion.getTerminalDestino();
		destino.notificarSobreLlegadaInminente(this);
	}

	public void notificarPartidaDeTerminal() {
		TerminalPortuaria destino = ordenExportacion.getTerminalDestino();
		destino.notificarDesembarque(this);
	}

	@Override
	public void actualizarDistanciaDestino(double distancia) {
		buqueState.actualizarDistanciaDestino(distancia, this);
	}

}
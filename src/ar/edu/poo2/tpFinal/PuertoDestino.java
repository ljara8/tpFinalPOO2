package ar.edu.poo2.tpFinal;

public class PuertoDestino implements BusquedaMaritima{

	private TerminalPortuaria destino;
	
	public PuertoDestino(TerminalPortuaria destino) {
		this.destino = destino;
	}

	@Override
	public boolean evaluar(Viaje viaje) {
		return viaje.getDestino() == destino;
	}

}

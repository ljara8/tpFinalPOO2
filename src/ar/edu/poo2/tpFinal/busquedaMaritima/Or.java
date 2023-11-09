package ar.edu.poo2.tpFinal.busquedaMaritima;

import ar.edu.poo2.tpFinal.Viaje;

public class Or implements BusquedaMaritima{

	private BusquedaMaritima primeraCondicion;
	private BusquedaMaritima segundaCondicion;
	
	public Or(BusquedaMaritima primeraCondicion, BusquedaMaritima segundaCondicion) {
		this.primeraCondicion = primeraCondicion;
		this.segundaCondicion = segundaCondicion;
	}
	
	@Override
	public boolean evaluar(Viaje viaje) {
		return primeraCondicion.evaluar(viaje) || segundaCondicion.evaluar(viaje);
	}
	
}

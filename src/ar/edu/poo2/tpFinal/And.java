package ar.edu.poo2.tpFinal;

public class And implements BusquedaMaritima{
	
	private BusquedaMaritima primeraCondicion;
	private BusquedaMaritima segundaCondicion;
	
	public And(BusquedaMaritima primeraCondicion, BusquedaMaritima segundaCondicion) {
		this.primeraCondicion = primeraCondicion;
		this.segundaCondicion = segundaCondicion;
	}
	
	@Override
	public boolean evaluar(Viaje viaje) {
		return primeraCondicion.evaluar(viaje) && segundaCondicion.evaluar(viaje);
	}

}

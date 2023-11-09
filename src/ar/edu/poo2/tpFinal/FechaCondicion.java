package ar.edu.poo2.tpFinal;

import java.util.Date;
import java.util.function.Predicate;

public abstract class FechaCondicion implements BusquedaMaritima {

private Predicate<Date> condicionFecha;
	
	public FechaCondicion(Predicate<Date> condicionFecha) {
		this.condicionFecha = condicionFecha;
	}
	
	@Override
	public boolean evaluar(Viaje viaje) {
		return condicionFecha.test(fechaCondicion(viaje));
	}
	
	/**
	 * @param viaje el viaje a evaluar la fecha.
	 * @return la fecha del viaje a evaluar.
	 */
	protected abstract Date fechaCondicion(Viaje viaje);

}

package ar.edu.poo2.tpFinal.busquedaMaritima;

import java.time.LocalDate;
import java.util.Date;
import java.util.function.Predicate;

import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;

public abstract class FechaCondicion implements BusquedaMaritima {

private Predicate<LocalDate> condicionFecha;
	
	public FechaCondicion(Predicate<LocalDate> condicionFecha) {
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
	protected abstract LocalDate fechaCondicion(Viaje viaje);

}

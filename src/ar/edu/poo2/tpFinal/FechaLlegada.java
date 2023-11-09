package ar.edu.poo2.tpFinal;

import java.util.Date;
import java.util.function.Predicate;

public class FechaLlegada extends FechaCondicion {
	
	public FechaLlegada(Predicate<Date> condicionFecha) {
		super(condicionFecha);
	}

	@Override
	protected Date fechaCondicion(Viaje viaje) { return viaje.getFechaLlegada(); }
	
}
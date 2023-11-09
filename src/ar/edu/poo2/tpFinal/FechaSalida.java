package ar.edu.poo2.tpFinal;

import java.util.Date;
import java.util.function.Predicate;

public class FechaSalida extends FechaCondicion {

	public FechaSalida(Predicate<Date> condicionFecha) {
		super(condicionFecha);
	}

	@Override
	protected Date fechaCondicion(Viaje viaje) { return viaje.getFechaSalida(); }

}

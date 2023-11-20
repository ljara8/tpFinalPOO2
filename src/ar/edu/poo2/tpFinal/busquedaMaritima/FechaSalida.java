package ar.edu.poo2.tpFinal.busquedaMaritima;

import java.time.LocalDate;
import java.util.Date;
import java.util.function.Predicate;

import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;

public class FechaSalida extends FechaCondicion {

	public FechaSalida(Predicate<LocalDate> condicionFecha) {
		super(condicionFecha);
	}

	@Override
	protected LocalDate fechaCondicion(Viaje viaje) { return viaje.getFechaSalida(); }

}
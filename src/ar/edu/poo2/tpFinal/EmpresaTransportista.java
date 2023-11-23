package ar.edu.poo2.tpFinal;

import java.util.HashSet;

public class EmpresaTransportista {
	
	private HashSet<Camion> camiones = new HashSet<>();
	private HashSet<Chofer> choferes = new HashSet<>();
	
	public HashSet<Camion> getCamiones() {
		return camiones;
	}
	
	public HashSet<Chofer> getChoferes() {
		return choferes;
	}
	
	public void agregarCamion(Camion camion) {
		this.camiones.add(camion);
	}
	
	public void agregarChofer(Chofer chofer) {
		this.choferes.add(chofer);
	}
	
	public boolean estaCamionEnEmpresa(Camion camion) {
		return this.camiones.stream().anyMatch(c->c.equals(camion));
	}
	
	public boolean estaChofernEnEmpresa(Chofer chofer) {
		return this.choferes.stream().anyMatch(c->c.equals(chofer));
	}
	
}

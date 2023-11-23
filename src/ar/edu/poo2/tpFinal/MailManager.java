package ar.edu.poo2.tpFinal;

import java.util.List;

import ar.edu.poo2.tpFinal.ordenes.Factura;

public interface MailManager {
	void enviarMail(Mail mail);
	void registrarCliente();
	List<Mail> enviados();
	void enviarMailConFactura(Mail mail, Factura factura);
}
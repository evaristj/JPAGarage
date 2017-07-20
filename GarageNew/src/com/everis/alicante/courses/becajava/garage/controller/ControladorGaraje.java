package com.everis.alicante.courses.becajava.garage.controller;

import java.io.IOException;

public interface ControladorGaraje {
	
	void listarPlazasLibres();
	void listarPlazasOcupadas();
	boolean reservarPlaza() throws IOException;
	void listarClientes() throws IOException;
	void listarReservas() throws IOException;
	void listarVehiculos() throws IOException;

}
package com.everis.alicante.becajava.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the vehicle database table.
 * 
 */
@Entity
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVEHICLE;

	private String vehicleModel;

	private String vehiclePlate;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="vehicle", fetch=FetchType.EAGER)
	private Set<Booking> bookings;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="idCLIENT")
	private Client client;

	public Vehicle() {
	}

	public int getIdVEHICLE() {
		return this.idVEHICLE;
	}

	public void setIdVEHICLE(int idVEHICLE) {
		this.idVEHICLE = idVEHICLE;
	}

	public String getVehicleModel() {
		return this.vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehiclePlate() {
		return this.vehiclePlate;
	}

	public void setVehiclePlate(String vehiclePlate) {
		this.vehiclePlate = vehiclePlate;
	}

	public Set<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setVehicle(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setVehicle(null);

		return booking;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
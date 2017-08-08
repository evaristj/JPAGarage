package com.everis.alicante.becajava.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the parkingplace database table.
 * 
 */
@Entity
@Table(name="parkingplace")
@NamedQueries({
	@NamedQuery(name="Parkingplace.findAll", query="SELECT p FROM Parkingplace p"),
	@NamedQuery(name="ParkingPlace.findFreePlaces", query="SELECT p FROM Parkingplace p where p.parkingstate=0")
})
public class Parkingplace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idParkingPlace;

	@Column(nullable=false)
	private int parkingNumber;

	@Column(nullable=false)
	private double parkingPrize;

	@Column(nullable=false)
	private double parkingSize;

	@Column(nullable=false)
	private byte parkingstate;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="parkingplace", fetch=FetchType.EAGER)
	private Set<Booking> bookings;

	public Parkingplace() {
	}

	public int getIdParkingPlace() {
		return this.idParkingPlace;
	}

	public void setIdParkingPlace(int idParkingPlace) {
		this.idParkingPlace = idParkingPlace;
	}

	public int getParkingNumber() {
		return this.parkingNumber;
	}

	public void setParkingNumber(int parkingNumber) {
		this.parkingNumber = parkingNumber;
	}

	public double getParkingPrize() {
		return this.parkingPrize;
	}

	public void setParkingPrize(double parkingPrize) {
		this.parkingPrize = parkingPrize;
	}

	public double getParkingSize() {
		return this.parkingSize;
	}

	public void setParkingSize(double parkingSize) {
		this.parkingSize = parkingSize;
	}

	public byte getParkingState() {
		return this.parkingstate;
	}

	public void setParkingState(byte parkingState) {
		this.parkingstate = parkingState;
	}

	public Set<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setParkingplace(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setParkingplace(null);

		return booking;
	}

	@Override
	public String toString() {
		return "Parkingplace [idParkingPlace=" + idParkingPlace + ", parkingNumber=" + parkingNumber + ", parkingPrize="
				+ parkingPrize + ", parkingSize=" + parkingSize + "]";
	}
	

}
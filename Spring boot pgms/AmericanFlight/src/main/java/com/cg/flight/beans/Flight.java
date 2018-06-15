package com.cg.flight.beans;
public class Flight {
private int id;
private String code;
private float price;
private String departureDate;
private String origin;
private String destination;
private int emptySeats;
private String type;
private int totalSeats;
public Flight() {
	super();
}
public Flight(int id, String code, float price, String departureDate, String origin, String destination, int emptySeats,
		String type, int totalSeats) {
	super();
	this.id = id;
	this.code = code;
	this.price = price;
	this.departureDate = departureDate;
	this.origin = origin;
	this.destination = destination;
	this.emptySeats = emptySeats;
	this.type = type;
	this.totalSeats = totalSeats;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getDepartureDate() {
	return departureDate;
}
public void setDepartureDate(String departureDate) {
	this.departureDate = departureDate;
}
public String getOrigin() {
	return origin;
}
public void setOrigin(String origin) {
	this.origin = origin;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public int getEmptySeats() {
	return emptySeats;
}
public void setEmptySeats(int emptySeats) {
	this.emptySeats = emptySeats;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getTotalSeats() {
	return totalSeats;
}
public void setTotalSeats(int totalSeats) {
	this.totalSeats = totalSeats;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((code == null) ? 0 : code.hashCode());
	result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
	result = prime * result + ((destination == null) ? 0 : destination.hashCode());
	result = prime * result + emptySeats;
	result = prime * result + id;
	result = prime * result + ((origin == null) ? 0 : origin.hashCode());
	result = prime * result + Float.floatToIntBits(price);
	result = prime * result + totalSeats;
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Flight other = (Flight) obj;
	if (code == null) {
		if (other.code != null)
			return false;
	} else if (!code.equals(other.code))
		return false;
	if (departureDate == null) {
		if (other.departureDate != null)
			return false;
	} else if (!departureDate.equals(other.departureDate))
		return false;
	if (destination == null) {
		if (other.destination != null)
			return false;
	} else if (!destination.equals(other.destination))
		return false;
	if (emptySeats != other.emptySeats)
		return false;
	if (id != other.id)
		return false;
	if (origin == null) {
		if (other.origin != null)
			return false;
	} else if (!origin.equals(other.origin))
		return false;
	if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
		return false;
	if (totalSeats != other.totalSeats)
		return false;
	if (type == null) {
		if (other.type != null)
			return false;
	} else if (!type.equals(other.type))
		return false;
	return true;
}
@Override
public String toString() {
	return "Flight [id=" + id + ", code=" + code + ", price=" + price + ", departureDate=" + departureDate + ", origin="
			+ origin + ", destination=" + destination + ", emptySeats=" + emptySeats + ", type=" + type
			+ ", totalSeats=" + totalSeats + "]";
}
}


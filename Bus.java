package com.BusManagementPrg.Bus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "BusTable") // Specifies the table name in the database
@DynamicUpdate // Enables dynamic updating of entity fields during the update operation

/*This class contais private attributes to represent software details and
 * providing getters and setters for accessing these attributes.
 */

public class Bus {

	@Id // Specifies the primary key for the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key value
	private Integer busId;

	@Column(name = "DriverName", nullable = false) // Specifies a column in the database table
	private String driverName;

	@Column(name = "Destination", nullable = false)
	private String destination;

	@Column(name = "Source", nullable = false)
	private String source;

	@Column(name = "Cost", nullable = false)
	private int cost;

	@Column(name = "totalSeat", nullable = false)
	private int total_seat;

	@Column
	private Boolean isAcBus;

	@Column
	private String travellersName;

	@Column
	private int ratings;
	
	

	/*@Column
	public int availableSeat;*/








	

	public Bus() {
		// Constructor with no arguments
	}


	public Bus(String driverName, String destination,String source,int cost,int total_seat,Boolean isAcBus,String travellersName,int ratings) {
		this.driverName = driverName;
		this.destination = destination;
		this.source=source;
		this.cost = cost;
		this.total_seat = total_seat;
		this.isAcBus=isAcBus;
		this.travellersName=travellersName;
		this.ratings=ratings;

	}


	// Getters and Setters for class properties
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getTotal_seat() {
		return total_seat;
	}

	public void setTotal_seat(int total_seat) {
		this.total_seat = total_seat;
	}

	public Boolean getIsAcBus() {
		return isAcBus;
	}

	public void setIsAcBus(Boolean isAcBus) {
		this.isAcBus = isAcBus;
	}



	public Integer getBusId() {
		return busId;
	}


	public void setBusId(Integer busId) {
		this.busId = busId;
	}


	public String getTravellersName() {
		return travellersName;
	}


	public void setTravellersName(String travellersName) {
		this.travellersName = travellersName;
	}

	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public int getRatings() {
		return ratings;
	}


	public void setRatings(int ratings) {
		this.ratings = ratings;
	}


	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", driverName=" + driverName + ", destination=" + destination + ", source="
				+ source + ", cost=" + cost + ", total_seat=" + total_seat + ", isAcBus=" + isAcBus
				+ ", travellersName=" + travellersName + ", ratings=" + ratings + "]";
	}
	
	
	/*public int getAvailableSeat() {
		return availableSeat;
	}


	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}*/


	







}

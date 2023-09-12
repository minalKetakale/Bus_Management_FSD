package com.BusManagementPrg.Bus;


import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_table")
@DynamicUpdate
public class User {

		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
		private Integer userID;
        private String userName;
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/mm/yyyy")
		private Date date;
		private String userEmail;
		
		@Column(name="numOfTicket")
		private int numOfTicket;
		
		
		@ManyToOne
		@JoinColumn(name="busId")
		
		private Bus busDetails;

		public User() {
			
		}

		public Integer getUserID() {
			return userID;
		}

		public String getUserName() {
			return userName;
		}

		public Date getDate() {
			return date;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public Bus getBusDetails() {
			return busDetails;
		}


		public void setUserID(Integer userID) {
			this.userID = userID;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		public void setDate(Date date) {
			this.date = date;
		}


		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}


		public void setBusDetails(Bus busDetails) {
			this.busDetails = busDetails;
		}

		public int getNumOfTicket() {
			return numOfTicket;
		}

		public void setNumOfTicket(int numOfTicket) {
			this.numOfTicket = numOfTicket;
		}

		@Override
		public String toString() {
			return "User [userID=" + userID + ", userName=" + userName + ", date=" + date + ", userEmail=" + userEmail
					+ ", numOfTicket=" + numOfTicket + ", busDetails=" + busDetails + "]";
		}

		

		

		
}
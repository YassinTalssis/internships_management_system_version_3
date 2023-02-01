package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Responsible {
	//Aissa 
		@Id
		@GeneratedValue
		private long id;
	
		@Column(length = 45 , nullable = true)
		private String firstName;
		@Column(length = 45 , nullable = true)
		private String lastName;
		@Column(length = 45 , nullable = true)
		private String email;
		@Column(length = 45 , nullable = true)
		private String password;

		
		@ManyToOne
		@JoinColumn(name = "etablissement_id")
		private Etablissement etablissementt;
		public Responsible() {
			
		}
		public Responsible(String firstName, String lastName, String email) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			//this.password = "123456789";
			//this.etablissementt = etablissementt;
		}
	
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Etablissement getEtablissementt() {
			return etablissementt;
		}

		public void setEtablissementt(Etablissement etablissementt) {
			this.etablissementt = etablissementt;
		}
		
}

 package com.example.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Stays")
public class model {
 
	     @Id
	     @GeneratedValue(strategy=GenerationType.IDENTITY)
	     private int stayid;
	     @Column(name="Password")
	     private String password;
	     private String email;
	     private String pno;
	     private int age;
		public int getStayid() {
			return stayid;
		}
		public void setStayid(int stayid) {
			this.stayid = stayid;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPno() {
			return pno;
		}
		public void setPno(String pno) {
			this.pno = pno;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
		
		
	     
}

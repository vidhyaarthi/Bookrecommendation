package com.web.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register")

public class Register  {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		int userid;
		String username;
		String password;	


		public int getUserid() {
			return userid;
		}

		public void setUserid(int userid) {
			this.userid = userid;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Register() {
			//empty constructor required by JPA
		}

		public Register(String username) {
			this.username = username;
		}

	}

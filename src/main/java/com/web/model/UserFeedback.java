package com.web.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userfeedback")
public class UserFeedback implements Serializable {

	private static final long serialVersionUID = -6640481949420444264L; 

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		int id;
		int userid;
		int bookid;
		String status;
		
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public int getUserid() {
			return userid;
		}
		
		public void setUserid(int userid) {
			this.userid = userid;
		}
		
		public int getBookid() {
			return bookid;
		}
		
		public void setBookid(int bookid) {
			this.bookid = bookid;
		}
		
		public String getStatus() {
			return status;
		}
		
		public void setStatus(String status) {
			this.status = status;
		}
		
		public UserFeedback() {
			//empty constructor required by JPA
		}
		
		public UserFeedback(int userid) {
			this.userid = userid;
		}
	}

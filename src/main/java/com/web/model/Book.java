package com.web.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book implements Serializable {

	private static final long serialVersionUID = -6640481949420444264L; 

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		int bookid;
		String booktitle;
		String author;	
		String genre;
		
		
		public int getBookid() {
			return bookid;
		}
		
		public void setBookid(int bookid) {
			this.bookid = bookid;
		}
		
		public String getBooktitle() {
			return booktitle;
		}
		
		public void setBooktitle(String booktitle) {
			this.booktitle = booktitle;
		}
		
		public String getAuthor() {
			return author;
		}
		
		public void setAuthor(String author) {
			this.author = author;
		}
		
		public String getGenre() {
			return genre;
		}
		
		public void setGenre(String genre) {
			this.genre = genre;
		}	
		
		public Book() {
			//empty constructor required by JPA
		}
		
		public Book(String booktitle) {
			this.booktitle = booktitle;
		}
	}

package com.example.demo.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(
   name = "Book_Rent"
)
@Data
public class BookRent {
	 @Id
	   @GeneratedValue(
	      strategy = GenerationType.AUTO
	   )
	   int id;
	   LocalDate issueDate;
	   LocalDate expiryDate;
	   boolean returnSatatus;
	   @ManyToOne
	   @JoinColumn(
	      name = "bookId"
	   )
	   Book bookId;
	   @ManyToOne 
	   @JoinColumn(
	      name = "userId"
	   )
	   LibraryUsers userId;

}

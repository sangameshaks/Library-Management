package com.example.demo.entity;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(
   name = "LibraryUsers"
)
@Data
public class LibraryUsers {
	 @Id
	   @GeneratedValue(
	      strategy = GenerationType.AUTO
	   )
	   int userId;
	   String userName;
	   String email;
	   String password;
	   long phoneNo;
	   int noOfBookIssued;
	   
	   @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	    private Set<BookRent> bookRents;
}

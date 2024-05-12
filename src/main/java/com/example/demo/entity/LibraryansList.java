package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(
   name = "Libraryans_List"
)
@Data
public class LibraryansList {
	@Id
	   @GeneratedValue(
	      strategy = GenerationType.IDENTITY
	   )
	   int userId;
	   String userName;
	   int password;

}

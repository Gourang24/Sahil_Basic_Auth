package com.springboot.microservices.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long userId;
private String firstName;
private String lastName;
private String city;

}
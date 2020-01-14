package com.microservice.ibmmq.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
	
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	

}

package com.spacedev.board.entity;

import java.sql.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Table(name = "itsme_contact")
public class Contact {
	
	private String name;
	
	@Id
	private String email;
	
	private String phonenumber;
	
	private String message;
	
	private Date wdate;
}

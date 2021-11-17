package com.spacedev.board.entity;

// import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "itsme_contact")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	
	private String name;
	
	private String email;
	
	@Column(name="phonenumber")
	private String phone;
	
	private String message;
	
	// private Date wdate;	// 시간은 못받음 => 날짜만 받을 때 사
	private LocalDateTime wdate;
}

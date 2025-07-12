package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Account")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long account_number;
	
	@Column(name = "account_holder_name",nullable=false,length = 500)
	private String account_holder_name;
	
	@Column(name = "account_balance")
	private Double account_balance;
	

}

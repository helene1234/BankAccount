package com.KataBankAccount.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Account {
	private Long id;
	private double balance;

	public Account(Long isAccount, double initialAmount) {
		this.id=isAccount;
		this.balance = initialAmount;
	}

}




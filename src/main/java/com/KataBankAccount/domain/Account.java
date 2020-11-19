package com.KataBankAccount.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Account {
	private Long id;
	private double balance;
	private List<Statement> history;


	public Account(Long isAccount, double initialAmount, ArrayList<Statement> history) {
			this.id=isAccount;
			this.balance = initialAmount;

			if (history != null) {
				this.history = history;
			}
			else {
				this.history = new ArrayList<Statement>();
			}
		}

	}




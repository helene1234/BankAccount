package com.KataBankAccount.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
  private TransactionType type;
  private double amount;
  private Date date;

  public Transaction(TransactionType type, Date date, double amount) {
    this.type = type;
    this.date = date;
    this.amount = amount;
  }
}


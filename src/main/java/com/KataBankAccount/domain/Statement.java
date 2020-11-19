package com.KataBankAccount.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Statement {

  private Transaction operation;
  private double currentBalance;

  public Statement(Transaction transaction, double currentBalance) {
    this.operation = transaction;
    this.currentBalance = currentBalance;
  }
}


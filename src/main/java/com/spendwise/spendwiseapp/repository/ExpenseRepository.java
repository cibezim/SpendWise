package com.spendwise.spendwiseapp.repository;


import com.spendwise.spendwiseapp.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Custom query methods if needed
}

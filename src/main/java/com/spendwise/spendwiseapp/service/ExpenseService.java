package com.spendwise.spendwiseapp.service;


import com.spendwise.spendwiseapp.dto.ExpenseDTO;
import com.spendwise.spendwiseapp.exception.ExpenseNotFoundException;
import com.spendwise.spendwiseapp.model.Expense;
import com.spendwise.spendwiseapp.repository.ExpenseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseService.class);

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<ExpenseDTO> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ExpenseDTO getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> {
            LOGGER.error("Expense with id {} not found", id);
            return new ExpenseNotFoundException("Expense not found with id: " + id);
        });
        return convertToDTO(expense);
    }

    public ExpenseDTO addExpense(ExpenseDTO expenseDTO) {
        Expense newExpense = convertToEntity(expenseDTO);
        return convertToDTO(expenseRepository.save(newExpense));
    }

    public ExpenseDTO updateExpense(Long id, ExpenseDTO updatedExpenseDTO) {
        Expense existingExpense = expenseRepository.findById(id).orElseThrow(() -> {
            LOGGER.error("Expense with id {} not found", id);
            return new ExpenseNotFoundException("Expense not found with id: " + id);
        });

        existingExpense.setDescription(updatedExpenseDTO.getDescription());
        existingExpense.setAmount(updatedExpenseDTO.getAmount());

        return convertToDTO(expenseRepository.save(existingExpense));
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
        LOGGER.info("Expense with id {} deleted successfully", id);
    }

    private ExpenseDTO convertToDTO(Expense expense) {
        return new ExpenseDTO(expense.getDescription(), expense.getAmount());
    }

    private Expense convertToEntity(ExpenseDTO expenseDTO) {
        return new Expense(expenseDTO.getDescription(), expenseDTO.getAmount());
    }
}

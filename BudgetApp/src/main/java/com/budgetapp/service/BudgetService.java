package com.budgetapp.service;

import com.budgetapp.exception.BudgetNotFoundException;
import com.budgetapp.model.Budget;

import java.util.List;

/**
 * Created by lapostol on 8/5/2014.
 */
public interface BudgetService {
    public Budget create(Budget budget);
    public Budget get(Integer id);
    public Budget get(String name);
    public List<Budget> getAll();
    public Budget update(Budget budget) throws BudgetNotFoundException;
    public Budget delete(String name) throws BudgetNotFoundException;
}

package com.budgetapp.service;

import com.budgetapp.exception.BudgetNotFoundException;
import com.budgetapp.model.Budget;
import com.budgetapp.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lapostol on 8/5/2014.
 */
@Service
@Transactional(rollbackFor = BudgetNotFoundException.class)
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    @Override
    public Budget get(String name) {
        return budgetRepository.findByName(name);
    }

    @Override
    public Budget get(Integer id) {
        return budgetRepository.findOne(id);
    }

    @Override
    public Budget create(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    public List<Budget> getAll() {
        return budgetRepository.findAll();
    }

    @Override
    public Budget update(Budget budget) throws BudgetNotFoundException {
        Budget budgetToUpdate = get(budget.getId());
        if (budgetToUpdate == null)
            throw new BudgetNotFoundException(budgetToUpdate.getId().toString());
        budgetToUpdate.update(budget);
        return budgetToUpdate;
    }

    @Override
    public Budget delete(String name) throws BudgetNotFoundException {
        Budget budgetToDelete = get(name);
        if (budgetToDelete == null)
            throw new BudgetNotFoundException(name);
        budgetRepository.delete(budgetToDelete.getId());
        return budgetToDelete;
    }
}

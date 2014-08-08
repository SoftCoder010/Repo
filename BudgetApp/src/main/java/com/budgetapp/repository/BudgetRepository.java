package com.budgetapp.repository;

import com.budgetapp.model.Budget;
import com.budgetapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by lapostol on 8/7/2014.
 */
public interface BudgetRepository extends JpaRepository<Budget, Integer> {

    @Query("Select budget from Budget budget where budget.name=:name ")
    Budget findByName(@Param("name") String name);
}

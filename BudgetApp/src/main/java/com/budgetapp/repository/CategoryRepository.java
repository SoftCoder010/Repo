package com.budgetapp.repository;

import com.budgetapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lapostol on 7/31/2014.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

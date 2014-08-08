package com.budgetapp.service;

import com.budgetapp.exception.CategoryNotFoundException;
import com.budgetapp.model.Category;

import java.util.List;

/**
 * Created by lapostol on 7/31/2014.
 */
public interface CategoryService {

    public Category create(Category category);
    public Category get(Integer id);
    public List<Category>  getAll();
    public Category update(Category category) throws CategoryNotFoundException;
    public Category delete(Integer id) throws CategoryNotFoundException;
}

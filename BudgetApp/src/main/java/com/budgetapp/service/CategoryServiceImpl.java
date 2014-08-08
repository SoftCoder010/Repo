package com.budgetapp.service;

import com.budgetapp.exception.CategoryNotFoundException;
import com.budgetapp.model.Category;
import com.budgetapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lapostol on 7/31/2014.
 */
@Service
@Transactional(rollbackFor = CategoryNotFoundException.class)
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category get(Integer id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(Category category) throws CategoryNotFoundException {
        Category categoryToUpdate = get(category.getId());
        if (categoryToUpdate == null)
            throw new CategoryNotFoundException(categoryToUpdate.getId().toString());
        categoryToUpdate.update(category);
        return  categoryToUpdate;
    }

    @Override
    public Category delete(Integer id){
        Category category = get(id);
        if (category == null)
            throw new CategoryNotFoundException(id.toString());
        categoryRepository.delete(id);
        return category;
    }
}

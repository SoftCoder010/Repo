package com.budgetapp.exception;

/**
 * Created by lapostol on 7/31/2014.
 */
public class CategoryNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -2859292084648724403L;
    public CategoryNotFoundException(String categoryId){
        super("Category with id: "+categoryId+" not found !");
    }
}

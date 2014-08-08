package com.budgetapp.exception;

/**
 * Created by lapostol on 8/5/2014.
 */
public class BudgetNotFoundException  extends RuntimeException{
    private static final long serialVersionUID = -2859292084648724403L;
    public BudgetNotFoundException(String name){
        super("Budget with name: "+name+" not found !");
    }
}

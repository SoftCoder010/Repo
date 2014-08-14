package com.budgetapp.controller;

import com.budgetapp.model.Budget;
import com.budgetapp.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by lapostol on 8/5/2014.
 */
@Controller
@RequestMapping(value="/budgets")
public class BudgetController {
    @Autowired
    private BudgetService budgetService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createBudgetPage(){
        ModelAndView mav = new ModelAndView("budgets/new-budget");
        mav.addObject("budget", new Budget());
        return mav;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Budget createBudget(@RequestBody Budget budget){
        System.out.println(budget);
        System.out.println( budgetService.create(budget));
        return budgetService.create(budget);
    }

    @RequestMapping(value="", method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public java.util.List<Budget> allBudgets() {
        return budgetService.getAll();
    }

    @RequestMapping(value="",  method=RequestMethod.GET)
    public ModelAndView viewSelectedBudget(@RequestParam(value = "budgetName", required = false) String budgetName) {
        ModelAndView mav = new ModelAndView("budgets/budgets");
        List<Budget> budgets = new ArrayList<Budget>();
        budgets.addAll(allBudgets());
        Budget selectedBudget;
        if (budgetName != null && !budgetName.isEmpty()){
            selectedBudget = budgetService.get(budgetName) ;

        } else{
            selectedBudget = new Budget();
        }

        mav.addObject("budgets", budgets);
        mav.addObject("budget", new Budget());
        mav.addObject("selectedBudget", selectedBudget);
        return mav;

    }


//    @RequestMapping(value="", method=RequestMethod.GET)
//    public ModelAndView allBudgetsPage() {
//
//        ModelAndView mav = new ModelAndView("budgets/budgets");
//        List<Budget> budgets = new ArrayList<Budget>();
//        budgets.addAll(allBudgets());
//        mav.addObject("budgets", budgets);
//        mav.addObject("budget", new Budget());
//        Budget selectedBudget = new Budget();
//        mav.addObject("selectedBudget", selectedBudget);
//        return mav;
//    }
}

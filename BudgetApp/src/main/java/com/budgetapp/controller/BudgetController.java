package com.budgetapp.controller;

import com.budgetapp.model.Budget;
import com.budgetapp.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;

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
}

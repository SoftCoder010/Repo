package com.budgetapp.controller;

import com.budgetapp.model.Category;
import com.budgetapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lapostol on 8/1/2014.
 */
@Controller
@RequestMapping(value="/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="/create", method = RequestMethod.GET)
    public ModelAndView createCategoryPage(){
        ModelAndView mav =  new ModelAndView("categories/new-category");
        mav.addObject("category", new Category());
        return mav;
    }

    @RequestMapping(value="/create", method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Category createCategory(@RequestBody Category category) {

        return categoryService.create(category);
    }
}

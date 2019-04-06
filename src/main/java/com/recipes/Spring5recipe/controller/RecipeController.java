package com.recipes.Spring5recipe.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    @RequestMapping({"","/","index.html"})
    public String getIndex(Model model){
        return "index";
    }
}

package org.sangam.springbootmvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.sangam.springbootmvc.model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController
{
    @ModelAttribute
    public void modelData(Model model){
        model.addAttribute("name", "Aliens");
    }
    @RequestMapping("/")
    public String Home(){
        System.out.println("Home Page Requested.");
        return "index";
    }

    @RequestMapping("add")
    public ModelAndView Add(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
    int num3 = num1 + num2;
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("result");
    modelAndView.addObject("num3", num3);
    return modelAndView;
    }

    @PostMapping("addAlien")
    public String Add(@ModelAttribute Alien alien){
        return "result";
    }

    @GetMapping("getAliens")
    public String getAliens(Model model){
        List<Alien> aliens = Arrays.asList(new Alien(101,"Charles"), new Alien(102,"David"));
        model.addAttribute("result", aliens);
        return "showAliens";
    }

}

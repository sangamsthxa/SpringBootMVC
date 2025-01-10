package org.sangam.springbootmvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
    @RequestMapping("/")
    public String Home(){
        System.out.println("Home Page Requested.");
        return "index.jsp";
    }

    @RequestMapping("add")
    public ModelAndView Add(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
    int num3 = num1 + num2;
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("result.jsp");
    modelAndView.addObject("num3", num3);
    return modelAndView;
    }

}

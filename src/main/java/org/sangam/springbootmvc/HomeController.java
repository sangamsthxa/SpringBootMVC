package org.sangam.springbootmvc;

import org.sangam.springbootmvc.model.Alien;
import org.sangam.springbootmvc.repository.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController
{
    @Autowired
    private AlienRepo alienRepo;
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
    public String AddAlien(@ModelAttribute Alien alien){
        alienRepo.save(alien);
        return "result";
    }

    @GetMapping("getAliens")
    public String getAliens(Model model){
        List<Alien> aliens = alienRepo.findAll();
        model.addAttribute("result", aliens);
        return "showAliens";
    }

    @GetMapping("getAlien")
    public String getAlienById(@RequestParam int id,  Model model){
        model.addAttribute("result",
                alienRepo.getOne(id));
        return "showAliens";
    }

    @GetMapping("getAlienByName")
    public String getAlienByName(@RequestParam String name,  Model model){
        model.addAttribute("result",
                alienRepo.find(name));
        return "showAliens";
    }

}

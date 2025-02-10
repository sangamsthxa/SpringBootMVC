package org.sangam.springbootmvc.controller;

import org.sangam.springbootmvc.model.Alien;
import org.sangam.springbootmvc.repository.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlienController {

    @Autowired
    private AlienRepo alienRepo;

    @GetMapping(path="aliens", produces = {"application/xml"})
    @ResponseBody
    public List<Alien> getAliens(){
        List<Alien> aliens = alienRepo.findAll();
        return aliens;
    }

    @GetMapping("alien/{aid}")
    @ResponseBody
    public Alien getAlien(@PathVariable("aid") int aid){
        Alien alien = alienRepo.findById(aid).get();
        return alien;
    }

    @PostMapping("alien")
    public Alien createAlien(Alien alien){
        alienRepo.save(alien);
        return alien;
    }


}

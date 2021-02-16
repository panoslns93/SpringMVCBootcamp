/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noslia.controller;

import java.util.List;
import javax.validation.Valid;
import noslia.entity.Trainer;
import noslia.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 *
 * @author Panos
 */
@Controller
@RequestMapping("/")
public class TrainerController {
    
     private final String editurl = "edit";
     private final String updateurl = "update";
     private String error = "I can't let you do that, " + System.getProperty("user.name");
    
    @Autowired
    private TrainerService service;
    
    @RequestMapping(value = {"/", "/trainerList"}, method = RequestMethod.GET)
    public ModelAndView showTrainers(ModelAndView modelAndView){
        List<Trainer> trainers = service.getTrainers();
        modelAndView.addObject("listOfTrainers", trainers);
        modelAndView.setViewName("trainerList");
        return modelAndView;
    }
    
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String showForm(){
        return "trainerForm";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String create(Trainer trainer, RedirectAttributes attributes){
        service.addTrainer(trainer);
        String minima = "Trainer "+ trainer.getTname() + " successfully created!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/";//Redirect instructs client to sent a new GET request to /trainer
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes attributes){
        service.deleteTrainer(id);
        String minima = "Trainer successfully deleted!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/";
    }
    
   @GetMapping("/update/{tid}")
    public String showFormUpdate(@PathVariable("tid") int tid, Model model){
        Trainer trainer = service.getTrainerById(tid);
        model.addAttribute("trainerToEdit", trainer);
        return "edittrainer";
    }
    
    @PostMapping("/update")
    public String update(Trainer trainer, RedirectAttributes attributes){
        service.updateTrainer(trainer);
        String minima = "Trainer updated successfully!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/trainerList";
    }

    
}
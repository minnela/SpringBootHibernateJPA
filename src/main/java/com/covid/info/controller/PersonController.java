package com.covid.info.controller;

import com.covid.info.domain.Person;
import com.covid.info.repository.PersonRepository;
import com.covid.info.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PersonController {
   PersonService personService;

   @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/register")
    public ModelAndView getRegisterPage(){
       return new ModelAndView("addUser", "person", new Person());
    }
    @RequestMapping(value="/register", method= RequestMethod.POST)
    public String handleRegisterForm(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) throws SQLException {
        if(bindingResult.hasErrors()){
            return "addUser";
        }
        personService.addPerson(person);

        return "redirect:/";
    }

    @RequestMapping("/patients")
    public ModelAndView getUsersPage(){
        return new ModelAndView("patients","patients",personService.getAllPatients());
    }

    @RequestMapping(value="/updateCovidInfo/{id}", method= RequestMethod.POST)
    public String updateStatus(@PathVariable("id") int id){
        personService.updatePersonCovidInfo(id);
        return "redirect:/patients";
    }

    @RequestMapping(value = "/deletePatient/{id}", method = RequestMethod.POST)
    public String handleItemDelete(@PathVariable("id") int id) {
        personService.deletePersonById(id);
        return "redirect:/patients";
    }
}

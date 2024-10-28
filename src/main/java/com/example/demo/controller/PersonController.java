package com.example.demo.controller;

import com.example.demo.entity.Job;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/list")
    public String listPerson(Model model){

        List<Person> persons = personService.getAllPersons();
        model.addAttribute("persons", persons);

        return "list-persons";
    }



    @GetMapping("/showForm")
    public String addPerson(Model model){

        Person person = new Person();

        model.addAttribute("person", person);

        return "add-person";

    }

    @GetMapping("/signUp")
    public String signUp(Model model){

        Person person = new Person();

        model.addAttribute("person", person);

        return "sign-up";

    }

    @PostMapping("/save")
    public String savePerson( @ModelAttribute("person")@Valid Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add-person";
        }else{
            personService.savePerson(person);
            return "redirect:/person/list";
        }
    }

    @GetMapping("/showFormForUpdate")
    public String updatePerson(Model model, @RequestParam("personId")long personId){
        Person person = personService.getPersonById(personId);

        model.addAttribute("person", person);

        return "add-person";
    }

    @GetMapping("/delete")
    public String deletePerson(@RequestParam("personId") long id){
        personService.deletePerson(id);
        return "redirect:/person/list";
    }


}

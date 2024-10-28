package com.example.demo.controller;

import com.example.demo.entity.Job;
import com.example.demo.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/list")
    public String listJob(Model model){

        model.addAttribute("jobs", jobService.getAllJobs());

        return "list-jobs";
    }

    @GetMapping("/save")
    public String addJob(@ModelAttribute("job") @Valid Job job, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add-job";
        }else{
            jobService.saveJob(job);
            return "redirect:/job/list";
        }
    }


}

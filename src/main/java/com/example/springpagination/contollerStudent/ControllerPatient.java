package com.example.springpagination.contollerStudent;


import com.example.springpagination.entity.Patient;
import com.example.springpagination.entity.Student;
import com.example.springpagination.repositoryStudent.RepositoryPatient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller @AllArgsConstructor
public class ControllerPatient {

    private RepositoryPatient repositoryPatient;

    @GetMapping(path = "/index2")
    public String patientView(Model model,
                              @RequestParam(name = "page",defaultValue = "0") int page,
                              @RequestParam(name = "size",defaultValue = "5") int size){
       Page<Patient> listPatient= repositoryPatient.findAll(PageRequest.of(page,size));

       model.addAttribute("listPatient",listPatient.getContent());
       model.addAttribute("pagePatient",new int[listPatient.getTotalPages()]);



        return "index2";
    }

    @GetMapping(path = "/add")
    public String add(){
        Patient p1=new Patient(null,"john doe",new Date(),true,34);
        Patient p2=new Patient(null,"jane doe",new Date(),false,55);
        Patient p3=new Patient(null,"jill doe",new Date(),true,46);
        Patient p4=new Patient(null,"jordan doe",new Date(),true,74);
        Patient p5=new Patient(null,"mike doe",new Date(),false,26);


        List<Patient> patientL= Arrays.asList(p1,p2,p3,p4,p5);
        repositoryPatient.saveAll(patientL);

        return "add";
    }
}

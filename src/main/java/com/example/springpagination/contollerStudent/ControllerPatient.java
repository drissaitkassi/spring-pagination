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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller @AllArgsConstructor
public class ControllerPatient {

    private RepositoryPatient repositoryPatient;

    @GetMapping(path = "/index2")
    public String patientView(Model model,
                              @RequestParam(name = "page",defaultValue = "0") int page,
                              @RequestParam(name = "size",defaultValue = "5") int size,
                              @RequestParam(name = "keyword",defaultValue = "") String keyword){
       Page<Patient> listPatient= repositoryPatient.findByNomContains(keyword,PageRequest.of(page,size));

       model.addAttribute("listPatient",listPatient.getContent());
       model.addAttribute("pagePatient",new int[listPatient.getTotalPages()]);
       model.addAttribute("currentpage",page);
       model.addAttribute("serchedKeyword",keyword);




        return "index2";
    }
    @GetMapping(path = "/delete")

    public String delete(Long id,int page,String keyword){

        repositoryPatient.deleteById(id);
        return "redirect:/index2?page="+page+"&keyword="+keyword;
    }

    @GetMapping(path = "/formpatient")
    public String add(){


        return "formpatient";
    }

}

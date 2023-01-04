package com.example.springpagination.contollerStudent;


import com.example.springpagination.entity.Patient;
import com.example.springpagination.entity.Student;
import com.example.springpagination.repositoryStudent.RepositoryPatient;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller @AllArgsConstructor
public class ControllerPatient {

    private RepositoryPatient repositoryPatient;

    @GetMapping(path = "/user/index2")
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
    @GetMapping(path = "/admin/delete")

    public String delete(@RequestParam(name = "id",defaultValue = "1") Long id,@RequestParam(name = "page",defaultValue = "0") int page, @RequestParam(name = "keyword",defaultValue = "") String keyword){

        repositoryPatient.deleteById(id);
        return "user/index2?page="+page+"&keyword="+keyword;
    }

    @GetMapping(path = "/")
    public String home(){
        return "index2";
    }

    @GetMapping(path = "/admin/formpatient")
    public String formPatient(Model model){
        model.addAttribute("patient",new Patient());
        return "formpatient";
    }

    @PostMapping(path = "/admin/save")
    public String save(@Valid Patient patient, BindingResult bindingResult){

        if (bindingResult.hasErrors())return "formpatient";
        repositoryPatient.save(patient);
        return "redirect:user/index2";
    }


    @GetMapping(path = "/admin/formpatientupdate")
    public String updatepat(Model model,Long id){
        Patient patient= repositoryPatient.findById(id).orElse(null);
        if (patient == null) throw new RuntimeException("patient null");
        model.addAttribute("patient",patient);
        return "formpatientupdate";
    }

}

/*
package com.example.springpagination.contollerStudent;

import com.example.springpagination.entity.Student;
import com.example.springpagination.repositoryStudent.RepositoryStudent;
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
public class ControllerStudent {

   private RepositoryStudent repositoryStudent;



    @GetMapping(path = "/index")
    public String myView(Model model, @RequestParam(name = "page",defaultValue = "0") int page,@RequestParam(name = "size",defaultValue = "5") int size){
        Page <Student> pagelistSt = repositoryStudent.findAll(PageRequest.of(page, size));

        model.addAttribute("pagelistSt",pagelistSt.getContent());
        model.addAttribute("studentPage",new int [pagelistSt.getTotalPages()]);

        return "index";
    }
 */
/*   @GetMapping(path = "/add")
    public String add(){
        Student s1=new Student(null,"driss","ait kassi","driss@gmail.com",31,new Date());
        Student s2=new Student(null,"driss","ait kassi","driss@gmail.com",31,new Date());
        Student s3=new Student(null,"driss","ait kassi","driss@gmail.com",31,new Date());
        Student s4=new Student(null,"driss","ait kassi","driss@gmail.com",31,new Date());
        Student s5=new Student(null,"driss","ait kassi","driss@gmail.com",31,new Date());
        Student s6=new Student(null,"driss","ait kassi","driss@gmail.com",31,new Date());
        Student s7=new Student(null,"driss","ait kassi","driss@gmail.com",31,new Date());
        Student s8=new Student(null,"driss","ait kassi","driss@gmail.com",31,new Date());
        Student s9=new Student(null,"driss","ait kassi","driss@gmail.com",31,new Date());
        Student s10=new Student(null,"driss","ait kassi","driss@gmail.com",31,new Date());
        Student s11=new Student(null,"driss","ait kassi","driss@gmail.com",31,new Date());
        Student s12=new Student(null,"driss","ait kassi","driss@gmail.com",31,new Date());
        Student s13=new Student(null,"driss","ait kassi","driss@gmail.com",31,new Date());
        Student s14=new Student(null,"driss","ait kassi","driss@gmail.com",31,new Date());

        List<Student> studentL= Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14);
        repositoryStudent.saveAll(studentL);
        return "add";
    }*//*

}
*/

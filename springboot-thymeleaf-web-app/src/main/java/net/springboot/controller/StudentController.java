package net.springboot.controller;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import net.springboot.model.Student;
import net.springboot.services.studentService;

@Controller
public class StudentController {	
	
	@Autowired
	private studentService studentService;	
	
	@GetMapping("/")
	public String showStudent(Model model) throws Exception {
		model.addAttribute("students",studentService.findAll());
		return "index";
	}
	
	@GetMapping("showForm")
	public String showStudentForm(Student student) {
		return "add-student";
	}

	
	@PostMapping("add")
	public String addtest(Student test,Model model) throws Exception
	{
		studentService.createOrUpdateTest(test);
		model.addAttribute("students",studentService.findAll());
		return "index";
	}
	
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable ("id") int id, Model model) throws RelationNotFoundException {
		Student studentdata =studentService.gettest1ById(id);
		model.addAttribute("student", studentdata);
		return "update-student";
	}
	
	@PostMapping("update/{id}")
	public String updateStudent(Student student, Model model) throws Exception {
		
		// update student
		studentService.updateStudent(student);
		
		// get all students ( with update)
		model.addAttribute("students",studentService.findAll());
		return "index";
	}
	
	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable ("id") int id, Model model) throws Exception {
		
		studentService.deltest1ById(id);
		model.addAttribute("students", studentService.findAll());
		return "index";
		
	}
}

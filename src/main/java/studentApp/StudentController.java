package studentApp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {	
	private List<Student> students;
	
	@PostConstruct
	public void loadStudentData()
	{
		students=new ArrayList<Student>();
		students.add(new Student("Sonam","Gadekari"));
		students.add(new Student("Suman","Gadekari"));
		students.add(new Student("Rohith","Gadekari"));		
	}
	@GetMapping("/students")
	public List<Student> getStudents()
	{			
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudents(@PathVariable int studentId)
	{				
		return students.get(studentId);
	}
}

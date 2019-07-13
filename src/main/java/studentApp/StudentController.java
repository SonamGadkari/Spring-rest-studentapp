package studentApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

	@GetMapping("/students")
	public List<Student> getStudents()
	{
		List<Student> students=new ArrayList<Student>();
		students.add(new Student("Sonam","Gadekari"));
		students.add(new Student("Suman","Gadekari"));
		students.add(new Student("Rohith","Gadekari"));				
		return students;
	}
	
}

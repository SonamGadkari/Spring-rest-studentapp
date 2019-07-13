package studentApp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		if(studentId< 0  || studentId > students.size()) {
			throw new StudentNotFoundException("Student id not found"+studentId);
		}
		return students.get(studentId);
	} 
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
	{
		//create a StudentErrorResponse
		StudentErrorResponse error=new StudentErrorResponse();
		//error.setStatus(404); instead of direct status code use http status codes
		error.setStatus(HttpStatus.NOT_FOUND.value());		
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		//return Response
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
}

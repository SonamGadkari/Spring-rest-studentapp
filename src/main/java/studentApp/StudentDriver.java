package studentApp;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentDriver {

	ObjectMapper mapper=new ObjectMapper();
	Student student=mapper.readValue(new File("src/data"), Student.class);
	
	mapper.write(new )
}
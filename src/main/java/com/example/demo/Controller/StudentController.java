package com.example.demo.Controller;


import java.util.List;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Entity.Student;
import com.example.demo.Response.StudentResponse;
import com.example.demo.Service.StudentService;
import com.example.demo.StudentRepostitory.StudentRepository;

@RestController
 
@RequestMapping("/api/student/")
public class StudentController 
{
	 @Autowired
      StudentRepository repo;	 
	@Autowired
	StudentService ss;
	@Autowired
	Student w;
	 
	 
	private static final Logger logf = LoggerFactory.getLogger(StudentController.class);

	@GetMapping("/getAll") 
	public List<Student> getstudent()
	{
		 
	     List<Student> ss=repo.findAll();
	     return ss;
	}
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<Student> updateBook(@PathVariable(value="id")int id,@RequestBody StudentResponse w1 )
	{ 
		
	Student hh=  repo.findById(id).get();
    hh.setTarget_date(w1.getTarget_date());
	hh.setDescription(w1.getDescription());
	hh.setisdone( w1.getMsg());
	repo.save(hh);                       
	return new ResponseEntity<Student>((Student) hh,HttpStatus.OK);
	 
	}
	@GetMapping("/addTodo")
	public ResponseEntity<StudentResponse> addBookImplementation(@RequestBody Student Student)
	{
		StudentResponse ad=new StudentResponse();
		if(ss.checkBookAlreayExist(Student.getId()))
		{
		 logf.info("Book does not exist creating one");
		System.out.println(Student.getDescription());
		w.setId(Student.getId());
		w.setTarget_date(Student.getTarget_date());
		w.setDescription(Student.getDescription());
        w.setTarget_date(Student.getTarget_date());
        w.setisdone( Student.getisdone());
		repo.save(w);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Unique",Integer.toString(Student.getId()));
		
		ad.setMsg("Successfully Added");
		ad.setId(Student.getId());
		ad.setDate(Student.getisdone());
		ad.setDescription(Student.getDescription());
		ad.setTarget_date(Student.getTarget_date());
		
		return new ResponseEntity<StudentResponse>(ad,headers,HttpStatus.CREATED);
		}
		else
		{
			logf.info("TODO was Existing so skipping this one");
		 
			ad.setMsg("Todo Already Present");
			return new ResponseEntity<StudentResponse>(ad,HttpStatus.ACCEPTED);
		}
		
		}
	@DeleteMapping("/deleteTodo")
	public ResponseEntity<String> deleteBookbyid(@RequestBody Student library)
	{ 
		if(!ss.checkBookAlreayExist(library.getId()))
		{
		logf.info("TODO was Existing so skipping this one");
		repo.deleteById(library.getId()); 
		return new ResponseEntity<>("Book deleted",HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<>("Book Not Exist",HttpStatus.CREATED);
		
	}

}

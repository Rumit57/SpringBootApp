package net.springboot.services;

import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.springboot.model.Student;
import net.springboot.repository.StudentRepository;

@Service
public class studentServiceImpl implements studentService{

	@Autowired
	private StudentRepository repo;
	
	@Override
	public List<Student> findAll() throws Exception {
		List<Student> test= repo.findAll();
        if(test.isEmpty()) {
        	throw new Exception("No test record found");   
        }
        else
        {
        	return test;
        }
	}

	@Override
	public Student gettest1ById(int id) throws RelationNotFoundException {
		Optional<Student> test = repo.findById(id);
        if(test.isPresent()) {
            return test.get();
        } else {
            throw new RelationNotFoundException("No test record exist for given id");
        }
	}

	@Override
	public void deltest1ById(int id) throws RelationNotFoundException {
		Optional<Student> test = repo.findById(id);
        if(test.isPresent()) 
        {
            repo.deleteById(id);
        } else {
            throw new RelationNotFoundException("No test record exist for given id");
        }
		
	}

	@Override
	public Student createOrUpdateTest(Student test) {
		Optional<Student> test2 = repo.findById(test.getId());
		if(test2.isPresent()) 
        {
			Student newtest = test2.get();
			newtest.setName(test.getName());
			newtest.setEmail(test.getEmail());
			newtest.setPhoneNo(test.getPhoneNo());
			newtest = repo.save(newtest);
            return newtest;
        } else {
        	test = repo.save(test);
            return test;
        }
	}

	@Override
	public Student updateStudent(Student student) {
		Student student1 = repo.save(student);
        return student1;
	}

}

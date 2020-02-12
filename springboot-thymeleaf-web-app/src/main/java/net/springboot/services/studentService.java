package net.springboot.services;

import java.util.List;
import javax.management.relation.RelationNotFoundException;
import net.springboot.model.Student;

public interface studentService {

	//view all
		public List<Student> findAll() throws Exception;
		//view single record
		public Student gettest1ById(int id) throws RelationNotFoundException;
		//view update record
		public Student updateStudent(Student test);
		//delete record
		public void deltest1ById(int id) throws RelationNotFoundException;
		//insert or update record
		public Student createOrUpdateTest(Student test);
}

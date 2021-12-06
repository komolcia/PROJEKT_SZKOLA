package net.javaguides.springboot.service;

import java.util.List;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService{

	List<Student> lista= new ArrayList<>();
	public long id=0;
	@Override
	public List<Student> getAllStudents() {
		return lista;
	}
	@Override
	public Student addStudent(Student student) {
		id++;
		Student studentToAdd = new Student(id, student.getFirstName(), student.getLastName(),student.getEmail(),student.getDegree());
		lista.add(studentToAdd);
		return studentToAdd;
	}
	@Override
	public Student getStudentById(long id){
		Student lookingfor=new Student();
		for(Student student : lista)
			if(student.getId()==id)
				lookingfor=student;
		return lookingfor;
	}
	@Override
	public void deleteStudent(long id){
		Student lookingfor=new Student();
		for(Student student : lista)
			if(student.getId()==id)
				lookingfor=student;
		lista.remove(lookingfor);
	}
	@Override
	public void updateStudent(Student student){
		int index=0;
		int temp=0;
		for(Student student1 : lista) {

			if (student1.getId() == student.getId()){
				index = temp;
			}
			temp++;
		}
		Student studentToAdd = new Student(student.getId(), student.getFirstName(), student.getLastName(),student.getEmail(),student.getDegree());
		lista.set(index,studentToAdd);
	}
}

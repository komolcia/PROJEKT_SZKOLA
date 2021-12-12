package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService{
	public StudentRepository studentRepository;

	List<Student> lista= new ArrayList<>();
	public long id=0;
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository){
		this.studentRepository=studentRepository;
	}
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	@Override
	public Student addStudent(Student student) {

		return studentRepository.save(student);
	}
	@Override
	public Student getStudentById(long id){
		return studentRepository.getOne(id);
	}
	@Override
	public void deleteStudent(long id){
		studentRepository.deleteById(id);
	}
	@Override
	public void updateStudent(Student student){
		studentRepository.save(student);
	}
}

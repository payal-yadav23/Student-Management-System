package com.service;

import java.util.List;

import com.dao.StudentDao;
import com.model.Student;

public class StudentService {

	StudentDao dao = new StudentDao();

	public void AddStudent(Student student) {
		dao.AddStudent(student);
	}

	public List<Student> AllRecord() {
		return dao.AllRecord();
	}

	public void UpdateStudent(Student student) {
		dao.UpdateStudent(student);

	}

	public void DeleteStudent(int studId) {
		dao.DeleteStudent(studId);

	}

}

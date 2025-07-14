package com.controller;

import java.util.List;
import java.util.Scanner;

import com.model.Student;
import com.service.StudentService;

public class StudentController {

	public static final Scanner sc = new Scanner(System.in);
	public static final StudentService ss = new StudentService();

	public static void main(String[] args) {

		System.out.println("----Welcome Student Management System----");
		System.out.println();
		System.out.println("Enter your choice:");
		System.out.println("1.Insert new record--");
		System.out.println("2.Read all records--");
		System.out.println("3.Update any record--");
		System.out.println("4.Delete any record--");
		System.out.println("5.Exit");

		int ch = sc.nextInt();

		switch (ch) {

		case 1:
			System.out.println("Enter studId: ");
			int studId = sc.nextInt();
			System.out.println("Enter firstName: ");
			String firstName = sc.next();
			System.out.println("Enter lastName: ");
			String lastName = sc.next();
			System.out.println("Enter dob: ");
			String dob = sc.next();
			System.out.println("Enter gender: ");
			String gender = sc.next();
			System.out.println("Enter email: ");
			String email = sc.next();
			System.out.println("Enter mobNo: ");
			String mobNo = sc.next();
			System.out.println("Enter course: ");
			String course = sc.next();
			System.out.println("Enter enrollDate: ");
			String enrollDate = sc.next();

			ss.AddStudent(new Student(studId, firstName, lastName, dob, gender, email, mobNo, course, enrollDate));
			System.out.println("Record Added..!!");
			break;

		case 2:
			List<Student> students = ss.AllRecord();
			if (students.isEmpty()) {
				System.out.println("No student records found.");
			} else {
				students.forEach(System.out::println);
			}
			break;

		case 3:
			System.out.println("You can only Update MAIL and MOBNO");
			System.out.println("Enter studId which you want to update: ");
			int studId1 = sc.nextInt();
			System.out.println("Enter email:");
			String email1 = sc.next();
			System.out.println("Enter mobNo:");
			String mobNo1 = sc.next();

			ss.UpdateStudent(new Student(studId1, null, null, null, null, email1, mobNo1, null, null));
			break;

		case 4:
			System.out.println("Enter StudentId which you want to delete: ");
			int studId2 = sc.nextInt();
			ss.DeleteStudent(studId2);
			break;
		case 5:
			System.out.println("THANK YOU !!!!");
			break;
		default:
			System.out.println("Invalid Choice.. TRY AGAIN !");
		}
		sc.close();

	}

}

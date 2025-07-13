package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connect.DBConnection;
import com.model.Student;

public class StudentDao {

	public void AddStudent(Student student) {

		Connection c = DBConnection.getConnection();

		try {
			PreparedStatement ps = c.prepareStatement(
					"Insert into student(studId, firstName, lastName, dob, gender, email, mobNo, course, enrollDate) values (?,?,?,?,?,?,?,?,?)");

			ps.setInt(1, student.getStudId());
			ps.setString(2, student.getFirstName());
			ps.setString(3, student.getLastName());
			ps.setString(4, student.getDob());
			ps.setString(5, student.getGender());
			ps.setString(6, student.getEmail());
			ps.setString(7, student.getMobNo());
			ps.setString(8, student.getCourse());
			ps.setString(9, student.getEnrollDate());

			ps.close();
			c.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public List<Student> AllRecord() {

		List<Student> list = new ArrayList<>();

		try {
			Connection c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM student");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Student(rs.getInt("studId"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("dob"), rs.getString("gender"), rs.getString("email"), rs.getString("mobNo"),
						rs.getString("course"), rs.getString("enrollDate")));

			}

		} catch (Exception e) {

		}
		return list;

	}

	public void UpdateStudent(Student student) {
		Connection c = DBConnection.getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("UPDATE Student SET email=? , mobNo = ? WHERE StudID = ?");
			ps.setString(1, student.getEmail());
			ps.setString(2, student.getMobNo());
			ps.setInt(3, student.getStudId());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Student updated successfully.");
			} else {
				System.out.println("No student found with ID: " + student.getStudId());
			}

			ps.close();
			c.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void DeleteStudent(int studId) {
		Connection c = DBConnection.getConnection();

		PreparedStatement ps;
		try {
			ps = c.prepareStatement("Delete from Student WHERE studId = ?");
			ps.setInt(1, studId);
			ps.executeUpdate();

			ps.close();
			c.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}

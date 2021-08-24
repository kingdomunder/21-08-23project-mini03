package model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import model.domain.Student;
import util.PublicCommon;

public class StudentDAO {
	public static StudentDAO instance = new StudentDAO();

	public StudentDAO() {
	}

	public static StudentDAO getInstance() {
		return instance;
	}

	/** 모든 수강생 검색 */
	public List<Student> getAllStudent() throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		List<Student> allStudentList = null;

		try {
			allStudentList = em.createNamedQuery("Student.findStudentAll").getResultList();
		} catch (Exception e) {
		} finally {
			em.close();
			em = null;
		}
		return allStudentList;
	}

	/** 수강생 하나 검색 - 스터디ID로 */
	public Student getOneStudent(int studentId) {
		EntityManager em = PublicCommon.getEntityManager();
		Student student = null;
		try {
			student = (Student) em.createNamedQuery("Student.findBystudentId").setParameter("studentId", studentId).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}	
		return student;
	}

		
}

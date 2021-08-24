package controller;

import java.sql.SQLException;

import service.Service;
import view.EndView;

public class Controller {
	private static Controller instance = new Controller();
	private static Service service = Service.getInstance();
			
	public Controller() {}
	public static Controller getInstance() {
		return instance;
	}
	
	
	/** 모든 수강생 검색 */
//	public static void getAllStudent() {		
//		try {
//			EndView.showAllList(service.getAllStudents());
//		} catch (SQLException e) {
//			e.printStackTrace();
//			EndView.showError("잘못된 정보를 입력하셨습니다");
//		} catch (NullPointerException e) {
//			e.printStackTrace();
//			EndView.showError("잘못된 정보를 입력하셨습니다");
//		}
//	}

	/** 수강생 하나 검색 */
//	public void getOneStudent(int searchNo, Object student) {
//		try {
//			EndView.showOne(service.getOneStudents(searchNo, student));
//		} catch (SQLException e) {
//			e.printStackTrace();
//			EndView.showError("잘못된 정보를 입력하셨습니다");
//		} catch (NullPointerException e) {
//			e.printStackTrace();
//			EndView.showError("잘못된 정보를 입력하셨습니다");
//		}
//	}
	

	
	/** 모든 스터디 검색 */	
	public void getAllStudy() {		
		try {
			EndView.showAllStudy(service.getAllStudy());
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		} catch (NullPointerException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		}
  }
	
	/** 스터디 id로 스터디 검색 
	 * @param id */	
	public void getStudyById(int id) {
		try {
			EndView.showOneStudy(service.getStudyById(id));
		}catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		} catch (NullPointerException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		}
		
	}
	
	/** 스터디 주제로 스터디 검색 */
	public void getStudyByTopic(String keyword) {
		try {
			EndView.showAllStudy(service.getStudyByTopic(keyword));
		}catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		} catch (NullPointerException e) {
			e.printStackTrace();
			EndView.showError("잘못된 정보를 입력하셨습니다");
		}
		
	}
	
	/** 스터디 추가 */
	public void addStudy(String studyName, String topic, int studentId, String meetingDate) {
		try {
			service.addStudy(studyName, topic, studentId, meetingDate);
			EndView.showMessage("스터디 저장에 성공했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("스터디 저장에 실패했습니다.");
		} catch (NullPointerException e) {
			EndView.showError("스터디 저장에 실패했습니다.");
		}
		
	}	
	
}

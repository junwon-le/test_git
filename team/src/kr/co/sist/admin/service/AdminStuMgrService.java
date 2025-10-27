package kr.co.sist.admin.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.admin.dao.AdminStuMgrDAO;
import kr.co.sist.admin.dto.StudentDTO;

public class AdminStuMgrService {

	public List<StudentDTO> searchAllStudent() {
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		AdminStuMgrDAO aDAO = AdminStuMgrDAO.getInstance();

		
		try {
			list=aDAO.selectAllStudent();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return list;
	}//searchAllStudent
	
	
	public StudentDTO searchStudent(int stuNum) {
		StudentDTO sDTO = null;
		
		AdminStuMgrDAO aDAO = AdminStuMgrDAO.getInstance();
		try {
			
			sDTO=aDAO.selectStudent(stuNum);
			
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return sDTO;
		
	}//searchStudent
	
	public int removeStudent(int stunum) {
		int flag = 0;
		
		AdminStuMgrDAO aDAO = AdminStuMgrDAO.getInstance();
		try {
			flag=aDAO.deleteStudent(stunum);//변경한 수의 개수 
		} catch (SQLException e) {
			flag=2;
			e.printStackTrace();
		} catch (IOException e) {
			flag=2;
			e.printStackTrace();
		}//end catch
	
		return flag;
	}//removeStudent 
}//class

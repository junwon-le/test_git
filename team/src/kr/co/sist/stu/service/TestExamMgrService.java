package kr.co.sist.stu.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.admin.dto.examItemDTO;
import kr.co.sist.stu.dao.StuExamDAO;

public class TestExamMgrService {

	public List<examItemDTO> searchExamItem(int subCode, int courseCode){
		StuExamDAO seDAO = StuExamDAO.getinstance();
		List<examItemDTO> list = new ArrayList<examItemDTO>();
		
		try {
			list =seDAO.selectExamItem(101, 1000);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}

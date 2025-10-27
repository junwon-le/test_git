package kr.co.sist.stu.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.admin.dto.examItemDTO;
import kr.co.sist.login.dao.GetConnection;

public class StuExamDAO {
	static StuExamDAO srDAO;
	
	private StuExamDAO() {
	}
	
	public static StuExamDAO getinstance() {
		if(srDAO == null) {
			srDAO = new StuExamDAO();
		}
		return srDAO;
	}//getinstance
	
	
	public List<examItemDTO> selectExamItem(int subCode, int courseCode) throws IOException, SQLException {
		List<examItemDTO> list = new ArrayList<examItemDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null ;
		
		GetConnection gc = GetConnection.getInstance();
		
		try {
			con = gc.getConn();
			String selectExamItem = " select * from exam_item where test_code = (select test_code from exam where sub_code = ? and course_code = ?)";
			pstmt = con.prepareStatement(selectExamItem);
			
			pstmt.setInt(1, subCode);
			pstmt.setInt(2, courseCode);
			
			rs = pstmt.executeQuery();
			
			examItemDTO eiDTO = null;
			int examCode =0;
			int examCorrectTChoice =0;
			String examInputdate = "";
			String examChoice1 = "";
			String examChoice2 = "";
			String examChoice3 = "";
			String examChoice4 = "";
			String examQuest = "";
			int testCode =0;

			
			while(rs.next()) {
				examCode =  rs.getInt("exam_code");
				examCorrectTChoice= rs.getInt("exam_correct_tchoice");
				examInputdate = rs.getString("exam_inputdate");
				examChoice1 = rs.getString("exam_choice1");
				examChoice2= rs.getString("exam_choice2");
				examChoice3 = rs.getString("exam_choice3");
				examChoice4 =  rs.getString("exam_choice4");
				examQuest = rs.getString("exam_quest");
				testCode = rs.getInt("test_code");
				
				eiDTO = new examItemDTO(examCode, testCode, examCorrectTChoice, examChoice1, examChoice2, examChoice3, examChoice4, examInputdate, examQuest);
				
				list.add(eiDTO);
			}//end while
				
		}finally {
			gc.dbClose(con, pstmt, rs);
		}//end finally
		
		
		return list;
	}//searchExamItem
}//class

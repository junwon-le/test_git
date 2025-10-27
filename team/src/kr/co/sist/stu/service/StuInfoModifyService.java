package kr.co.sist.stu.service;

import java.io.IOException;
import java.sql.SQLException;

import kr.co.sist.login.dao.CurrentStuData;
import kr.co.sist.stu.dao.StuInfoModifyDAO;

public class StuInfoModifyService {

	
	
	public StuInfoModifyService() {
		
	}
	
	public int modifyStuInfo(CurrentStuData csd) {
		
		int flag=0;
		
		try {
			StuInfoModifyDAO simDAO = StuInfoModifyDAO.getInstance();
			flag=simDAO.updateStuInfo(csd);
			//DB테이블에 회원번호가 PK가 아니라면 flag가 n개가 반환될 수 있고
			//그 경우에는 1로 재설정한다.
		}catch(IOException ie){
			ie.printStackTrace();
		} catch (SQLException e) {
			flag=2;
			e.printStackTrace();
		}//catch
				
		return flag;
	}//modifyMember
	
	
	
	public int modifyStuImg(CurrentStuData csd) {
		
		int flag=0;
		
		try {
			StuInfoModifyDAO simDAO = StuInfoModifyDAO.getInstance();
			flag=simDAO.updateStuImg(csd);
			//DB테이블에 회원번호가 PK가 아니라면 flag가 n개가 반환될 수 있고
			//그 경우에는 1로 재설정한다.
		}catch(IOException ie){
			ie.printStackTrace();
		} catch (SQLException e) {
			flag=2;
			e.printStackTrace();
		}//catch
				
		return flag;
	}//modifyMember
	
}

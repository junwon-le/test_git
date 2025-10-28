package kr.co.sist.stu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

import kr.co.sist.admin.dto.examItemDTO;
import kr.co.sist.stu.service.TestExamMgrService;
import kr.co.sist.stu.view.StuExamDesign;

public class StuExamDesignEvt extends WindowAdapter implements ActionListener {
	
	private StuExamDesign sed;
	
	public StuExamDesignEvt(StuExamDesign sed) {
		this.sed = sed;
		searchExItemProcess();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sed.getJbtnSubmit()) {
			submitExamProcess();
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		sed.dispose();
	}
	
	public void searchExItemProcess() {
		TestExamMgrService tems = new TestExamMgrService();
		List<examItemDTO> list = tems.searchExamItem(101, 1000);
		for(int i =0 ; i< 5; i++) {
		 	sed.getJlblExamQuest()[i].setText(list.get(i).getExamQuest());
		 	sed.getOp1()[i].setText(list.get(i).getExamChoice1());
		 	sed.getOp2()[i].setText(list.get(i).getExamChoice2());
		 	sed.getOp3()[i].setText(list.get(i).getExamChoice3());
		 	sed.getOp4()[i].setText(list.get(i).getExamChoice4());
		}
	}
	
	public void submitExamProcess() {
		//		시험 제출 기능 구현 필요
		String ex1 = sed.getGbSelectButton().get(0).getSelection().getActionCommand();
		String ex2 = sed.getGbSelectButton().get(1).getSelection().getActionCommand();
		String ex3 = sed.getGbSelectButton().get(2).getSelection().getActionCommand();
		String ex4 = sed.getGbSelectButton().get(3).getSelection().getActionCommand();
		String ex5 = sed.getGbSelectButton().get(4).getSelection().getActionCommand();
		
		
	}
	

}

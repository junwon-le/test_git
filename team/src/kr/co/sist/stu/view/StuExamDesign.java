package kr.co.sist.stu.view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import kr.co.sist.login.dao.CurrentStuData;
import kr.co.sist.stu.controller.StuExamDesignEvt;

public class StuExamDesign extends JDialog{
	
	
	private JLabel jlblStuName,jlblSub;
	private JLabel jlblStuNameData, jlblSubData;
	private JLabel[] jlblExamNum, jlblExamQuest;
	
	private JRadioButton[] op1,op2,op3,op4;
	private List<ButtonGroup> gbSelectButton;
	
	private JButton jbtnSubmit;
	private StuCourseMgrDesign scmd;
	
	
	public StuExamDesign(StuCourseMgrDesign scmd, boolean modal) {
		super(scmd, "시험지", modal);
		
		JPanel jpcenterMain= new JPanel();		
		JPanel jpNorth = new JPanel();
		gbSelectButton = new ArrayList<ButtonGroup>();
		
		CurrentStuData csd = CurrentStuData.getInstance();
		String stuName = csd.getLogStuDTO().getStuName();
		
		jpcenterMain.setLayout(new BoxLayout(jpcenterMain,BoxLayout.Y_AXIS ));
		jpcenterMain.setPreferredSize(new Dimension(600, 1500));
		jlblStuName= new JLabel("이름 : ");
		jlblSub= new JLabel("과목 : ");
		jlblStuNameData = new JLabel(stuName);
		jlblSubData= new JLabel("JAVA");
		
		jbtnSubmit= new JButton("제출");
		
		jlblExamQuest = new JLabel[5];
		op1 = new JRadioButton[5];
		op2 = new JRadioButton[5];
		op3 = new JRadioButton[5];
		op4 = new JRadioButton[5];
		
		for(int i =0; i<=4;i++) {
			JPanel jpcenterSub= new JPanel();
			jpcenterSub.setLayout(new BoxLayout(jpcenterSub,BoxLayout.Y_AXIS ));
			jpcenterSub.setPreferredSize(new Dimension(300, 60));
			
			jlblExamQuest[i] = new JLabel();
			op1[i] = new JRadioButton("1");
			op2[i] = new JRadioButton("2");
			op3[i] = new JRadioButton("3");
			op4[i] = new JRadioButton("4");
			
			ButtonGroup bg = new ButtonGroup();
			bg.add(op1[i]);
			bg.add(op2[i]);
			bg.add(op3[i]);
			bg.add(op4[i]);
			
			gbSelectButton.add(bg);
			
			jpcenterSub.add(jlblExamQuest[i]);
			jpcenterSub.add(op1[i]);
			jpcenterSub.add(op2[i]);
			jpcenterSub.add(op3[i]);
			jpcenterSub.add(op4[i]);
			
			jpcenterMain.add(jpcenterSub);
			
		}//end for 
		
		jpcenterMain.add(jbtnSubmit);
//		jbtnSubmit.addActionListener(this);
		
		JScrollPane jsp = new JScrollPane(jpcenterMain);
		jsp.setAutoscrolls(true);
		

		jpNorth.add(jlblStuName);
		jpNorth.add(jlblStuNameData);
		jpNorth.add(jlblSub);
		jpNorth.add(jlblSubData);
		
		add("North",jpNorth);
		add("Center",jsp);
		
		StuExamDesignEvt sede = new StuExamDesignEvt(this);
		jbtnSubmit.addActionListener(sede);
		addWindowListener(sede);
		
		setBounds(scmd.getX()+50, scmd.getY()+50, 600, 300);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}//StuExamDesign


	public JButton getJbtnSubmit() {
		return jbtnSubmit;
	}


	public JLabel getJlblStuName() {
		return jlblStuName;
	}


	public JLabel getJlblSub() {
		return jlblSub;
	}


	public JLabel getJlblStuNameData() {
		return jlblStuNameData;
	}


	public JLabel getJlblSubData() {
		return jlblSubData;
	}


	public JLabel[] getJlblExamNum() {
		return jlblExamNum;
	}


	public JLabel[] getJlblExamQuest() {
		return jlblExamQuest;
	}


	public JRadioButton[] getOp1() {
		return op1;
	}


	public JRadioButton[] getOp2() {
		return op2;
	}


	public JRadioButton[] getOp3() {
		return op3;
	}


	public JRadioButton[] getOp4() {
		return op4;
	}


	public List<ButtonGroup> getGbSelectButton() {
		return gbSelectButton;
	}


	public StuCourseMgrDesign getScmd() {
		return scmd;
	}



	
}


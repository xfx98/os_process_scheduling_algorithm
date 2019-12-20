package me.xfx98.show;

import java.awt.Container;
import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.JFrame;

import me.xfx98.main.Main;
import me.xfx98.main.Process;

public class ShowProcess extends JFrame {
	private static final long serialVersionUID = 1L;

	public ShowProcess() {
		this.setTitle("�������н���");
		Container con = getContentPane();
		String s = "����˳���\t���̿�ʼʱ��\t���̷���ʱ��\n";
		ArrayList<Process> al = Main.getProcesses();
		for(int i = 0;i<al.size() ;i++) {
			s+="\t"+i+"\t\t"+al.get(i).getBeginTime()+"\t\t"+al.get(i).getServiceTime()+"\n";
		}
		TextArea ta= new TextArea(s,10,40,TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta.setEditable(false);
		con.add(ta);
		setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}

package me.xfx98.show;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import me.xfx98.main.BreakPoint;
import me.xfx98.main.Main;
import me.xfx98.main.Process;

public abstract class AbstractShow extends JFrame {
	private static final long serialVersionUID = 1L;
	public JLabel[] processes;
	public JPanel west, center, east, south, north;
	public Container con;
	public Button before, after;
	public JTextField time;
	public int nowTime;
	public ArrayList<Process> al;
	public ArrayList<BreakPoint> bps;

	public void init() {
		al = Main.getProcesses();
		bps = new ArrayList<>();
		con = getContentPane();
		con.setLayout(new BorderLayout());
		west = new JPanel();
		west.setLayout(new GridLayout(al.size() * 2, 1));

		center = new JPanel();
		center.setLayout(new GridLayout(al.size() * 2, 1));

		east = new JPanel();
		east.setLayout(new GridLayout(al.size() * 2, 1));

		south = new JPanel();

		north = new JPanel();

		Collections.sort(al);
		processes = new JLabel[al.size()];
		for (int i = 0; i < processes.length; i++) {
			String s = "�߳�" + i + ".��ʼʱ�䣺" + al.get(i).getBeginTime() + ";����ʱ�䣺" + al.get(i).getServiceTime() + ";";
			al.get(i).setText(s);
		}

		south.setLayout(new GridLayout(1, 3));
		before = new Button("��ǰ");
		time = new JTextField("1");
		after = new Button("���");
		south.add(before);
		south.add(time);
		south.add(after);
		before.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					nowTime -= Integer.parseInt(time.getText());
					nowTime = Math.max(0, nowTime);
				} catch (Exception e2) {
					throw new RuntimeException("��������", e2);
				}
				Show(nowTime);
			}
		});
		after.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					nowTime += Integer.parseInt(time.getText());
					nowTime = Math.min(bps.size(), nowTime);
				} catch (Exception e2) {
					throw new RuntimeException("��������", e2);
				}
				if (nowTime == bps.size()) {
					west.removeAll();
					east.removeAll();
					center.removeAll();
					north.removeAll();
					west.add(new JLabel("                    �����                    "));
					for (int i = 0; i < al.size(); i++) {
						JLabel jl = new JLabel(al.get(i).getText());
						jl.setOpaque(true);
						jl.setBackground(new Color(0, 255, 0, 120));
						west.add(jl);
					}
					center.add(new JLabel("����ִ����"));
					JLabel jl = new JLabel("Ŀǰʱ�䣺" + nowTime + "������ȫ��ִ���꣡��");
					jl.setOpaque(true);
					jl.setBackground(new Color(0,255,255,120));
					north.add(jl);
					con.removeAll();
					con.add(west, BorderLayout.WEST);
					con.add(center, BorderLayout.CENTER);
					con.add(east, BorderLayout.EAST);
					con.add(south, BorderLayout.SOUTH);
					con.add(north, BorderLayout.NORTH);
					validate();
				} else {
					Show(nowTime);
				}
			}
		});
		con.add(west, BorderLayout.WEST);
		con.add(center, BorderLayout.CENTER);
		con.add(east, BorderLayout.EAST);
		con.add(south, BorderLayout.SOUTH);
		con.add(north, BorderLayout.NORTH);
		this.setSize(600, 800);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public void Show(int time) {
		BreakPoint bp = bps.get(time);
		west.removeAll();
		east.removeAll();
		center.removeAll();
		north.removeAll();
		west.add(new JLabel("                    �����                    "));
		for (int i = 0; i < bp.exedp.size(); i++) {
			JLabel jl = new JLabel(bp.exedp.get(i).getText());
			jl.setOpaque(true);
			jl.setBackground(new Color(0, 255, 0, 120));
			west.add(jl);
		}
		center.add(new JLabel("����ִ����"));
		for (int i = 0; i < bp.exp.size(); i++) {

			JLabel jl = new JLabel(bp.exp.get(i).getText());
			if (bp.exp.get(i).getServiceTime() != 0) {
				jl.setOpaque(true);
				jl.setBackground(new Color(0, 0, 255, 120));
			}
			center.add(jl);
		}
		east.add(new JLabel("��δ����ʼʱ��"));
		for (int i = 0; i < bp.nap.size(); i++) {
			JLabel jl = new JLabel(bp.nap.get(i).getText());
			jl.setOpaque(true);
			jl.setBackground(new Color(255, 0, 0, 120));
			east.add(jl);
		}
		if (bp.now != null) {
			JLabel jl = new JLabel("Ŀǰʱ�䣺" + time + ";\n����ִ�У�" + bp.now.getText() + "\n�Ѿ�ִ���� ��" + bp.exTime + "�� ʱ�䡣");
			jl.setOpaque(true);
			jl.setBackground(new Color(0, 255, 255, 120));
			north.add(jl);
		} else {
			JLabel jl = new JLabel("Ŀǰʱ�䣺" + time + ";û�н�����ִ�У���");
			jl.setOpaque(true);
			jl.setBackground(new Color(0, 255, 255, 120));
			north.add(jl);
		}
		con.removeAll();
		con.add(west, BorderLayout.WEST);
		con.add(center, BorderLayout.CENTER);
		con.add(east, BorderLayout.EAST);
		con.add(south, BorderLayout.SOUTH);
		con.add(north, BorderLayout.NORTH);
		this.validate();
	}

	public abstract void setShow();

}

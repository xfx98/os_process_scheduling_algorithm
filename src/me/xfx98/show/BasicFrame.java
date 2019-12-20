package me.xfx98.show;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import me.xfx98.main.Main;

public class BasicFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private Container con;

	public BasicFrame() {
		this.con = getContentPane();
		setBounds(100, 100, 500, 500);
		GridLayout gl = new GridLayout(6, 2);

		con.setLayout(gl);
		this.setTitle("进程调度算法的模拟");
		Button b = new Button("添加进程");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] in = JOptionPane.showInputDialog(BasicFrame.this, "输入进程开始时间与服务时间以空格隔开").split(" ");
					int a = Integer.parseInt(in[0]);
					int b = Integer.parseInt(in[1]);
					if(b==0) {
						throw new RuntimeException();
					}
					Main.addProcess(a, b);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(BasicFrame.this, "输入错误或不存在该进程 ");
				}
			}
		});
		con.add(b);
		b = new Button("删除进程");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] in = JOptionPane.showInputDialog(BasicFrame.this, "输入进程顺序号以空格隔开").split(" ");
					for (String str : in) {
						Main.delProcess(Integer.parseInt(str));
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(BasicFrame.this, "输入错误或不存在该进程 ");
				}
			}
		});
		con.add(b);
		b = new Button("修改进程");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] in = JOptionPane.showInputDialog(BasicFrame.this, "输入进程顺序号、开始时间与服务时间以空格隔开").split(" ");
					int b = Integer.parseInt(in[2]);
					if(b==0) {
						throw new RuntimeException();
					}
					Main.setProcess(Integer.parseInt(in[0]), Integer.parseInt(in[1]), Integer.parseInt(in[2]));
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(BasicFrame.this, "输入错误 ");
				}
			}
		});
		con.add(b);
		b = new Button("查看所有进程信息");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ShowProcess();
			}
		});
		con.add(b);
		b = new Button("使用默认进程组");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.init();
			}
		});
		con.add(b);
		b = new Button("清空进程组");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.clearProcess();
			}
		});
		con.add(b);
		b = new Button("先来先服务");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FCFS();
			}
		});
		con.add(b);
		b = new Button("短作业优先");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SJF();
			}
		});
		con.add(b);
		b = new Button("最高响应比优先");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new HRRN();
			}
		});
		con.add(b);
		b = new Button("时间片轮转算法");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RR();
			}
		});
		con.add(b);
		b = new Button("多级反馈队列算法");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MFQ();
			}
		});
		con.add(b);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

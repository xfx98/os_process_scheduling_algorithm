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
		this.setTitle("���̵����㷨��ģ��");
		Button b = new Button("��ӽ���");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] in = JOptionPane.showInputDialog(BasicFrame.this, "������̿�ʼʱ�������ʱ���Կո����").split(" ");
					int a = Integer.parseInt(in[0]);
					int b = Integer.parseInt(in[1]);
					if(b==0) {
						throw new RuntimeException();
					}
					Main.addProcess(a, b);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(BasicFrame.this, "�������򲻴��ڸý��� ");
				}
			}
		});
		con.add(b);
		b = new Button("ɾ������");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] in = JOptionPane.showInputDialog(BasicFrame.this, "�������˳����Կո����").split(" ");
					for (String str : in) {
						Main.delProcess(Integer.parseInt(str));
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(BasicFrame.this, "�������򲻴��ڸý��� ");
				}
			}
		});
		con.add(b);
		b = new Button("�޸Ľ���");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] in = JOptionPane.showInputDialog(BasicFrame.this, "�������˳��š���ʼʱ�������ʱ���Կո����").split(" ");
					int b = Integer.parseInt(in[2]);
					if(b==0) {
						throw new RuntimeException();
					}
					Main.setProcess(Integer.parseInt(in[0]), Integer.parseInt(in[1]), Integer.parseInt(in[2]));
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(BasicFrame.this, "������� ");
				}
			}
		});
		con.add(b);
		b = new Button("�鿴���н�����Ϣ");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ShowProcess();
			}
		});
		con.add(b);
		b = new Button("ʹ��Ĭ�Ͻ�����");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.init();
			}
		});
		con.add(b);
		b = new Button("��ս�����");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.clearProcess();
			}
		});
		con.add(b);
		b = new Button("�����ȷ���");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FCFS();
			}
		});
		con.add(b);
		b = new Button("����ҵ����");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SJF();
			}
		});
		con.add(b);
		b = new Button("�����Ӧ������");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new HRRN();
			}
		});
		con.add(b);
		b = new Button("ʱ��Ƭ��ת�㷨");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RR();
			}
		});
		con.add(b);
		b = new Button("�༶���������㷨");
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

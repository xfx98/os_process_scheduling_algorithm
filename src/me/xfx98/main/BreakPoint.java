package me.xfx98.main;

import java.util.ArrayList;

public class BreakPoint {
	public int exTime; //
	public ArrayList<Process> exedp; // ��ִ�н����Ľ���
	public ArrayList<Process> exp; // ����״̬����
	public ArrayList<Process> nap; // δ��ִ��ʱ�����
	public Process now; // ����ִ�н���

	public BreakPoint() {
		exedp = new ArrayList<>();
		exp = new ArrayList<>();
		nap = new ArrayList<>();
	}

	public BreakPoint(Process now, int exTime) {
		this();
		this.now = now;
		this.exTime = exTime;
	}
}

package me.xfx98.main;

import java.util.ArrayList;

public class BreakPoint {
	public int exTime; //
	public ArrayList<Process> exedp; // 已执行结束的进程
	public ArrayList<Process> exp; // 就绪状态进程
	public ArrayList<Process> nap; // 未到执行时间进程
	public Process now; // 正在执行进程

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

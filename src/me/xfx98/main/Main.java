package me.xfx98.main;

import java.util.ArrayList;

import me.xfx98.show.BasicFrame;

public class Main {
	private static ArrayList<Process> al = new ArrayList<>();

	public static void main(String[] args) {
		new BasicFrame();
	}

	/**
	 * 使用默认进程顺序
	 */
	public static void init() {
		al.clear();
		al.add(new Process(0, 4));
		al.add(new Process(1, 3));
		al.add(new Process(2, 4));
		al.add(new Process(3, 2));
		al.add(new Process(4, 4));
	}

	/**
	 * 修改进程
	 * 
	 * @param id          进程所在顺序号
	 * @param beginTime   进程开始时间
	 * @param serviceTime 进程服务时间
	 */
	public static void setProcess(int id, int beginTime, int serviceTime) {
		al.get(id).setBeginTime(beginTime);
		al.get(id).setServiceTime(serviceTime);
	}

	/**
	 * 添加进程
	 * 
	 * @param beginTime   进程开始时间
	 * @param serviceTime 进程服务时间
	 */
	public static void addProcess(int beginTime, int serviceTime) {
		al.add(new Process(beginTime, serviceTime));
	}

	/**
	 * 删除进程
	 * 
	 * @param id 进程所在顺序号
	 */
	public static void delProcess(int id) {
		al.remove(id);
	}
	/**
	 * 
	 */
	public static void clearProcess() {
		al.clear();
	}
	/**
	 * @return 返回进程列表
	 */
	public static ArrayList<Process> getProcesses() {
		return al;
	}
}

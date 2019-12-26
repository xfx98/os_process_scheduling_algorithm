package me.xfx98.main;

public class Process implements Comparable<Process> {
	private int beginTime; //进程开始时间
	private int serviceTime; //进程服务时间
	private String text; 
	public int usedTime; //进程已运行时间

	public Process() {
	}

	public Process(int beginTime, int serviceTime) {
		this.beginTime = beginTime;
		this.serviceTime = serviceTime;
	}

	public Process(int beginTime, int serviceTime, String text) {
		this(beginTime, serviceTime);
		this.text = text;
	}

	public int getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(int beginTime) {
		this.beginTime = beginTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getText() {
		return text;
	}

	public Process setText(String text) {
		this.text = text;
		return this;
	}

	public int getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(int usedTime) {
		this.usedTime = usedTime;
	}

	@Override
	public int compareTo(Process o) {
		return this.getBeginTime() - o.getBeginTime();
	}

}

package me.xfx98.main;

import java.util.ArrayList;

import me.xfx98.show.BasicFrame;

public class Main {
	private static ArrayList<Process> al = new ArrayList<>();

	public static void main(String[] args) {
		new BasicFrame();
	}

	/**
	 * ʹ��Ĭ�Ͻ���˳��
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
	 * �޸Ľ���
	 * 
	 * @param id          ��������˳���
	 * @param beginTime   ���̿�ʼʱ��
	 * @param serviceTime ���̷���ʱ��
	 */
	public static void setProcess(int id, int beginTime, int serviceTime) {
		al.get(id).setBeginTime(beginTime);
		al.get(id).setServiceTime(serviceTime);
	}

	/**
	 * ��ӽ���
	 * 
	 * @param beginTime   ���̿�ʼʱ��
	 * @param serviceTime ���̷���ʱ��
	 */
	public static void addProcess(int beginTime, int serviceTime) {
		al.add(new Process(beginTime, serviceTime));
	}

	/**
	 * ɾ������
	 * 
	 * @param id ��������˳���
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
	 * @return ���ؽ����б�
	 */
	public static ArrayList<Process> getProcesses() {
		return al;
	}
}

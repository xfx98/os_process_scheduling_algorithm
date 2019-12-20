package me.xfx98.show;

import java.util.ArrayList;

import me.xfx98.main.BreakPoint;
import me.xfx98.main.Process;

public class SJF extends AbstractShow {
	private static final long serialVersionUID = 1L;

	public SJF() {
		this.setTitle("短作业优先");
		init();
		setShow();
		Show(0);
	}

	@Override
	public void setShow() {
		ArrayList<Process> qex = new ArrayList<>();
		ArrayList<Process> qexd = new ArrayList<>();
		int cont = 0;
		while (!qex.isEmpty() || cont < al.size()) {
			while (qex.isEmpty() && al.get(cont).getBeginTime() > bps.size()) {
				BreakPoint bp = new BreakPoint();
				for (int j = 0; j < qexd.size(); j++) {
					bp.exedp.add(qexd.get(j));
				}
				for (int j = 0; j < qex.size(); j++) {
					bp.exp.add(qex.get(j));
				}
				for (int j = cont; j < al.size(); j++) {
					bp.nap.add(al.get(j));
				}
				bps.add(bp);
			}
			for (int j = cont; j < al.size() && al.get(j).getBeginTime() <= bps.size(); j++) {
				for (int i = 0; i <= qex.size(); i++) {
					if (i == qex.size() || al.get(cont).getServiceTime() < qex.get(i).getServiceTime()) {
						qex.add(i, al.get(cont));
						cont++;
						break;
					}
				}
			}
			Process p = qex.get(0);
			qex.remove(0);
			for (int t = 0; t < p.getServiceTime(); t++) {
				BreakPoint bp = new BreakPoint();
				for (int j = 0; j < qexd.size(); j++) {
					bp.exedp.add(qexd.get(j));
				}
				for (int j = 0; j < qex.size(); j++) {
					bp.exp.add(qex.get(j));
				}
				for (int j = cont; j < al.size(); j++) {
					bp.nap.add(al.get(j));
				}
				bp.exTime = t;
				bp.now = p;
				bps.add(bp);
				for (int j = cont; j < al.size() && al.get(j).getBeginTime() <= bps.size(); j++) {
					for (int i = 0; i <= qex.size(); i++) {
						if (i == qex.size() || al.get(cont).getServiceTime() < qex.get(i).getServiceTime()) {
							qex.add(i, al.get(cont));
							cont++;
							break;
						}
					}
				}
			}
			qexd.add(p);
		}
	}
}

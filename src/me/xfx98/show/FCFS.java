package me.xfx98.show;

import me.xfx98.main.BreakPoint;

public class FCFS extends AbstractShow {
	private static final long serialVersionUID = 1L;
	public FCFS() {
		this.setTitle("先来先服务");
		init();
		setShow();
		Show(0);
	}
	public void setShow() {
		for (int i = 0; i < al.size(); i++) {
			while (al.get(i).getBeginTime() > bps.size()) {
				BreakPoint bp = new BreakPoint();
				for (int j = 0; j < i; j++) {
					bp.exedp.add(al.get(j));
				}
				for (int j = i + 1; j < al.size(); j++) {
					if (al.get(j).getBeginTime() <= bps.size()) {
						bp.exp.add(al.get(j));
					} else {
						bp.nap.add(al.get(j));
					}

				}
				bps.add(bp);
			}
			for (int t = 0; t < al.get(i).getServiceTime(); t++) {
				BreakPoint bp = new BreakPoint();
				for (int j = 0; j < i; j++) {
					bp.exedp.add(al.get(j));
				}
				for (int j = i + 1; j < al.size(); j++) {
					if (al.get(j).getBeginTime() <= bps.size()) {
						bp.exp.add(al.get(j));
					} else {
						bp.nap.add(al.get(j));
					}

				}
				bp.exTime = t;
				bp.now = al.get(i);
				bps.add(bp);
			}
		}
	}
}

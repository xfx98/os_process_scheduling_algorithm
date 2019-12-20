package me.xfx98.show;

import java.util.ArrayList;

import me.xfx98.main.BreakPoint;
import me.xfx98.main.Process;

public class RR extends AbstractShow {
	private static final long serialVersionUID = 1L;

	public RR() {
		this.setTitle("时间片轮转算法：时间片为2");
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
				qex.add(al.get(cont));
				cont++;
			}
			while (!qex.isEmpty()) {
				Process p = qex.get(0);
				qex.remove(0);
				for (int t = 0; t < 2; t++) {
					for (int j = cont; j < al.size() && al.get(j).getBeginTime() <= bps.size(); j++) {
						qex.add(al.get(cont));
						cont++;
					}
					p.usedTime++;
					if (p.usedTime == p.getServiceTime()) {
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
						bp.exTime = p.usedTime - 1;
						bp.now = p;
						bps.add(bp);
						break;
					} else {
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
						bp.exTime = p.usedTime - 1;
						bp.now = p;
						bps.add(bp);
					}

				}
				if (p.usedTime == p.getServiceTime()) {
					qexd.add(p);
					p.usedTime = 0;
				} else {
					qex.add(p);
				}
			}

		}
	}
}

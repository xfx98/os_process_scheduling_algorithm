package me.xfx98.show;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import me.xfx98.main.BreakPoint;
import me.xfx98.main.Process;

public class HRRN extends AbstractShow {
	private static final long serialVersionUID = 1L;

	public HRRN() {
		this.setTitle("最高响应比优先");
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
			Collections.sort(qex, new Comparator<Process>() {
				@Override
				public int compare(Process o1, Process o2) {

					return ((o1.getServiceTime() + bps.size() - o1.getBeginTime()) * 1.0 / o1.getServiceTime()
							- (o2.getServiceTime() + bps.size() - o2.getBeginTime()) * 1.0
									/ o2.getServiceTime()) > 0 ? -1 : 1;
				}
			});
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
					qex.add(al.get(cont));
					cont++;
				}
				Collections.sort(qex, new Comparator<Process>() {
					@Override
					public int compare(Process o1, Process o2) {

						return ((o1.getServiceTime() + bps.size() - o1.getBeginTime()) * 1.0 / o1.getServiceTime()
								- (o2.getServiceTime() + bps.size() - o2.getBeginTime()) * 1.0
										/ o2.getServiceTime()) > 0 ? -1 : 1;
					}
				});
			}
			qexd.add(p);
		}
	}
}

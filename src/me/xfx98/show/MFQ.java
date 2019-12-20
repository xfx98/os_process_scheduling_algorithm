package me.xfx98.show;

import java.util.ArrayList;

import me.xfx98.main.BreakPoint;
import me.xfx98.main.Process;

public class MFQ extends AbstractShow {
	private static final long serialVersionUID = 1L;

	public MFQ() {
		this.setTitle("多级反馈队列算法");
		init();
		setShow();
		Show(0);
	}

	@Override
	public void setShow() {
		ArrayList<ArrayList<Process>> qex = new ArrayList<>();
		ArrayList<Process> qexd = new ArrayList<>();
		int cont = 0;
		while (!isEmpty(qex) || cont < al.size()) {
			while (isEmpty(qex) && al.get(cont).getBeginTime() > bps.size()) {
				BreakPoint bp = new BreakPoint();
				for (int j = 0; j < qexd.size(); j++) {
					bp.exedp.add(qexd.get(j));
				}
				for (int j = 0; j < qex.size(); j++) {
					bp.exp.add(new Process().setText("------第" + j + "队列，时间片长度为" + (1 << j)+"------"));
					for (int k = 0; k < qex.get(j).size(); k++) {
						bp.exp.add(qex.get(j).get(k));
					}
				}
				for (int j = cont; j < al.size(); j++) {
					bp.nap.add(al.get(j));
				}
				bps.add(bp);
			}
			for (int j = cont; j < al.size() && al.get(j).getBeginTime() <= bps.size(); j++) {
				if (qex.size() <= 0) {
					qex.add(new ArrayList<>());
				}
				qex.get(0).add(al.get(cont));
				cont++;
			}
			while (!isEmpty(qex)) {
				int dlid = 0;
				Process p = null;
				for (int i = 0; i < qex.size(); i++) {
					if (!qex.get(i).isEmpty()) {
						p = qex.get(i).get(0);
						qex.get(i).remove(0);
						dlid = i;
						break;
					}
				}
				for (int t = 0; t < (1 << dlid); t++) {
					for (int j = cont; j < al.size() && al.get(j).getBeginTime() <= bps.size(); j++) {
						if (qex.size() <= 0) {
							qex.add(new ArrayList<>());
						}
						qex.get(0).add(al.get(cont));
						cont++;
					}
					p.usedTime++;
					if (p.usedTime == p.getServiceTime()) {
						BreakPoint bp = new BreakPoint();
						for (int j = 0; j < qexd.size(); j++) {
							bp.exedp.add(qexd.get(j));
						}
						for (int j = 0; j < qex.size(); j++) {
							bp.exp.add(new Process().setText("------第" + j + "队列，时间片长度为" + (1 << j)+"------"));
							for (int k = 0; k < qex.get(j).size(); k++) {
								bp.exp.add(qex.get(j).get(k));
							}
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
							bp.exp.add(new Process().setText("------第" + j + "队列，时间片长度为" + (1 << j)+"------"));
							for (int k = 0; k < qex.get(j).size(); k++) {
								bp.exp.add(qex.get(j).get(k));
							}
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
					while (dlid + 1 >= qex.size()) {
						qex.add(new ArrayList<>());
					}
					qex.get(dlid + 1).add(p);
				}
			}

		}
	}

	private boolean isEmpty(ArrayList<ArrayList<Process>> qex) {
		for (int i = 0; i < qex.size(); i++) {
			if (!qex.get(i).isEmpty()) {
				return false;
			}
		}
		return true;
	}
}

package br.eduprivate.dswalgol.deque;

import br.eduprivate.dswalgol.stack.ArrayStack;
import br.eduprivate.dswalgol.stack.Stack;

public class ComputeSpans {
	
	public void computeDailyHightSpan(Quote Q[]) {
		int prevHigh;
		Stack D = new ArrayStack();
		for (int i = 0; i < Q.length; i++) {
			while (!D.isEmpty() && Q[i].getPrice() >= ((Quote) D.top()).getPrice()) {
				D.pop();
				if (D.isEmpty()) {
					prevHigh = 1;
				} else {
					prevHigh = ((Quote) D.top()).getDay();
					Q[i].setSpan(i - prevHigh);
					D.push(Q[i]);
				}
			}
		}
	}
}

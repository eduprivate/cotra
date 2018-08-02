package br.eduprivate.problems_solving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Ordening {
	public List<String> reorderLines(int logFileSize, List<String> logLines) {

		List<String> logs = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		for (String log : logLines) {
			StringTokenizer tokenizer = new StringTokenizer(log.toLowerCase());
			String top = tokenizer.nextToken();
			String b1 = tokenizer.nextToken();
			String b2 = tokenizer.nextToken();
			String b3 = tokenizer.nextToken();
			map.put(b1 + " " + b2 + " " + b3, top);

		}

		for (Map.Entry<String, String> entry : map.entrySet()) {
			logs.add(entry.getValue() + " " + entry.getKey());
		}
		Collections.sort(logs);
		return logs;
	}

	public static void main(String[] args) {
		Ordening solution = new Ordening();

		List<String> logs = new ArrayList<>();
		logs.add("a1 alps cow bar");
		logs.add("mi2 jog mid pet");
		System.out.println(solution.reorderLines(5, logs));
	}
}
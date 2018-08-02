package br.eduprivate.problems_solving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Freq {
	List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {
		Map<String, Integer> counter = new HashMap<>();
		StringTokenizer tokenizer = new StringTokenizer(literatureText.toLowerCase());

		while (tokenizer.hasMoreTokens()) {
			String word = tokenizer.nextToken();
			if (isStopWorld(word, wordsToExclude)) {
				continue;
			} else {
				if (counter.containsKey(word)) {
					Integer value = counter.get(word);
					counter.put(word, value + 1);
				} else {
					counter.put(word, 1);
				}
			}
		}

		Map<String, Integer> words = new HashMap<>();
		for (Map.Entry<String, Integer> entry : counter.entrySet()) {
			if (entry.getValue() > 1) {
				words.put(entry.getKey(), entry.getValue());
			}
		}

		return calcMostUsedWords(words);
	}

	private List<String> calcMostUsedWords(Map<String, Integer> counter) {
		List<String> words = new ArrayList<String>();
		counter.entrySet().stream().sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
				.forEach(k -> words.add(k.getKey()));
		return words;
	}

	private boolean isStopWorld(String word, List<String> stopWords) {
		for (String stopWord : stopWords) {
			if (stopWord != null && !stopWord.isEmpty()) {
				String lowerStopWord = stopWord.toLowerCase();
				if (lowerStopWord.equalsIgnoreCase(word)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Freq solution = new Freq();
		List<String> stopWorlds = new ArrayList<>();
		stopWorlds.add("rose");
		stopWorlds.add("is");
		stopWorlds.add("a");
		System.out.println(solution.retrieveMostFrequentlyUsedWords("romeu therefore is a rose", stopWorlds));
	}
}
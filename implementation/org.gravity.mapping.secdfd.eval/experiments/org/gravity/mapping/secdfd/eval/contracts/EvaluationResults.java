package org.gravity.mapping.secdfd.eval.contracts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EvaluationResults {
	
	public final Map<String, Integer> truePositives;
	public final Map<String, Integer> falsePositives;
	public final Map<String, Integer>  falseNegatives;

	public EvaluationResults() {
		this.truePositives = new HashMap<>();
		this.falsePositives = new HashMap<>();
		this.falseNegatives = new HashMap<>();
	}
	
	public void tp(String key) {
		truePositives.compute(key, (k, v) -> (v == null) ? 1 : ++v);
	}
	
	public void fp(String key) {
		falsePositives.compute(key, (k, v) -> (v == null) ? 1 : ++v);
	}
	
	public void fn(String key) {
		falseNegatives.compute(key, (k, v) -> (v == null) ? 1 : ++v);
	}

	public int getSumFalseNegatives() {
		return falseNegatives.values().stream().mapToInt(Integer::intValue).sum();
	}

	public int getSumFalsePositives() {
		return falsePositives.values().stream().mapToInt(Integer::intValue).sum();
	}

	public int getSumTruePositives() {
		return truePositives.values().stream().mapToInt(Integer::intValue).sum();
	}

	public Set<String> getRecordedKeys() {
		Set<String> keys = new HashSet<>();
		keys.addAll(falseNegatives.keySet());
		keys.addAll(falsePositives.keySet());
		keys.addAll(truePositives.keySet());
		return keys;
	}

	public int getTruePositives(String key) {
		return truePositives.getOrDefault(key, 0);
	}

	public int getFalseNegatives(String key) {
		return falseNegatives.getOrDefault(key, 0);
	}

	public int getFalsePositives(String key) {
		return falsePositives.getOrDefault(key, 0);
	}
}
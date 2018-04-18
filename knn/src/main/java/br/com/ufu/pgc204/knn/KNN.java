package br.com.ufu.pgc204.knn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import br.com.ufu.pgc204.knn.math.Distance;
import br.com.ufu.pgc204.knn.model.SampleDto;

/**
 * @author Dali Freire <i>dalifreire@gmail.com</i>
 * @since 04/2018
 */
public class KNN {

	private List<SampleDto> samples;

	public KNN(List<SampleDto> samples) {
		this.samples = clone(samples);
	}

	public String classify(List<Double> sample, Distance distance, int k) {

		/* obtem os k elementos mais proximos */
		List<SampleDto> kElements = kElements(sample, distance, k);

		/* conta a classe mais retornada nos k elementos */
		Map<String, Integer> counter = new HashMap<String, Integer>();
		for (SampleDto s : kElements) {

			String className = s.getClassName();
			Integer value = counter.get(className) == null ? 0 : counter.get(className);
			counter.put(className, value + 1);
		}

		/* verifica se houve empate */
		if (k > 1) {
			Set<Integer> countSet = new HashSet<Integer>();
			for (Integer count : counter.values()) {
				if (!countSet.add(count)) {
					return classify(sample, distance, (k - 1));
				}
			}
		}

		/* retorna a classe mais presente nos k elementos proximos */
		TreeSet<Integer> sortedValues = new TreeSet<Integer>(counter.values());
		Integer winnerClass = sortedValues.last();
		for (Map.Entry<String, Integer> entry : counter.entrySet()) {

			String key = entry.getKey();
			Integer value = entry.getValue();
			if (value == winnerClass) {
				return key;
			}
		}

		return null;
	}

	public List<SampleDto> kElements(List<Double> sample, Distance distance, int k) {

		/* k eh maior do que todos os elementos do conjunto de amostras? */
		if (k >= this.samples.size()) {
			return samples;
		}

		/* calcula a distancia entre a amostra e todos os elementos do conjunto */
		for (SampleDto s : this.samples) {
			double d = distance.calculate(s.getAttributes(), sample);
			s.setDistance(d);
		}

		/* Ordena as amostras pela distancia */
		Collections.sort(this.samples, new Comparator<SampleDto>() {
			public int compare(SampleDto o1, SampleDto o2) {
				return o1.getDistance().compareTo(o2.getDistance());
			}
		});

		/* retorna os k elementos mais proximos */
		return this.samples.subList(0, k);
	}

	private List<SampleDto> clone(List<SampleDto> samples) {
		List<SampleDto> samplesCopy = new ArrayList<SampleDto>();
		for (SampleDto s : samples) {
			samplesCopy.add(s.clone());
		}
		return samplesCopy;
	}

}

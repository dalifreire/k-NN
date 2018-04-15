package br.com.ufu.pgc204.knn.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import lombok.Getter;

/**
 * @author Dali Freire <i>dalifreire@gmail.com</i>
 * @since 04/2018
 */
public class ZScore {

	@Getter
	private double value;
	@Getter
	private List<Double> values = new ArrayList<Double>();

	public ZScore(double value, List<Double> values) {
		this.value = value;
		this.values = (values != null ? values : new ArrayList<Double>());
	}

	public ZScore(double value, Double[] values) {
		this(value, Arrays.asList(values));
	}

	public ZScore(double value, double[] values) {
		this(value, ArrayUtils.toObject(values));
	}

	public Double calculate() {
		double avg = new Average(this.values).calculate();
		double std = new StandardDeviation(this.values).calculate();
		return (this.value - avg) / std;
	}

	public Double calculate(double value, double avg, double std) {
		return (value - avg) / std;
	}

}

package br.com.ufu.pgc204.knn.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import lombok.Getter;

/**
 * <p>
 * Computes the arithmetic mean of a set of values. Uses the definitional
 * formula:
 * </p>
 * <p>
 * mean = sum(x_i) / n
 * </p>
 * <p>
 * where <code>n</code> is the number of items.
 * </p>
 * 
 * @author Dali Freire <i>dalifreire@gmail.com</i>
 * @since 04/2018
 */
public class Average {

	@Getter
	private List<Double> values = new ArrayList<Double>();

	public Average(List<Double> values) {
		this.values = (values != null ? values : new ArrayList<Double>());
	}

	public Average(Double[] values) {
		this(Arrays.asList(values));
	}

	public Average(double[] values) {
		this(ArrayUtils.toObject(values));
	}

	/**
	 * Computes the arithmetic mean of a set of values.
	 * 
	 * @return {@link Double}
	 */
	public Double calculate() {
		Double sum = Double.valueOf(0.0);
		for (Double v : this.values) {
			sum += v;
		}
		return this.values.size() > 0 ? (sum / this.values.size()) : 0;
	}

}

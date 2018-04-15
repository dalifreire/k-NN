package br.com.ufu.pgc204.knn.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import lombok.Getter;

/**
 * Computes the variance of the available values. By default, the unbiased
 * "sample variance" definitional formula is used:
 * <p>
 * variance = sum((x_i - mean)^2) / (n - 1)
 * </p>
 * <p>
 * where mean is the {@link Average} and <code>n</code> is the number of sample
 * observations.
 * </p>
 * 
 * @author Dali Freire <i>dalifreire@gmail.com</i>
 * @since 04/2018
 */
public class Variance {

	@Getter
	private List<Double> values = new ArrayList<Double>();

	public Variance(List<Double> values) {
		this.values = (values != null ? values : new ArrayList<Double>());
	}

	public Variance(Double[] values) {
		this(Arrays.asList(values));
	}

	public Variance(double[] values) {
		this(ArrayUtils.toObject(values));
	}

	/**
	 * Computes the variance of the available values.
	 * 
	 * @return {@link Double}
	 */
	public Double calculate() {

		Double avg = new Average(this.values).calculate();
		Double sum = Double.valueOf(0.0);
		for (Double v : this.values) {
			sum += Math.pow((v - avg), 2);
		}
		return this.values.size() > 1 ? (sum / (this.values.size() - 1)) : 0;
	}

}

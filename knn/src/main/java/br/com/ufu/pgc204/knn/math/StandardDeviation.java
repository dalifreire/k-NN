package br.com.ufu.pgc204.knn.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import lombok.Getter;

/**
 * Computes the standard deviation. The standard deviation is the positive
 * square root of the variance. By default, the variance definitional formula is
 * used:
 * <p>
 * variance = sum((x_i - avg)^2) / (n - 1)
 * </p>
 * <p>
 * where avg is the {@link Average} and <code>n</code> is the number of sample
 * observations.
 * </p>
 * <p>
 * 
 * @author Dali Freire <i>dalifreire@gmail.com</i>
 * @since 04/2018
 */
public class StandardDeviation {

	@Getter
	private List<Double> values = new ArrayList<Double>();

	public StandardDeviation(List<Double> values) {
		this.values = (values != null ? values : new ArrayList<Double>());
	}

	public StandardDeviation(Double[] values) {
		this(Arrays.asList(values));
	}

	public StandardDeviation(double[] values) {
		this(ArrayUtils.toObject(values));
	}

	/**
	 * Computes the standard deviation.
	 * 
	 * @return {@link Double}
	 */
	public Double calculate() {
		Double variance = new Variance(this.values).calculate();
		return Math.sqrt(variance);
	}

}

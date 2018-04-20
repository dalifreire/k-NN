package br.com.ufu.pgc204.knn.math;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import lombok.NoArgsConstructor;

/**
 * @author Dali Freire <i>dalifreire@gmail.com</i>
 * @since 04/2018
 */
@NoArgsConstructor
public class EuclideanDistance implements Distance {

	public double calculate(List<Double> p1, List<Double> p2) {
		return calculate(ArrayUtils.toPrimitive(p1.toArray(new Double[] {})),
				ArrayUtils.toPrimitive(p2.toArray(new Double[] {})));
	}

	public double calculate(double[] p1, double[] p2) {
		if (p1.length == p2.length && p1.length > 0) {
			double sum = 0;
			for (int i = 0; i < p1.length; i++) {
				double dp = p1[i] - p2[i];
				sum += dp * dp;
			}
			return Math.sqrt(sum);
		}
		return Double.MAX_VALUE;
	}

}

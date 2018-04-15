package br.com.ufu.pgc204.knn.math;

import br.com.ufu.pgc204.knn.Distance;
import lombok.Getter;

/**
 * @author Dali Freire <i>dalifreire@gmail.com</i>
 * @since 04/2018
 */
public class EuclideanDistance implements Distance {

	@Getter
	private double[] p1;
	@Getter
	private double[] p2;

	public EuclideanDistance(double[] p1, double[] p2) {
		this.p1 = p1 != null ? p1 : new double[0];
		this.p2 = p2 != null ? p2 : new double[0];
	}

	public double calculate() {
		if (this.p1.length == this.p2.length && this.p1.length > 0) {
			double sum = 0;
			for (int i = 0; i < this.p1.length; i++) {
				double dp = this.p1[i] - this.p2[i];
				sum += dp * dp;
			}
			return Math.sqrt(sum);
		}
		return 0.0;
	}

}

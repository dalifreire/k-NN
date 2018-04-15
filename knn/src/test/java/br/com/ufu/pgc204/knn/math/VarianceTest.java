package br.com.ufu.pgc204.knn.math;

import org.junit.Assert;
import org.junit.Test;

public class VarianceTest {

	@Test
	public void testCalculate() {

		double[] values1 = { 1.87, 1.65, 1.80, 1.81, 1.90, 1.74, 1.49, 1.56, 1.73, 1.76 };
		double var1 = new Variance(values1).calculate();

		double[] values2 = { 76.1, 75.2, 60.0, 55.9, 93.3, 65.2, 45.1, 53.2, 55.1, 63.1 };
		double var2 = new Variance(values2).calculate();

		Assert.assertEquals(0.01707666666666667, var1, 0.0);
		Assert.assertEquals(196.3084444444444, var2, 0.0);
	}

}

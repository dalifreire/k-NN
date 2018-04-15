package br.com.ufu.pgc204.knn.math;

import org.junit.Assert;
import org.junit.Test;

public class StandardDeviationTest {

	@Test
	public void testCalculate() {

		double[] values1 = { 1.87, 1.65, 1.80, 1.81, 1.90, 1.74, 1.49, 1.56, 1.73, 1.76 };
		double std1 = new StandardDeviation(values1).calculate();

		double[] values2 = { 76.1, 75.2, 60.0, 55.9, 93.3, 65.2, 45.1, 53.2, 55.1, 63.1 };
		double std2 = new StandardDeviation(values2).calculate();

		Assert.assertEquals(0.130677720620872, std1, 0.0);
		Assert.assertEquals(14.011011542513424, std2, 0.0);
	}

}

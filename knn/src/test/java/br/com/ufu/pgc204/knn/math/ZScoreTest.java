package br.com.ufu.pgc204.knn.math;

import org.junit.Assert;
import org.junit.Test;

public class ZScoreTest {

	@Test
	public void testCalculate() {

		double[] values1 = { 1.87, 1.65, 1.80, 1.81, 1.90, 1.74, 1.49, 1.56, 1.73, 1.76 };
		double zscore1 = new ZScore(values1[0], values1).calculate();

		double[] values2 = { 76.1, 75.2, 60.0, 55.9, 93.3, 65.2, 45.1, 53.2, 55.1, 63.1 };
		double zscore2 = new ZScore(values2[0], values2).calculate();

		Assert.assertEquals(1.06, zscore1, 0.01);
		Assert.assertEquals(0.84, zscore2, 0.01);
	}

}

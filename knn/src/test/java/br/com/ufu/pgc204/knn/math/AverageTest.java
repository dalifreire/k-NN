package br.com.ufu.pgc204.knn.math;

import org.junit.Assert;
import org.junit.Test;

public class AverageTest {

	@Test
	public void testCalculate() {

		double[] values = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0 };
		double avg = new Average(values).calculate();

		Assert.assertEquals(5.5, avg, 0.0);
	}

}

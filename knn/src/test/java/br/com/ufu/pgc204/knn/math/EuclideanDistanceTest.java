package br.com.ufu.pgc204.knn.math;

import org.junit.Assert;
import org.junit.Test;

public class EuclideanDistanceTest {

	@Test
	public void testCalculate() {

		double[] p1 = { 1.04, 0.84 };
		double[] p2 = { 0.12, -0.87 };
		double distance = new EuclideanDistance(p1, p2).calculate();

		Assert.assertEquals(1.9417775361765826, distance, 0.0);
	}

}

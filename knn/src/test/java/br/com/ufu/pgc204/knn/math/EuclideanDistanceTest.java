package br.com.ufu.pgc204.knn.math;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EuclideanDistanceTest {

	@Test
	public void testCalculate() {

		double[] p1 = { 1.04, 0.84 };
		double[] p2 = { 0.12, -0.87 };
		double distance1 = new EuclideanDistance().calculate(p1, p2);

		List<Double> l1 = Arrays.asList(1.04, 0.84);
		List<Double> l2 = Arrays.asList(0.12, -0.87);
		double distance2 = new EuclideanDistance().calculate(l1, l2);

		Assert.assertEquals(1.9417775361765826, distance1, 0.0);
		Assert.assertEquals(1.9417775361765826, distance2, 0.0);
	}

}

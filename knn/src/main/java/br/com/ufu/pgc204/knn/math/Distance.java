package br.com.ufu.pgc204.knn.math;

import java.util.List;

public interface Distance {

	public double calculate(double[] p1, double[] p2);

	public double calculate(List<Double> p1, List<Double> p2);

}

package br.com.ufu.pgc204.knn.math;

import java.util.List;

/**
 * @author Dali Freire <i>dalifreire@gmail.com</i>
 * @since 04/2018
 */
public interface Distance {

	/**
	 * Calcula a distancia entre dois pontos (arrays).
	 * 
	 * @param p1
	 * @param p2
	 * @return {@link Double}
	 */
	public double calculate(double[] p1, double[] p2);

	/**
	 * Calcula a distancia entre dois pontos (listas)
	 * 
	 * @param p1
	 * @param p2
	 * @return {@link Double}
	 */
	public double calculate(List<Double> p1, List<Double> p2);

}

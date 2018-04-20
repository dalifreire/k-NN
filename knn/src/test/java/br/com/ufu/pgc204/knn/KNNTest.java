package br.com.ufu.pgc204.knn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.ufu.pgc204.knn.math.EuclideanDistance;
import br.com.ufu.pgc204.knn.model.SampleDto;

public class KNNTest {

	@Test
	public void testClassify() {

		List<SampleDto> samples = new ArrayList<SampleDto>();
		samples.add(new SampleDto("classe 1", Arrays.asList(new Double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 })));
		samples.add(new SampleDto("classe 1", Arrays.asList(new Double[] { 11.0, 22.0, 33.0, 44.0, 55.0, 66.0 })));
		samples.add(new SampleDto("classe 2", Arrays.asList(new Double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 })));
		samples.add(new SampleDto("classe 2", Arrays.asList(new Double[] { 10.0, 20.0, 30.0, 40.0, 50.0, 60.0 })));
		samples.add(new SampleDto("classe 3", Arrays.asList(new Double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 })));
		samples.add(new SampleDto("classe 3", Arrays.asList(new Double[] { -1.0, -2.0, -3.0, -4.0, -5.0, -6.0 })));

		KNN knn = new KNN(samples);
		String classe = knn.classify(Arrays.asList(new Double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }),
				new EuclideanDistance(), 3);
		Assert.assertEquals("classe 1", classe);

	}

}

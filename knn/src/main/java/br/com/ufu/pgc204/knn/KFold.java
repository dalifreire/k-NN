package br.com.ufu.pgc204.knn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;

import br.com.ufu.pgc204.knn.math.EuclideanDistance;
import br.com.ufu.pgc204.knn.model.SampleDto;

/**
 * @author Dali Freire <i>dalifreire@gmail.com</i>
 * @since 04/2018
 */
public class KFold {

	private Integer knnValue;
	private Integer kFoldValue;
	private List<SampleDto> samples = new ArrayList<SampleDto>();

	public KFold(Integer knnValue, Integer kFoldValue, List<SampleDto> samples) {
		super();
		this.knnValue = knnValue;
		this.kFoldValue = kFoldValue;
		this.samples = clone(samples);
	}

	public double execute() {

		/* coloca o conjunto de amostras em ordem aleatoria */
		Collections.shuffle(this.samples);

		/* particiona o conjunto de amostras em k particoes (k-fold) */
		int partitionSize = this.samples.size() / this.kFoldValue;
		List<List<SampleDto>> kFoldLists = ListUtils.partition(this.samples, partitionSize);

		/* quantidade de acertos */
		int countSuccess = 0;
		
		/* itera sobre a quantidade de particoes */
		for (int i = 0; i < this.kFoldValue; i++) {

			/* utiliza k-1 particoes para o treinamento */
			List<SampleDto> training = new ArrayList<SampleDto>();
			for (int j = 0; j < this.kFoldValue; j++) {
				if (j != i) {
					training.addAll(kFoldLists.get(j));
				}
			}

			/* utiliza 1 particao para a validacao */
			List<SampleDto> test = kFoldLists.get(i);
			for (SampleDto s : test) {
				
				/* obtem a classe da amostra de validacao executando o KNN no conjunto de treinamento */
				String className = new KNN(training).classify(s.getAttributes(), new EuclideanDistance(), this.knnValue);
				
				/* verifica se a classe da amostra de validacao eh a mesma obtida pela execucao do KNN no conjunto de treinamento */
				if (StringUtils.equals(s.getClassName(), className)) {
					countSuccess++;
				}
			}
		}
		
		/* calcula a taxa de acerto */
		return Double.valueOf(countSuccess)/Double.valueOf(this.samples.size());
	}

	private List<SampleDto> clone(List<SampleDto> samples) {
		List<SampleDto> samplesCopy = new ArrayList<SampleDto>();
		for (SampleDto s : samples) {
			samplesCopy.add(s.clone());
		}
		return samplesCopy;
	}

}

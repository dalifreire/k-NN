package br.com.ufu.pgc204.knn;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.ListUtils;

import br.com.ufu.pgc204.knn.model.SampleDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class KFold {

	private Integer knnValue;
	private Integer kFoldValue;
	private List<SampleDto> samples = new ArrayList<SampleDto>();

	public void execute() {

		/* particiona o conjunto de amostras em k particoes */
		int partitionSize = this.samples.size() / this.kFoldValue;
		List<List<SampleDto>> kFoldLists = ListUtils.partition(this.samples, partitionSize);

		for (int i = 0; i < this.kFoldValue; i++) {

			/* utiliza k-1 particoes para o treinamento */
			for (int j = 0; j < this.kFoldValue; j++) {
				if (j != i) {

					List<SampleDto> training = kFoldLists.get(j);
				}
			}

			/* utiliza 1 particao para o validacao */
			List<SampleDto> test = kFoldLists.get(i);

		}

	}

}

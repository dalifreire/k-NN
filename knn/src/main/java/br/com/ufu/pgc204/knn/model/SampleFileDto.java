package br.com.ufu.pgc204.knn.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SampleFileDto {

	@Getter
	private Integer numberOfSamples;
	@Getter
	private Integer numberOfAttributes;
	@Getter
	private List<SampleDto> samples = new ArrayList<SampleDto>();

}

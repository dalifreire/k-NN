package br.com.ufu.pgc204.knn.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SampleFileDto {

	@Getter
	private Integer numberOfSamples;
	@Getter
	private Integer attributesPerSample;
	@Getter
	private double[][] attributes;
	@Getter
	private double[][] attributesZscore;
	@Getter
	private List<SampleDto> samples = new ArrayList<SampleDto>();

}

package br.com.ufu.pgc204.knn.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString(includeFieldNames = true)
@NoArgsConstructor
public class SampleDto {

	@Getter
	@Setter
	private Double distance;
	@Getter
	private String className;
	@Getter
	private List<Double> attributes = new ArrayList<Double>();

	public SampleDto(String className, List<Double> attributes) {
		this.className = className;
		this.attributes = attributes;
	}

}

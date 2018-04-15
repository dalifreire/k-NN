package br.com.ufu.pgc204.knn.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(includeFieldNames = true)
@NoArgsConstructor
@AllArgsConstructor
public class SampleDto {

	@Getter
	private String className;
	@Getter
	private List<Double> attributes = new ArrayList<Double>();

}

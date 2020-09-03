package com.jsnakamura.dataAnalysis.helper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.jsnakamura.dataAnalysis.entity.Answer;

public class DataLoader {

	private Gson gson = new Gson();

	public List<Answer> loadData() throws FileNotFoundException {
		
		Reader input = new FileReader("../DataAnalysis/src/main/resources/Input/input.json");
			
		Answer[] answers = gson.fromJson(input, Answer[].class);
		
		return Arrays.asList(answers);
	}
}

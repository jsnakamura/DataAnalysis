package com.jsnakamura.dataAnalysis.helper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.jsnakamura.dataAnalysis.entity.Answer;

public class DataHelper {
	
	private Gson gson = new Gson();
	
	public List<Answer> loadData() throws IOException{
			
			System.out.println("before input");
		
			Path path = Paths.get("/DataAnalysis/src/main/resources/Input/input.json");
			
			Reader input = new FileReader(path.toString());
			
			System.out.println("Input read");
			
			return Arrays.asList(gson.fromJson(input, Answer[].class));
		
	}
}

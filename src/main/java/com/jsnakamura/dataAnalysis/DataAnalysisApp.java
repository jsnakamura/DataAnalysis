package com.jsnakamura.dataAnalysis;

import java.io.IOException;
import java.util.List;

import com.jsnakamura.dataAnalysis.entity.Answer;
import com.jsnakamura.dataAnalysis.helper.DataHelper;

public class DataAnalysisApp {	
	
	public static void main(String[] args) throws IOException {
	
		DataHelper dataHelper = new DataHelper();
		
		List<Answer> answers = dataHelper.loadData();
		
		System.out.println(answers);
	}
}

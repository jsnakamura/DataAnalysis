package com.jsnakamura.dataAnalysis.helper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.jsnakamura.dataAnalysis.entity.Answer;

public class DataHelper {

	private Gson gson = new Gson();

	public List<Answer> loadData() throws IOException {

		System.out.println("before input");

		Path path = Paths.get("/DataAnalysis/src/main/resources/Input/input.json");

		Reader input = new FileReader(path.toString());

		System.out.println("Input read");

		return Arrays.asList(gson.fromJson(input, Answer[].class));

	}

	public List<ArrayList<Answer>> getListByElevators(List<Answer> answers) {

		ArrayList<Answer> elevatorA, elevatorB, elevatorC, elevatorD, elevatorE;

		elevatorA = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getElevador() == 'A')
				.collect(Collectors.toList());

		elevatorB = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getElevador() == 'B')
				.collect(Collectors.toList());

		elevatorC = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getElevador() == 'C')
				.collect(Collectors.toList());

		elevatorD = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getElevador() == 'D')
				.collect(Collectors.toList());

		elevatorE = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getElevador() == 'E')
				.collect(Collectors.toList());

		return Lists.newArrayList(elevatorA, elevatorB, elevatorC, elevatorD, elevatorE);
	}

	public List<ArrayList<Answer>> getListByFloors(List<Answer> answers) {

		ArrayList<Answer> floor0, floor1, floor2, floor3, floor4, floor5, floor6, floor7, floor8, floor9, floor10,
				floor11, floor12, floor13, floor14, floor15;

		floor0 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 0)
				.collect(Collectors.toList());

		floor1 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 1)
				.collect(Collectors.toList());

		floor2 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 2)
				.collect(Collectors.toList());

		floor3 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 3)
				.collect(Collectors.toList());

		floor4 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 4)
				.collect(Collectors.toList());

		floor5 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 5)
				.collect(Collectors.toList());

		floor6 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 6)
				.collect(Collectors.toList());

		floor7 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 7)
				.collect(Collectors.toList());

		floor8 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 8)
				.collect(Collectors.toList());

		floor9 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 9)
				.collect(Collectors.toList());

		floor10 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 10)
				.collect(Collectors.toList());

		floor11 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 11)
				.collect(Collectors.toList());

		floor12 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 12)
				.collect(Collectors.toList());

		floor13 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 13)
				.collect(Collectors.toList());

		floor14 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 14)
				.collect(Collectors.toList());

		floor15 = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 15)
				.collect(Collectors.toList());

		return Lists.newArrayList(floor0, floor1, floor2, floor3, floor4, floor5, floor6, floor7, floor8, floor9,
				floor10, floor11, floor12, floor13, floor14, floor15);
	}

	public List<ArrayList<Answer>> getListByShifts(List<Answer> answers) {

		ArrayList<Answer> morningShift, afternoonShift, eveningShift;

		morningShift = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getTurno() == 'M')
				.collect(Collectors.toList());

		afternoonShift = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getTurno() == 'V')
				.collect(Collectors.toList());

		eveningShift = (ArrayList<Answer>) answers.stream().filter(answer -> answer.getTurno() == 'N')
				.collect(Collectors.toList());

		return Lists.newArrayList(morningShift, afternoonShift, eveningShift);
	}
}

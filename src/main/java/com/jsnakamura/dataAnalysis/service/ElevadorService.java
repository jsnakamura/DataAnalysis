package com.jsnakamura.dataAnalysis.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jsnakamura.dataAnalysis.entity.Answer;

public class ElevadorService implements IElevadorService {

	private List<Answer> answers;

	public ElevadorService(List<Answer> answers) {
		this.answers = answers;
	}

	private List<ArrayList<Answer>> getListByFloors() {

		List<ArrayList<Answer>> result = new ArrayList<ArrayList<Answer>>();

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 0)
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 1)
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 2)
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 3)
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 4)
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 5)
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 6)
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 7)
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 8)
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 9)
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 10)
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 11)
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 12)
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 13)
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 14)
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getAndar() == 15)
				.collect(Collectors.toList()));

		return result.stream().filter(list -> !list.isEmpty()).collect(Collectors.toList());
	}

	private List<ArrayList<Answer>> getListByElevators() {

		List<ArrayList<Answer>> result = new ArrayList<ArrayList<Answer>>();

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getElevador() == 'A')
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getElevador() == 'B')
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getElevador() == 'C')
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getElevador() == 'D')
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getElevador() == 'E')
				.collect(Collectors.toList()));

		return result.stream().filter(list -> !list.isEmpty()).collect(Collectors.toList());
	}

	private List<ArrayList<Answer>> getListByShifts() {

		List<ArrayList<Answer>> result = new ArrayList<ArrayList<Answer>>();

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getTurno() == 'M')
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getTurno() == 'V')
				.collect(Collectors.toList()));

		result.add((ArrayList<Answer>) answers.stream().filter(answer -> answer.getTurno() == 'N')
				.collect(Collectors.toList()));

		return result.stream().filter(list -> !list.isEmpty()).collect(Collectors.toList());
	}

	private float percentage(Character elevator) {
		float total;
		float elevatorUsage;

		total = answers.size();

		elevatorUsage = answers.stream().filter(answer -> answer.getElevador() == elevator).count();

		return Float.parseFloat(new DecimalFormat("#,##0.00").format(elevatorUsage / total).replace(',', '.'));
	}

	private List<Character> elevatorUsage(String frequency) {
		List<Character> elevatorUsage = new ArrayList<Character>();

		List<ArrayList<Answer>> listByElevator = getListByElevators();

		int count = 0;

		if (frequency.toLowerCase() == "more") {
			for (List<Answer> elevator : listByElevator) {
				if (elevatorUsage.isEmpty()) {
					elevatorUsage.add(elevator.get(0).getElevador());
					count = elevator.size();

				} else if (elevator.size() > count) {
					elevatorUsage.clear();
					elevatorUsage.add(elevator.get(0).getElevador());
					count = elevator.size();

				} else if (elevator.size() == count) {
					elevatorUsage.add(elevator.get(0).getElevador());
				}
			}
		} else if (frequency.toLowerCase() == "less") {
			for (List<Answer> elevator : listByElevator) {
				if (elevatorUsage.isEmpty()) {
					elevatorUsage.add(elevator.get(0).getElevador());
					count = elevator.size();

				} else if (elevator.size() < count) {
					elevatorUsage.clear();
					elevatorUsage.add(elevator.get(0).getElevador());
					count = elevator.size();

				} else if (elevator.size() == count) {
					elevatorUsage.add(elevator.get(0).getElevador());
				}
			}
		}
		return elevatorUsage;
	}

	public List<Integer> andarMenosUtilizado() {

		List<Integer> lessUsedFloor = new ArrayList<Integer>();

		List<ArrayList<Answer>> listByFloors = this.getListByFloors();

		int count = 0;

		for (List<Answer> floor : listByFloors) {
			if (lessUsedFloor.isEmpty()) {
				lessUsedFloor.add(floor.get(0).getAndar());
				count = floor.size();

			} else if (floor.size() < count) {
				lessUsedFloor.clear();
				lessUsedFloor.add(floor.get(0).getAndar());
				count = floor.size();

			} else if (floor.size() == count) {
				lessUsedFloor.add(floor.get(0).getAndar());
			}
		}

		return lessUsedFloor;
	}

	public List<Character> elevadorMaisFrequentado() {
		return elevatorUsage("more");
	}

	public List<Character> elevadorMenosFrequentado() {
		return elevatorUsage("less");
	}

	public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {

		List<Character> mostUsedElevatorBiggestFlow = new ArrayList<Character>();

		List<Character> mostUsedElevators = elevadorMaisFrequentado();

		for (Character elevator : mostUsedElevators) {

			List<Answer> completeMostUsedElevators;

			int morningShift = 0;
			int afternoonShift = 0;
			int eveningShift = 0;

			completeMostUsedElevators = answers.stream().filter(answer -> answer.getElevador() == elevator)
					.collect(Collectors.toList());

			for (Answer answer : completeMostUsedElevators) {

				if (answer.getTurno() == 'M') {
					morningShift++;
				} else if (answer.getTurno() == 'V') {
					afternoonShift++;
				} else if (answer.getTurno() == 'N') {
					eveningShift++;
				}
			}

			if ((morningShift >= afternoonShift) && (morningShift >= eveningShift)) {
				mostUsedElevatorBiggestFlow.add('M');

			} else if ((afternoonShift >= morningShift) && (afternoonShift >= eveningShift)) {
				mostUsedElevatorBiggestFlow.add('V');

			} else if ((eveningShift >= morningShift) && (eveningShift >= afternoonShift)) {
				mostUsedElevatorBiggestFlow.add('N');
			}
		}

		return mostUsedElevatorBiggestFlow;
	}

	public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {

		List<Character> leastUsedElevatorLowestFlow = new ArrayList<Character>();

		List<Character> leastUsedElevators = elevadorMenosFrequentado();

		for (Character elevator : leastUsedElevators) {

			List<Answer> completeLeastUsedElevators;

			int morningShift = 0;
			int afternoonShift = 0;
			int eveningShift = 0;

			completeLeastUsedElevators = answers.stream().filter(answer -> answer.getElevador() == elevator)
					.collect(Collectors.toList());			

			for (Answer answer : completeLeastUsedElevators) {
				
				if (answer.getTurno() == 'M') {
					morningShift++;
				} else if (answer.getTurno() == 'V') {
					afternoonShift++;
				} else if (answer.getTurno() == 'N') {
					eveningShift++;
				}
			}

			if ((morningShift <= afternoonShift) && (morningShift <= eveningShift)) {
				leastUsedElevatorLowestFlow.add('M');

			} else if ((afternoonShift <= morningShift) && (afternoonShift <= eveningShift)) {
				leastUsedElevatorLowestFlow.add('V');

			} else if ((eveningShift <= morningShift) && (eveningShift <= afternoonShift)) {
				leastUsedElevatorLowestFlow.add('N');
			}
		}		
		return leastUsedElevatorLowestFlow;
	}

	public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {

		List<Character> elevatorsBiggestFlow = new ArrayList<Character>();

		List<ArrayList<Answer>> listByShifts = getListByShifts();

		int count = 0;

		for (List<Answer> shifts : listByShifts) {
			if (elevatorsBiggestFlow.isEmpty()) {
				elevatorsBiggestFlow.add(shifts.get(0).getTurno());
				count = shifts.size();

			} else if (shifts.size() > count) {
				elevatorsBiggestFlow.clear();
				elevatorsBiggestFlow.add(shifts.get(0).getTurno());
				count = shifts.size();

			} else if (shifts.size() == count) {
				elevatorsBiggestFlow.add(shifts.get(0).getTurno());
			}
		}

		return elevatorsBiggestFlow;
	}

	public float percentualDeUsoElevadorA() {
		return percentage('A');
	}

	public float percentualDeUsoElevadorB() {
		return percentage('B');
	}

	public float percentualDeUsoElevadorC() {
		return percentage('C');
	}

	public float percentualDeUsoElevadorD() {
		return percentage('D');
	}

	public float percentualDeUsoElevadorE() {
		return percentage('E');
	}
}
